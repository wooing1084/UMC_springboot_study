package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.makeMissionDTO toMissionResponseDTO(Mission mission) {
        return MissionResponseDTO.makeMissionDTO.builder()
                .missionId(mission.getId())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.MakeMissionDTO request) {
        MissionStatus status = null;

        switch (request.getComplete()){
            case 0:
                status = MissionStatus.ONGOING;
                break;
            case 1:
                status = MissionStatus.FAILED;
                break;
            case 2:
                status = MissionStatus.COMPLETED;
                break;
        }



        return Mission.builder()
                .name(request.getName())
                .description(request.getDescription())
                .point(request.getPoint())
                .complete(status)
                .startDate(request.getStartDate())
                .dueDate(request.getDueDate())
                .build();
    }
}
