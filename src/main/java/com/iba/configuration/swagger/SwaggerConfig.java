package com.iba.configuration.swagger;

import com.iba.property.SwaggerInfoProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Autowired
	private SwaggerInfoProperty swaggerInfoProperty;
	
	@Bean
	public Docket apiDoc(){
		
		List<ResponseMessage> listOfStandartErrors = new ArrayList<>();
		
		listOfStandartErrors.add(new ResponseMessageBuilder()
			    .code(500)
			    .message("Internal error")
			    .responseModel(new ModelRef("Error"))
			    .build());
		
		listOfStandartErrors.add(new ResponseMessageBuilder()
			      .code(403)
			      .message("Forbidden!")
			      .build());

		
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false)                                   
				.globalResponseMessage(RequestMethod.GET, listOfStandartErrors);
	}
	
	private ApiInfo apiInfo(){
		
		Contact contact = null;

		ApiInfo apiInfo = new ApiInfo(
				swaggerInfoProperty.getTitle(),
				swaggerInfoProperty.getDescription(),
				swaggerInfoProperty.getVersion(),
				swaggerInfoProperty.getTermsOfServiceUrl(),
				//contact,
				"",
				swaggerInfoProperty.getLicense(),
				swaggerInfoProperty.getLicenseUrl());
		
		return apiInfo;
	}

}
