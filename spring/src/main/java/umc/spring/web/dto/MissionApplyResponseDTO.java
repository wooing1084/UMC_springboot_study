package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.mapping.MissionApply;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionApplyResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class makeMissionApplyDTO {
        Long missionApplyId;
        LocalDateTime createdAt;
    }
}
