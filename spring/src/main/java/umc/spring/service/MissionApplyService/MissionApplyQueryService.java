package umc.spring.service.MissionApplyService;

import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MissionApply;

import java.util.Optional;

public interface MissionApplyQueryService {

    Optional<MissionApply> findMissionApply(Long id);
}
