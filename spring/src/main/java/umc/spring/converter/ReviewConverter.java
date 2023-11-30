package umc.spring.converter;

import umc.spring.domain.Review;
import umc.spring.domain.enums.ReviewStars;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

public class ReviewConverter {

    public static ReviewResponseDTO.writeResultDTO toReviewResponseDTO(Review review) {
        return ReviewResponseDTO.writeResultDTO.builder()
                .reviewId(review.getId())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.writeDTO request) {
        ReviewStars stars = null;

        switch (request.getStars()){
            case 1:
                stars = ReviewStars.ONE;
                break;
            case 2:
                stars = ReviewStars.ONE_HALF;
                break;
            case 3:
                stars = ReviewStars.TWO;
                break;
            case 4:
                stars = ReviewStars.TWO_HALF;
                break;
            case 5:
                stars = ReviewStars.THREE;
                break;
            case 6:
                stars = ReviewStars.THREE_HALF;
                break;
            case 7:
                stars = ReviewStars.FOUR;
                break;
            case 8:
                stars = ReviewStars.FOUR_HALF;
                break;
            case 9:
                stars = ReviewStars.FIVE;
                break;
        }


        return Review.builder()
                .description(request.getContent())
                .stars(stars)
                .build();
    }
}
