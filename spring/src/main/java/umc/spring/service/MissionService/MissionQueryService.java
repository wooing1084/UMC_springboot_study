package umc.spring.service.MissionService;

import umc.spring.domain.Mission;
import umc.spring.domain.User;

import java.util.Optional;

public interface MissionQueryService {

    Optional<Mission> findMission(Long id);
}
