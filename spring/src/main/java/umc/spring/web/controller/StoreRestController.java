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
import umc.spring.converter.MissionConverter;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.validation.annotation.ExistStores;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/store")
@Validated
public class StoreRestController {
    private final MissionQueryService missionQueryService;

    @GetMapping("/{storeId}/missions")
    @Operation(summary = "가게의 미션 목록 조회", description = "가게의 미션 목록을 조회합니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = io.swagger.annotations.ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = io.swagger.annotations.ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = io.swagger.annotations.ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 1부터 입니다!")
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getReviewList(@ExistStores @PathVariable(name = "storeId") Long storeId, @CheckPage @RequestParam(name = "page") Integer page){
        Integer pageIndex = page - 1;
        return ApiResponse.onSuccess(MissionConverter.missionPreViewListDTO(missionQueryService.getMissionList(storeId, pageIndex)));
    }
}
