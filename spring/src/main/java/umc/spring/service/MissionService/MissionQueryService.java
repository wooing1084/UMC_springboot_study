package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.User;

import java.util.Optional;

public interface MissionQueryService {

    Optional<Mission> findMission(Long id);

    Page<Mission> getMissionList(Long storeId, Integer page);
}
