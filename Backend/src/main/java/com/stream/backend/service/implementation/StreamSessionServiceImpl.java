package com.stream.backend.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stream.backend.entity.StreamSession;
import com.stream.backend.repository.StreamSessionRepository;
import com.stream.backend.service.StreamSessionService;

@Service
public class StreamSessionServiceImpl implements StreamSessionService {
    private final StreamSessionRepository streamSessionRepository;
    public StreamSessionServiceImpl(StreamSessionRepository streamSessionRepository) {
        this.streamSessionRepository = streamSessionRepository;
    }
    
    @Override
    public List<StreamSession> getAllStreamSessions() {
        return streamSessionRepository.findAll();
    }

    @Override
    public List<StreamSession> getStreamSessionsByDeviceId(Integer deviceId) {
        return streamSessionRepository.findByDeviceId(deviceId);
    }
}
