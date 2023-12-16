package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import umc.spring.domain.User;
import umc.spring.domain.mapping.MissionApply;

import java.util.List;
import java.util.Optional;

public interface MissionApplyRepository extends JpaRepository<MissionApply, Long> {
        Page<MissionApply> findAllByUser(User user, PageRequest pageRequest);
        Optional<List<MissionApply>> findByMissionIdAndUserId(Long userId, Long missionId);
}

