package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionApplyConverter;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MissionApply;
import umc.spring.service.MissionApplyService.MissionApplyCommandService;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.web.dto.MissionApplyRequestDTO;
import umc.spring.web.dto.MissionApplyResponseDTO;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MissionApplyCommandService missionApplyCommandService;

    @PostMapping("/make")
    public ApiResponse<MissionResponseDTO.makeMissionDTO> makeMission(@RequestBody @Valid MissionRequestDTO.MakeMissionDTO request){
        Mission mission = missionCommandService.makeMission(request);
        return ApiResponse.onSuccess(MissionConverter.toMissionResponseDTO(mission));
    }

    @PostMapping("/apply")
    public ApiResponse<MissionApplyResponseDTO.makeMissionApplyDTO> applyMission(@RequestBody @Valid MissionApplyRequestDTO.ApplyMissionDTO request){
        MissionApply missionApply = missionApplyCommandService.applyMission(request);
        return ApiResponse.onSuccess(MissionApplyConverter.toApplyMissionDTO(missionApply));
    }
}
