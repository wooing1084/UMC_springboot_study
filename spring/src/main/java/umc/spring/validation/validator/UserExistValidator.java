package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.domain.User;
import umc.spring.service.UserService.UserQueryService;
import umc.spring.validation.annotation.ExistUsers;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserExistValidator implements ConstraintValidator<ExistUsers, Long> {

    private final UserQueryService userQueryService;

    @Override
    public void initialize(ExistUsers constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        Optional<User> target = userQueryService.findUser(value);

        if (target.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
            return false;
        }

        return true;

    }
}
