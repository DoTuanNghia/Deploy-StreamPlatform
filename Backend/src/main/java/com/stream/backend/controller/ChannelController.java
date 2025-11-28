package com.stream.backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stream.backend.service.ChannelService;

@RestController
@RequestMapping("/api/")
public class ChannelController {
    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @GetMapping("/channels")
    public ResponseEntity<Map<String, Object>> home() {
        var channels = channelService.getAllChannels();

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Welcome to Stream Platform Backend!");
        response.put("channels", channels);

        return ResponseEntity.ok(response);
    }
}
