package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistStores;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ReviewRequestDTO {

    @Getter
    public static class writeDTO{
        @NotBlank
        String content;
        @NotNull
        int stars;
        @ExistStores
        Long storeId;
    }
}
