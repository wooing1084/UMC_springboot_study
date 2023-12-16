package umc.spring.validation.annotation;


import umc.spring.validation.validator.CheckPageValidator;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CheckPageValidator.class)
@Target( {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {
    String message() default "페이지 번호는 1 이상입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
