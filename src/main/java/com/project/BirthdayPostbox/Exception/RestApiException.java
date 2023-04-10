package com.project.BirthdayPostbox.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RestApiException extends RuntimeException{
    private final ErrorCode errorCode;
}
