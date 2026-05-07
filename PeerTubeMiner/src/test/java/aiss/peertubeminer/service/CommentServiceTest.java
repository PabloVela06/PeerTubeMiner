package aiss.peertubeminer.service;

import aiss.peertubeminer.model.videominer.VMComment;
import aiss.peertubeminer.model.videominer.VMUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommentServiceTest {

    @Autowired
    CommentService service;

    @Test
    void getComment() {
        String videoId = "13751932-5a66-45a0-9605-8466d41cc948@peertube2.cpy.re";
        List<VMComment> comment = service.getComment(videoId, 2);
        System.out.println(comment);
    }

    @Test
    void postComment() {
        String videoId = "13751932-5a66-45a0-9605-8466d41cc948@peertube2.cpy.re";
        String vmVideoId = "13751932-5a66-45a0-9605-8466d41cc948@peertube2.cpy.re";
        String apiKey = "guille6767";
        List<VMComment> comment = service.postComment(videoId, vmVideoId, 2, apiKey);
        System.out.println(comment);
    }
}