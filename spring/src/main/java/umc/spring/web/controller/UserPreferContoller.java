package umc.spring.web.controller;

import umc.spring.domain.FoodCategory;
import umc.spring.domain.mapping.UserPrefer;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreferContoller {
    public static List<UserPrefer> toUserPreferList(List<FoodCategory> foodCategoryList) {
        return foodCategoryList.stream()
                .map(foodCategory -> UserPrefer.builder()
                        .foodCategory(foodCategory)
                        .build()).collect(Collectors.toList());
    }
}
