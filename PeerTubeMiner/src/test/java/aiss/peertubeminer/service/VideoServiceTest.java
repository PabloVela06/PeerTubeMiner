package aiss.peertubeminer.service;

import aiss.peertubeminer.model.videominer.VMChannel;
import aiss.peertubeminer.model.videominer.VMVideo;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VideoServiceTest {

    @Autowired
    VideoService service;

    @Autowired
    ChannelService service2;

    @Test
    void getVideo() {
        String channelHandle = "13751932-5a66-45a0-9605-8466d41cc948@peertube2.cpy.re";
        List<VMVideo> videos = service.getVideo(channelHandle, 10);
        System.out.println(videos);
    }

    @Test
    void getVideoPeerTube() {
        String channelHandle = "13751932-5a66-45a0-9605-8466d41cc948@peertube2.cpy.re";
        List<VMVideo> videos = service.getVideo(channelHandle, 10);
        System.out.println(videos);
    }

    @Test
    void postVideo() {
        String channelHandle = "13751932-5a66-45a0-9605-8466d41cc948@peertube2.cpy.re";
        String apiKey = "guille6767";
        VMChannel channel = service2.postChannel(channelHandle, apiKey);
        service.postVideo(channelHandle, channel.getId(), 10, apiKey);
        System.out.println(channel);
    }

    @Test
    void testPostVideo() {
        String channelHandle = "13751932-5a66-45a0-9605-8466d41cc948@peertube2.cpy.re";
        String apiKey = "guille6767";
        VMChannel channel = service2.postChannel(channelHandle, apiKey);
        VMVideo video = new VMVideo(UUID.randomUUID().toString(),
                "Nombre",
                "Descripción",
                "Fecha");
        service.postVideo(channel.getId(), video, apiKey);
        System.out.println(video);
    }

    @Test
    void updateVideo() {
        String channelHandle = "13751932-5a66-45a0-9605-8466d41cc948@peertube2.cpy.re";
        String apiKey = "guille6767";
        VMChannel channel = service2.postChannel(channelHandle, apiKey);
        VMVideo video = new VMVideo(UUID.randomUUID().toString(),
                "Nombre",
                "Descripción",
                "Fecha");
        service.postVideo(channel.getId(), video, apiKey);
        VMVideo videoActualizado = service.updateVideo(video, apiKey);
        System.out.println(videoActualizado);
    }
}