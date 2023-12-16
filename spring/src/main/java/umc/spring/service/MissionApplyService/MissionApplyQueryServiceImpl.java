package umc.spring.service.MissionApplyService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.User;
import umc.spring.domain.mapping.MissionApply;
import umc.spring.repository.MissionApplyRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionApplyQueryServiceImpl implements MissionApplyQueryService {
    private final MissionApplyRepository missionApplyRepository;
    private final UserRepository userRepository;

    @Override
    public Optional<List<MissionApply>> findByMissionIdAndUserId(Long userId, Long missionId) {
        return missionApplyRepository.findByMissionIdAndUserId(missionId, userId);
    }

    @Override
    public Page<MissionApply> getMissionApplyList(Long userId, Integer page){
        User user = userRepository.findById(userId).get();

        Page<MissionApply> missionPage = missionApplyRepository.findAllByUser(user, PageRequest.of(page, 10));
        return missionPage;
    }
}
