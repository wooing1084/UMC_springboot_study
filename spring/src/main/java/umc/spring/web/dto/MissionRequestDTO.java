package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistStores;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionRequestDTO {
    @Getter
    public static class MakeMissionDTO{
        @NotNull
        String name;
        @NotNull
        String description;
        @NotNull
        Integer point;
        @NotNull
        Integer complete;
        @NotNull
        LocalDate startDate;
        @NotNull
        LocalDate dueDate;
        @ExistStores
        Long storeId;
    }
}
