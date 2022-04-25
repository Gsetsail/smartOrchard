package com.hz.smartorchard.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmartOrchardException extends RuntimeException{

    private Integer code;   // 状态码

    private String msg; // 异常信息


    public SmartOrchardException(String msg){
        super(msg);
    }
}
