package com.hz.smartorchard.handler;

import cn.hutool.Hutool;
import cn.hutool.core.date.DateUtil;
import com.hz.smartorchard.common.CommonResult;
import com.hz.smartorchard.exception.SmartOrchardException;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
@Api(tags = "异常处理类")
public class SmartOrchardExceptionHandler {


    @ExceptionHandler(value = SmartOrchardException.class)
    @ResponseBody
    public CommonResult smartOrchardException(SmartOrchardException e){
         log.error("发生异常的时间:{},发生了:{}异常,异常信息是:{}", DateUtil.date(),e.getClass(),e.getMessage());

         return CommonResult.error().code(e.getCode()).msg(e.getMsg());
    }
}
