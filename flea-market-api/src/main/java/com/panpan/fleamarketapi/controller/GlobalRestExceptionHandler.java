//package com.panpan.fleamarketapi.controller;
//
//import com.panpan.fleamarketapi.exception.ServiceException;
//import com.panpan.fleamarketapi.exception.SystemError;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.UUID;
//
///**
// * @author kaiqunxiao
// * @date 2018/12/19 下午3:39
// */
//
//@Order(1)
//@RestControllerAdvice(annotations = RestController.class)
//public class GlobalRestExceptionHandler {
//    @Autowired
//    LogRecorder logRecorder;
//
//    @ResponseStatus(HttpStatus.OK)
//    @ExceptionHandler(ServiceException.class)
//    public Object handleServiceException(ServiceException e){
//        logRecorder.error(e);
//        return new RestError(e.getError(),e.getUuid().toString());
//    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public Object handleException(Exception e){
//        UUID uuid = UUID.randomUUID();
//        logRecorder.error(e,uuid);
//        return new RestError(SystemError.ServerInternalError,uuid.toString());
//    }
//}