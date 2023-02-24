package com.ctacolombia.CTACOLOMBIA.dto.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class GeneralResponse {
    private int code;
    private String message;
    private Object data;
    private Boolean success;
    public static GeneralResponse buildResponseGeneral(HttpStatus httpStatus, String message, Boolean success, Object data){
        return GeneralResponse.builder()
                .code(httpStatus.value())
                .message(message)
                .data(data)
                .success(success).build();
    }
}
