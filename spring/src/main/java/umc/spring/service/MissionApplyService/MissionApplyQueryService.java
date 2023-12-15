package umc.spring.service.MissionApplyService;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MissionApply;

import java.util.List;
import java.util.Optional;

public interface MissionApplyQueryService {

    Optional<List<MissionApply>> findByMissionIdAndUserId(Long userId, Long missionId);
}
