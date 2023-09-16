package com.calculator;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CalculatorController.class);

	@PostMapping("/arithmeticOperation")
	public double aithmaticOperation(@RequestParam String type_of_operation, @RequestParam double number_1,
			@RequestParam double number_2) {
		double result = 0;
		logger.info("Welcome to Calculator ");
		logger.info("User has chosed operation type:" + type_of_operation);
		logger.info("User has provided input values (number_1:" + number_1 + " & number_2:" + number_2 + ")");
		try {
			if (type_of_operation.equalsIgnoreCase("ADDITION")) {
				result = number_1 + number_2;
				logger.info("Addition of two numbers:" + result);
			}

			else if (type_of_operation.equalsIgnoreCase("SUBTRACTION")) {
				result = number_1 - number_2;
				logger.info("Subtraction of two numbers:" + result);
			} else if (type_of_operation.equalsIgnoreCase("MULTIPLICATION")) {
				result = number_1 * number_2;
				logger.info("Multiplication of two numbers:" + result);
			} else if (type_of_operation.equalsIgnoreCase("DIVISION") && number_2 != 0) {
				result = number_1 / number_2;
				logger.info("Division of two numbers:" + result);
			}
		} catch (Exception e) {
			logger.info(e.getLocalizedMessage());
		}
		return result;
	}
}
