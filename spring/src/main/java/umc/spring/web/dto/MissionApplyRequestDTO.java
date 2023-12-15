package umc.spring.web.dto;

import lombok.Getter;
import lombok.Setter;
import umc.spring.domain.User;
import umc.spring.validation.annotation.DuplicatedMissionApply;
import umc.spring.validation.annotation.ExistMissions;
import umc.spring.validation.annotation.ExistUsers;

import javax.validation.constraints.NotNull;

public class MissionApplyRequestDTO {
    @Getter
    public static class ApplyMissionDTO{
        @ExistMissions
        Long missionId;
        @ExistUsers
        Long userId;
        Float progress;
    }

    @Getter
    public static class ApplyMissionWrapper{
        @DuplicatedMissionApply
        ApplyMissionDTO applyMissionDTO;
    }
}
