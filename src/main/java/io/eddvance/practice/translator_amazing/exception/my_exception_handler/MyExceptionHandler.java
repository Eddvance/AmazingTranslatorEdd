package io.eddvance.practice.translator_amazing.exception.my_exception_handler;

import io.eddvance.practice.translator_amazing.exception.translation_not_found_exception.TranslationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler
    public ModelAndView handleTranslationNotFound(TranslationNotFoundException tr) {
        ModelAndView mav = new ModelAndView("error-handler");
        mav.addObject("status", tr.getStatusCode());
        mav.addObject("errorMessage", tr.getReason());
        return mav;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleGeneralException(Exception ex) {
        ModelAndView mav = new ModelAndView("error-handler");
        mav.addObject("status", HttpStatus.INTERNAL_SERVER_ERROR);
        mav.addObject("errorMessage", ex.getMessage());
        return mav;
    }
}