package umc.spring.converter;

import umc.spring.domain.mapping.MissionApply;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.*;

import java.time.LocalDateTime;

public class MissionApplyConverter {

    private MissionRepository missionRepository;
    public static MissionApplyResponseDTO.makeMissionApplyDTO toApplyMissionDTO(MissionApply myMission) {
        return MissionApplyResponseDTO.makeMissionApplyDTO.builder()
                .missionApplyId(myMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MissionApply toMissionApply(MissionApplyRequestDTO.ApplyMissionDTO request) {
        return MissionApply.builder()
                .progress(request.getProgress())
                .build();
    }
}
