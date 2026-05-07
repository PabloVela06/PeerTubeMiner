package aiss.peertubeminer.service;

import aiss.peertubeminer.model.videominer.VMChannel;
import aiss.peertubeminer.model.videominer.VMComment;
import aiss.peertubeminer.model.videominer.VMUser;
import aiss.peertubeminer.model.videominer.VMVideo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    CommentService service;

    @Autowired
    VideoService videoService;

    @Autowired
    ChannelService channelService;

    @Test
    void getComment() {
        String videoId = "1";
        List<VMComment> comment = service.getComment(videoId, 2);
        System.out.println(comment);
    }

    @Test
    void postComment() {
        String videoId = "1";
        String channelHandle = "13751932-5a66-45a0-9605-8466d41cc948@peertube2.cpy.re";
        String apiKey = "guille6767";
        VMChannel channel = channelService.postChannel(channelHandle, apiKey);
        VMVideo video = new VMVideo(UUID.randomUUID().toString(),
                "Nombre",
                "Descripción",
                "Fecha");
        video = videoService.postVideo(channel.getId(), video, apiKey);
        List<VMComment> comment = service.postComment(videoId, video.getId(), 2, apiKey);
        System.out.println(comment);
    }
}