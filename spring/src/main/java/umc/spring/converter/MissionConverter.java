package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .name(mission.getName())
                .point(mission.getPoint())
                .description(mission.getDescription())
                .createdAt(mission.getCreatedAt().toLocalDate())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){
        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
