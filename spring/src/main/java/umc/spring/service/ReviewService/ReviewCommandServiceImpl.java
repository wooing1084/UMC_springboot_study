package umc.spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.UserConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserPrefer;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.UserRepository;
import umc.spring.web.controller.UserPreferContoller;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;

    private final UserRepository userRepository;

    @Override
    @Transactional
    public Review writeReview (ReviewRequestDTO.writeDTO request) {
        Review newReview = ReviewConverter.toReview(request);

        User user = userRepository.findById(1L).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.MEMBER_NOT_FOUND));
        newReview.setUser(user);

        return reviewRepository.save(newReview);
    }
}
