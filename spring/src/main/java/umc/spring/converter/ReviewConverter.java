package umc.spring.converter;

import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import umc.spring.domain.Review;
import umc.spring.domain.enums.ReviewStars;
import umc.spring.validation.annotation.ExistUsers;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

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


    public static ReviewResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .body(review.getDescription())
                .createdAt(review.getCreatedAt().toLocalDate())
                .ownerNickname(review.getUser().getName())
                .score(review.getStars())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<ReviewResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
