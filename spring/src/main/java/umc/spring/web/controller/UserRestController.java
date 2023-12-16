package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionApplyConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.UserConverter;
import umc.spring.domain.User;
import umc.spring.service.MissionApplyService.MissionApplyQueryServiceImpl;
import umc.spring.service.UserService.UserCommandService;
import umc.spring.service.UserService.UserQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistUsers;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.ReviewResponseDTO;
import umc.spring.web.dto.UserRequestDTO;
import umc.spring.web.dto.UserRequestDTO.JoinDTO;
import umc.spring.web.dto.UserResponseDTO;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Validated
public class UserRestController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;
    private final MissionApplyQueryServiceImpl missionApplyQueryService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDTO request){
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

    @GetMapping("/{userId}/reviews")
    @Operation(summary = "유저의 리뷰 목록 조회", description = "유저의 리뷰 목록을 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = io.swagger.annotations.ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = io.swagger.annotations.ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = io.swagger.annotations.ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 1부터 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistUsers @PathVariable(name = "userId") Long userId, @CheckPage @RequestParam(name = "page") Integer page){
        Integer pageIndex = page - 1;
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(userQueryService.getReviewList(userId, pageIndex)));
    }

    @GetMapping("/{userId}/missions")
    @Operation(summary = "유저의 미션 목록 조회", description = "유저의 미션 목록을 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = io.swagger.annotations.ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = io.swagger.annotations.ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = io.swagger.annotations.ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 1부터 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getMissionApplyList(@ExistUsers @PathVariable(name = "userId") Long userId, @CheckPage @RequestParam(name = "page") Integer page){
        Integer pageIndex = page - 1;
        return ApiResponse.onSuccess(MissionApplyConverter.missionApplyPreViewListDTO(missionApplyQueryService.getMissionApplyList(userId, pageIndex)));
    }
}
