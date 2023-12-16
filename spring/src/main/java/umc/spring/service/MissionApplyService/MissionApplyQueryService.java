package umc.spring.service.MissionApplyService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MissionApply;

import java.util.List;
import java.util.Optional;

public interface MissionApplyQueryService {

    Optional<List<MissionApply>> findByMissionIdAndUserId(Long userId, Long missionId);
    Page<MissionApply> getMissionApplyList(Long userId, Integer page);
}
