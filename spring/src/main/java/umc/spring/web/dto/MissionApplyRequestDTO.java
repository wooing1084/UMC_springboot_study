package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistMissions;

import javax.validation.constraints.NotNull;

public class MissionApplyRequestDTO {
    @Getter
    public static class ApplyMissionDTO{
        @ExistMissions
        Long missionId;
        Float progress;
    }
}
