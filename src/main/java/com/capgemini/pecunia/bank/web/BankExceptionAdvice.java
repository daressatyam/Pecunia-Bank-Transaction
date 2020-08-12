package com.capgemini.pecunia.bank.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.pecunia.bank.exceptions.AccountNotFoundException;
import com.capgemini.pecunia.bank.exceptions.TransactionException;
import com.capgemini.pecunia.bank.dto.ErrorMessage;
/*
 * 
 */
@RestControllerAdvice
public class BankExceptionAdvice {

	@ExceptionHandler({ AccountNotFoundException.class })
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleNotFoundException(Exception ex) {
		return new ErrorMessage(ex.getMessage());

	}

	@ExceptionHandler({ TransactionException.class })
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleBadREquestException(Exception ex) {
		return new ErrorMessage(ex.getMessage());

	}
}
