package aiss.peertubeminer.controller;

import aiss.peertubeminer.model.videominer.VMChannel;
import aiss.peertubeminer.repositories.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/peertubeminer/channel")
public class ChannelController {

    private ChannelRepository channelRepository;

    @Autowired
    public ChannelController(ChannelRepository channelRepository) { this.channelRepository = channelRepository; }

    // GET http://localhost:8081/peertubeminer/channel/{channelHandle}
    @GetMapping("/{channelHandle}")
    public VMChannel findByChannelHandle(@PathVariable String channelHandle,
                                         @RequestParam(defaultValue = "10")int maxVideos,
                                         @RequestParam(defaultValue = "2")int maxComments) {
        return channelRepository.findByChannelHandle(channelHandle, maxVideos, maxComments);
    }

    // POST http://localhost:8081/peertubeminer/channel/{channelHandle}
    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping("/{channelHandle}")
    public VMChannel create(@PathVariable String channelHandle,
                            @RequestParam(defaultValue = "10") int maxVideos,
                            @RequestParam(defaultValue = "2") int maxComments,
                            @RequestHeader("x-api-key") String apiKey) {
        return channelRepository.create(channelHandle, maxVideos, maxComments, apiKey);
    }

}
