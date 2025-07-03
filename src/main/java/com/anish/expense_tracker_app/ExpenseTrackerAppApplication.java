package com.anish.expense_tracker_app;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info =@Info(
				title = "Expense Traker REST API documentation",
				description = "Will add it later",
				version = "v1.0",
				contact = @Contact(
						name = "Anish Sabale",
						email = "anishsabale2004@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Expense Traker REST API Documentation."
		)
)
@SpringBootApplication
public class ExpenseTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerAppApplication.class, args);
	}

}
