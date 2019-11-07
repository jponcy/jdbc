package com.tactfactory.ovg.configurations;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.tactfactory.ovg.exceptions.NotFoundException;

@ControllerAdvice
public class ControllerConfiguration {

    @ExceptionHandler(NotFoundException.class)
    public Map<String, Object> errorsRewrite(final NotFoundException e) {

        final Map<String, Object> result = new HashMap<>();

        result.put("date", LocalDateTime.now());
        result.put("error", e.getMessage());

        return result;
    }
}
