package aiss.peertubeminer.etl;

import aiss.peertubeminer.model.peertube.*;
import aiss.peertubeminer.model.videominer.*;

import java.util.Comparator;
import java.util.UUID;

public class Transformer {

    private static String createId(Integer peerTubeId) {
        return String.format("peertube-%d", peerTubeId);
    }

    public static VMChannel createVMChannel(Channel channel) {
        return new VMChannel(createId(channel.getId()),
                channel.getName(),
                channel.getDescription(),
                channel.getCreatedTime());
    }

    public static VMCaption createVMCaption(Caption caption) {
        return new VMCaption(String.format("peertube-%s-%s",caption.getLanguage().getId(), caption.getLink()),
                caption.getLink(),//name en videoMiner
                caption.getLanguage().getLabel());
    }

    public static VMComment createVMComment(Comment comment) {
        return new VMComment(createId(comment.getId()),
                comment.getText(),
                comment.getCreatedOn());
    }

    public static VMUser createVMUser(User user){
        return new VMUser(user.getName(),
                user.getUserLink(),
                user.getPictureList().stream().max(Comparator.comparing(pic -> pic.getCreatedAt())).get().getPictureLink());
    }

    public static VMVideo createVMVideo(Video video) {
        return new VMVideo(createId(video.getId()),
                video.getName(),
                video.getDescription(),
                video.getReleaseTime());
    }
}
