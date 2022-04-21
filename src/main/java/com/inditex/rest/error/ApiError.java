package com.inditex.rest.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

  @NonNull
  @ApiModelProperty(value = "HttpStatus of the error", dataType = "HttpStatus", example = "500",
      position = 1)
  private HttpStatus status;

  @JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyy hh:mm:ss")
  @ApiModelProperty(value = "Datetime of the error", dataType = "LocalDateTime",
      example = "01/01/2021 12:00:00", position = 2)
  private LocalDateTime date;

  @NonNull
  @ApiModelProperty(value = "Error message", dataType = "String", example = "Some error occurred",
      position = 3)
  private String message;
}
