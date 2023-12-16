package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.TempHandler;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    public Optional<Mission> findMission(Long id) {
        return missionRepository.findById(id);
    }

    @Override
    public Page<Mission> getMissionList(Long storeId, Integer page){
        Store store = storeRepository.findById(storeId).get();

        Page<Mission> missionPage = missionRepository.findAllByStore(store, PageRequest.of(page, 10));
        return missionPage;
    }
}
