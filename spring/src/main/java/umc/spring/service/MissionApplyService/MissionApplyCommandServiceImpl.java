package umc.spring.service.MissionApplyService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.converter.MissionApplyConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.mapping.MissionApply;
import umc.spring.repository.MissionApplyRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.UserRepository;
import umc.spring.web.dto.MissionApplyRequestDTO;

import javax.validation.Valid;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionApplyCommandServiceImpl implements MissionApplyCommandService {

    private final MissionRepository missionRepository;
    private final UserRepository userRepository;
    private final MissionApplyRepository missionApplyRepository;


    @Override
    @Transactional
    public MissionApply applyMission(MissionApplyRequestDTO.ApplyMissionDTO request) {
        MissionApply newMissionApply = MissionApplyConverter.toMissionApply(request);

        Mission mission = missionRepository.findById(request.getMissionId()).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.MEMBER_NOT_FOUND));
        newMissionApply.setMission(mission);

        User user = userRepository.findById(request.getUserId()).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.MEMBER_NOT_FOUND));
        newMissionApply.setUser(user);

        return missionApplyRepository.save(newMissionApply);
    }
}
