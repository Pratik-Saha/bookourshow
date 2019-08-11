package com.mytectra.learning.bookourshow.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mytectra.learning.bookourshow.web.entity.Error;
import com.mytectra.learning.bookourshow.web.entity.ResponseWrapper;
import com.mytectra.learning.bookourshow.web.entity.ResponseWrapper.Status;
import com.mytectra.learning.bookourshow.web.exception.MovieNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseWrapper<Error> handleMethodArgumentNotValid( MethodArgumentNotValidException ex){
		BindingResult result = ex.getBindingResult();
		
		StringBuilder builder = new StringBuilder();
		result.getFieldErrors().forEach(err -> {
			builder.append("FieldName - " + err.getField());
			//builder.append("\n");
			builder.append(",Value Recived - " + err.getRejectedValue());
			//builder.append("\n");
			builder.append(",Message - " + err.getDefaultMessage());
			
		});
		
		ResponseWrapper<Error> response = new ResponseWrapper<>();
		response.setStatus(Status.INVALID_REQUEST);
		com.mytectra.learning.bookourshow.web.entity.Error error = new Error();
		error.setErrorCode(1112);
		error.setErrorMessage(builder.toString());
		response.setResponse(error);
		return response;	
	 }
	
	@ExceptionHandler(value = {HttpMessageNotReadableException.class})
	@ResponseStatus(code = HttpStatus.BAD_REQUEST )
	public @ResponseBody ResponseWrapper<Error> handleException(Exception exception){
		System.out.println(exception.getClass());
		ResponseWrapper<Error> response = new ResponseWrapper<>();
		response.setStatus(Status.ERROR);
		com.mytectra.learning.bookourshow.web.entity.Error error = new Error();
		error.setErrorCode(1112);
		error.setErrorMessage(exception.getMessage());
		response.setResponse(error);
		return response;
		
	}
	
	@ExceptionHandler(value = {MovieNotFoundException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseWrapper<Error> movieNotFoundException(Exception exception){
		ResponseWrapper<Error> response = new ResponseWrapper<>();
		response.setStatus(Status.INVALID_REQUEST);
		com.mytectra.learning.bookourshow.web.entity.Error error = new Error();
		error.setErrorCode(1114);
		error.setErrorMessage(exception.getMessage());
		response.setResponse(error);
		return response;
		 
	}
	

}
