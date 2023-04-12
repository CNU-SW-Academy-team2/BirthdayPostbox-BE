package com.project.BirthdayPostbox.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    OWNER_CODE_NOT_MATCHED(HttpStatus.BAD_REQUEST, "잘못된 owner_code 입니다"),
    ROOM_NOT_FOUND(HttpStatus.NOT_FOUND, "방 정보를 찾을 수 없습니다"),
    MESSAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "메세지 정보를 찾을 수 없습니다"),
    PRESENT_NOT_FOUND(HttpStatus.NOT_FOUND, "선물 정보를 찾을 수 없습니다"),
    ;

    private final HttpStatus httpStatus;
    private final String errormsg;
}
