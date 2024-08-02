package com.hamzacicek.todoapplication.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

// LOMBOK
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResult {

    // Field: s e m  p v c
    private Integer status;
    private String error;
    private String message;
    private String path;
    private Map<String, String> validationErrors;
    private String createdDate = nowDate();


    public ApiResult(Integer status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
        this.createdDate = nowDate();
    }


    public ApiResult(Integer status, String error, String message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.createdDate = nowDate();
    }


    private String nowDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", new Locale("tr", "TR"));
        return LocalDateTime.now().format(formatter);
    }
} //end class
