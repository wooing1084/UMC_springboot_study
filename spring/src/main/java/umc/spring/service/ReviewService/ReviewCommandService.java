package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.UserRequestDTO;

public interface ReviewCommandService {
    Review writeReview(ReviewRequestDTO.writeDTO request);
}
