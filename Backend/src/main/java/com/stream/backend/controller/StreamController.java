package com.stream.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stream.backend.service.StreamService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/streams")
public class StreamController {
    private final StreamService streamService;
    public StreamController(StreamService streamService) {
        this.streamService = streamService;
    }

    @GetMapping("/channel/{channelId}")
    public ResponseEntity<Map<String, Object>> getStreamsByChannelId(@PathVariable("channelId") Integer channelId) {
        var streams = streamService.getStreamsByChannelId(channelId);

        Map<String, Object> response = new HashMap<>();

        if (streams == null || streams.isEmpty()) {
            response.put("message", "No stream found for channel");
            response.put("channelId", channelId);
            return ResponseEntity.status(404).body(response);
        }

        response.put("message", "Streams fetched successfully");
        response.put("streams", streams);
        return ResponseEntity.ok(response);
    }
    
}
