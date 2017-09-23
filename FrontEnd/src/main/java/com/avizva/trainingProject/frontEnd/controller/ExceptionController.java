package com.avizva.trainingProject.frontEnd.controller;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.jasper.JasperException;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

	private static final Logger LOGGER = Logger.getLogger(ExceptionController.class);

	@ExceptionHandler(SQLException.class)
	public ModelAndView sqlExceptionHandler(SQLException e) {
		LOGGER.error("SQL Exception Occured ");
		return new ModelAndView("error");
	}

	@ExceptionHandler(JasperException.class)
	public ModelAndView jasperExceptionHandler(JasperException e) {
		LOGGER.error("Jasper Exception Occured");
		return new ModelAndView("error");
	}

	@ExceptionHandler(IOException.class)
	public ModelAndView ioExceptionHandler(IOException e) {
		LOGGER.error("Input Output Exception Occured");
		return new ModelAndView("error");
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView ExceptionHandler(Exception e){
		LOGGER.error(e + "Exception Found");
		return new ModelAndView("error");
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView nullPointerExceptionHandler(NullPointerException e){
		LOGGER.error("Null Pointer Exception Occured");
		return new ModelAndView("error");
	}
	
	

}
