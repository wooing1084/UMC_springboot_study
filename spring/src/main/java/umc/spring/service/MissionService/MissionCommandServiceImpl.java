package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.ReviewRequestDTO;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionCommandServiceImpl implements MissionCommandService {

    private final MissionRepository missionRepository;

    private final StoreRepository storeRepository;


    @Override
    @Transactional
    public Mission makeMission (MissionRequestDTO.MakeMissionDTO request) {
        Mission newMission = MissionConverter.toMission(request);

        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.MEMBER_NOT_FOUND));
        newMission.setStore(store);

        return missionRepository.save(newMission);
    }
}
