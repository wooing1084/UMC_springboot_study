package umc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.mapping.MissionApply;

public interface MissionApplyRepository extends JpaRepository<MissionApply, Long> {
}
