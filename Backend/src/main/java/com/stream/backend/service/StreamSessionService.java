package com.stream.backend.service;

import java.util.List;

import com.stream.backend.entity.StreamSession;

public interface StreamSessionService {
    List<StreamSession> getAllStreamSessions();
    List<StreamSession> getStreamSessionsByDeviceId(Integer deviceId);
}
