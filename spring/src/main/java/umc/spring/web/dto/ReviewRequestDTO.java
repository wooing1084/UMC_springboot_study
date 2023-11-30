package umc.spring.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class writeDTO{
        String content;
        int stars;
        Long storeId;
    }
}
