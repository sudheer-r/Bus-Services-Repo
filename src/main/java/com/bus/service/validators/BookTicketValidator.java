package com.bus.service.validators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bus.service.beans.Ticket;

@Component("ticketValidator")
public class BookTicketValidator implements Validator {
	private static final Logger logger = Logger.getLogger(BookTicketValidator.class);
	private static final String TICKET_DATE_PATTERN = "yyyy-MM-dd";

	@Override
	public boolean supports(Class<?> clazz) {
		return Ticket.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object ticketObj, Errors errors) {
		Ticket ticket = (Ticket) ticketObj;
		if (!(getCurrentDate().equals(ticket.getDate()))) {
			logger.info("Date field value: " + errors.getFieldValue("date"));
			errors.rejectValue("date", "ticket.date.invalid", "Invalid Date");

		}
		ValidationUtils.rejectIfEmpty(errors, "destination", "Invalid source");

	}

	private String getCurrentDate() {
		return LocalDate.now().format(DateTimeFormatter.ofPattern(TICKET_DATE_PATTERN));
	}

}
