package aiss.peertubeminer.repositories;

import aiss.peertubeminer.etl.Transformer;
import aiss.peertubeminer.model.peertube.Video;
import aiss.peertubeminer.model.videominer.*;
import aiss.peertubeminer.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ChannelRepository {
    @Autowired
    ChannelService channelService;
    @Autowired
    VideoService videoService;
    @Autowired
    CommentService commentService;
    @Autowired
    CaptionService captionService;
    @Autowired
    UserService userService;

    public VMChannel findByChannelHandle(String channelHandle, Integer maxVideos, Integer maxComments){
        List<VMVideo> completeVideos = new ArrayList<>();
        VMChannel channel = channelService.getChannel(channelHandle);
        List<Video> videos = videoService.getVideoPeerTube(channelHandle, maxVideos);
        for(Video video: videos){
            VMUser author = Transformer.createVMUser(video.getUser());
            List<VMComment> comments = commentService.getComment(video.getId().toString(), maxComments);
            List<VMCaption> captions = captionService.getCaption(video.getId().toString());
            VMVideo createdVideo = Transformer.createVMVideo(video);
            createdVideo.setAuthor(author);
            createdVideo.setComments(comments);
            createdVideo.setCaptions(captions);
            completeVideos.add(createdVideo);
        }
        channel.setVideos(completeVideos);
        return channel;
    }

    public VMChannel create(String channelHandle, Integer maxVideos, Integer maxComments, String apiKey) {
        try {
            List<VMVideo> completeVideos = new ArrayList<>();
            VMChannel channel = channelService.postChannel(channelHandle, apiKey);
            List<Video> videos = videoService.getVideoPeerTube(channelHandle, maxVideos);
            for (Video video : videos) {
                VMVideo createdVideo = videoService.postVideo(channel.getId(), Transformer.createVMVideo(video), apiKey);
                VMUser author = userService.postUser(Transformer.createVMUser(video.getUser()), apiKey);
                List<VMComment> comments = commentService.postComment(video.getId().toString(), createdVideo.getId(), maxComments, apiKey);
                List<VMCaption> captions = captionService.postCaption(video.getId().toString(), createdVideo.getId(), apiKey);

                createdVideo.setAuthor(author);
                createdVideo.setComments(comments);
                createdVideo.setCaptions(captions);
                completeVideos.add(createdVideo);

                createdVideo = videoService.updateVideo(createdVideo, apiKey);
            }
            channel.setVideos(completeVideos);
            channelService.updateChannel(channel, apiKey);
            return channel;
        }
        catch (HttpClientErrorException error) {
            System.err.println("Client error " + error);
            return null;
        }
        catch (HttpServerErrorException error) {
            System.err.println("Server error " + error);
            return null;
        }
        catch (UnknownHttpStatusCodeException error) {
            System.err.println("Unknown error " + error);
            return null;
        }
    }

}
