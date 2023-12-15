package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MissionApply;
import umc.spring.service.MissionApplyService.MissionApplyQueryService;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.validation.annotation.DuplicatedMissionApply;
import umc.spring.validation.annotation.ExistMissions;
import umc.spring.web.dto.MissionApplyRequestDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DuplicatedMissionApplyValidator implements ConstraintValidator<DuplicatedMissionApply, MissionApplyRequestDTO.ApplyMissionDTO> {

    private final MissionApplyQueryService missiomissionApplyQueryService;

    @Override
    public void initialize(DuplicatedMissionApply constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionApplyRequestDTO.ApplyMissionDTO value, ConstraintValidatorContext context) {
        Optional<List<MissionApply>> target = missiomissionApplyQueryService.findByMissionIdAndUserId(value.getUserId(), value.getMissionId());

        if (target.isPresent()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_APPLICATION_DUPLICATED.toString()).addConstraintViolation();
            return false;
        }

        return true;

    }
}