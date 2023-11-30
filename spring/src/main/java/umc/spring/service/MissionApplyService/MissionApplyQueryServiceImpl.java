package umc.spring.service.MissionApplyService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MissionApply;
import umc.spring.repository.MissionApplyRepository;
import umc.spring.repository.MissionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionApplyQueryServiceImpl implements MissionApplyQueryService {
    private final MissionApplyRepository missionApplyRepository;

    @Override
    public Optional<MissionApply> findMissionApply(Long id) {
        return missionApplyRepository.findById(id);
    }
}
