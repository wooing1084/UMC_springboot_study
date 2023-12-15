package umc.spring.validation.annotation;

import umc.spring.validation.validator.CategoriesExistValidator;
import umc.spring.validation.validator.DuplicatedMissionApplyValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DuplicatedMissionApplyValidator.class)
@Target( {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface DuplicatedMissionApply {
    String message() default "이미 신청한 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
