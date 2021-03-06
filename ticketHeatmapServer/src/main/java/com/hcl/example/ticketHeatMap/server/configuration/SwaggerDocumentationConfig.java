package com.hcl.example.ticketHeatMap.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerDocumentationConfig {

    @SuppressWarnings("WeakerAccess")
    ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("Issues by region API")
            .description("Create a browser request and a RESTful API that gets all tickets (IT tickets) for a region, organized in a way suitable for generating a heat map.")
            .license("MIT License")
            .licenseUrl("https://opensource.org/licenses/MIT")
            .termsOfServiceUrl("")
            .version("1.0.0")
            .contact(new Contact("","", "mark.grand@hcl.com"))
            .build();
    }

    @Bean
    public Docket customImplementation(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("com.hcl.example.ticketHeatMap"))
                    .build()
                .directModelSubstitute(org.threeten.bp.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(org.threeten.bp.OffsetDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

}
