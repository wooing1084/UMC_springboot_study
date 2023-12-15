package umc.spring.service.MissionApplyService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MissionApply;
import umc.spring.repository.MissionApplyRepository;
import umc.spring.repository.MissionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionApplyQueryServiceImpl implements MissionApplyQueryService {
    private final MissionApplyRepository missionApplyRepository;

    @Override
    public Optional<List<MissionApply>> findByMissionIdAndUserId(Long userId, Long missionId) {
        return missionApplyRepository.findByMissionIdAndUserId(missionId, userId);
    }
}
