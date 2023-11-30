package umc.spring.service.MissionApplyService;

import umc.spring.domain.mapping.MissionApply;
import umc.spring.web.dto.MissionApplyRequestDTO;

public interface MissionApplyCommandService {
    MissionApply applyMission(MissionApplyRequestDTO.ApplyMissionDTO request);
}
