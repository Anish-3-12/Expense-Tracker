package com.anish.expense_tracker_app.exceptions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema(
        description = "Error details DTO (Data Transfer Object) to transfer data between client and server"
)
@Getter
@Setter
public class ErrorDetails {

    @Schema(description = "Error in date time")
    private LocalDateTime timestamp;
    @Schema(description = "Error message")
    private String message;
    @Schema(description = "Error details")
    private String details;
    @Schema(description = "Error Code")
    private String errorCode;
}
