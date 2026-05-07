package aiss.peertubeminer.service;

import aiss.peertubeminer.model.videominer.VMCaption;
import aiss.peertubeminer.model.videominer.VMComment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CaptionServiceTest {

    @Autowired
    CaptionService service;

    @Test
    void getCaption() {
        String videoId = "13751932-5a66-45a0-9605-8466d41cc948@peertube2.cpy.re";
        List<VMCaption> captions = service.getCaption(videoId);
        System.out.println(captions);
    }

    @Test
    void postCaption() {
        String videoId = "13751932-5a66-45a0-9605-8466d41cc948@peertube2.cpy.re";
        String vmVideoId = "13751932-5a66-45a0-9605-8466d41cc948@peertube2.cpy.re";
        String apiKey = "guille6767";
        List<VMCaption> captions = service.postCaption(videoId, vmVideoId, apiKey);
        System.out.println(captions);
    }
}