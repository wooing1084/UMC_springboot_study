package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MissionApply;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.MissionPreViewDTO missionApplyPreViewDTO(MissionApply missionApply){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .name(missionApply.getMission().getName())
                .point(missionApply.getMission().getPoint())
                .description(missionApply.getMission().getDescription())
                .createdAt(missionApply.getMission().getCreatedAt().toLocalDate())
                .build();
    }

    public static MissionResponseDTO.MissionPreViewListDTO missionApplyPreViewListDTO(Page<MissionApply> missionApplyList){
        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionApplyList.stream()
                .map(MissionApplyConverter::missionApplyPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionApplyList.isLast())
                .isFirst(missionApplyList.isFirst())
                .totalPage(missionApplyList.getTotalPages())
                .totalElements(missionApplyList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}
