package com.stream.backend.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.stream.backend.entity.StreamSession;

public interface StreamSessionService {

    Page<StreamSession> getAllStreamSessions(int page, int size, String sort);

    Page<StreamSession> getStreamSessionsByDeviceId(Integer deviceId, int page, int size, String sort);

    Page<StreamSession> getStreamSessionsByStreamId(Integer streamId, int page, int size, String sort);

    StreamSession createStreamSession(StreamSession streamSession, Integer deviceId, Integer streamId);

    StreamSession stopStreamSession(StreamSession streamSession);

    StreamSession getStreamSessionById(Integer streamSessionId);

    StreamSession startSessionForStream(Integer streamId);

    StreamSession startScheduledSession(Integer streamSessionId);
}
