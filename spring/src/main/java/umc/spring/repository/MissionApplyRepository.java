package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import umc.spring.domain.mapping.MissionApply;

import java.util.List;
import java.util.Optional;

public interface MissionApplyRepository extends JpaRepository<MissionApply, Long> {

    @Query(value = "select * from mission_apply where mission_id = :missionId and user_id = :userId" ,nativeQuery = true)
    Optional<List<MissionApply>> findByMissionIdAndUserId(@Param("missionId") Long missionId, @Param("userId") Long userId);
}
