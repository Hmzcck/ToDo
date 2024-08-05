package com.hamzacicek.todoapplication.error;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// LOMBOK
@Log4j2
@RequiredArgsConstructor

// API
@RestController
@CrossOrigin
@Component
public class CustomErrorController implements ErrorController {
    private final ErrorAttributes errorAttributes;

    // Field: s m p v
    private Integer status;
    private String message;
    private String path;
    private Map<String, String> validationErrors;


    private ApiResult apiResult;


    @RequestMapping("/error")
    public ApiResult handleError(WebRequest webRequest) {
        // Spring Boot Version>=2.3
        Map<String, Object> attributes = errorAttributes.getErrorAttributes(
                webRequest,
                ErrorAttributeOptions.of(
                        ErrorAttributeOptions.Include.MESSAGE,
                        ErrorAttributeOptions.Include.BINDING_ERRORS)
        ); //end Attributes

        status = (Integer) attributes.get("status");
        message = (String) attributes.get("message");
        path = (String) attributes.get("path");


        apiResult = new ApiResult(status, message, path);


        if (attributes.containsKey("errors")) {
            List<FieldError> fieldErrorList= (List<FieldError>) attributes.get("errors");
            validationErrors=new HashMap<>();

            for (FieldError fieldError : fieldErrorList) {
                validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            apiResult.setValidationErrors(validationErrors);
        }// end if

        return apiResult;
    } //end method

} //end class
