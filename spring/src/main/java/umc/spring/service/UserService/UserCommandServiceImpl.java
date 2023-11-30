package umc.spring.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.converter.UserConverter;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.User;
import umc.spring.domain.mapping.UserPrefer;
import umc.spring.repository.FoodCategoryRepository;
import umc.spring.repository.UserRepository;
import umc.spring.web.controller.UserPreferContoller;
import umc.spring.web.dto.UserRequestDTO;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public User joinUser (UserRequestDTO.JoinDTO request) {
        User newUser = UserConverter.toUser(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserPrefer> userPreferList = UserPreferContoller.toUserPreferList(foodCategoryList);

        userPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newUser);});

        return userRepository.save(newUser);
    }
}
