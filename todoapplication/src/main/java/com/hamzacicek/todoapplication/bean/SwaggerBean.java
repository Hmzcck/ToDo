package main.java.com.hamzacicek.todoapplication.bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerBean {

    // Swagger
    @Bean
    public OpenAPI getOpenAPIMethod() {
        return new OpenAPI().info(new Info()
                .title("To-Do Application")
                .version("V1.0.0")
                .description("Spring Boot & React Js & MySQL")
        ); //end return new OpenAPI()
    } //end method
} //end class