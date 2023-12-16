package umc.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.TempHandler;
import umc.spring.domain.Review;
import umc.spring.domain.User;
import umc.spring.repository.ReviewRepository;
import umc.spring.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;

    @Override
    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long UserId, Integer page){
        User user = userRepository.findById(UserId).get();

        Page<Review> reviewPage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
        return reviewPage;
    }
}
