package com.stream.backend.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.stream.backend.entity.StreamSession;

public interface StreamSessionRepository extends JpaRepository<StreamSession, Integer> {

    // Paging
    Page<StreamSession> findAll(Pageable pageable);

    Page<StreamSession> findByDeviceId(Integer deviceId, Pageable pageable);

    Page<StreamSession> findByStreamId(Integer streamId, Pageable pageable);

    // ACTIVE-only (nếu bạn muốn chỉ hiển thị ACTIVE và phân trang)
    Page<StreamSession> findByStatusIgnoreCase(String status, Pageable pageable);

    // Không dùng List: dùng Optional/exists
    Optional<StreamSession> findFirstByStreamId(Integer streamId);

    boolean existsByStreamId(Integer streamId);
}
