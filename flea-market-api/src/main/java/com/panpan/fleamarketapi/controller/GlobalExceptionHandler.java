package com.panpan.fleamarketapi.controller;

//
//import java.util.UUID;
//
//
///**
// * Created by xuxiang on 2018/3/20.
// * 全局异常处理，捕获所有Controller中抛出的异常。
// */
//@Order(2)
//@ControllerAdvice(annotations = Controller.class)
//public class GlobalExceptionHandler {
//
//    @ResponseStatus(HttpStatus.OK)
//    @ExceptionHandler(ServiceException.class)
//    public String noUserExceptionHandler(ServiceException e, Model model) {
//        model.addAttribute("errCode",e.getError().getErrCode());
//        model.addAttribute("errMsg",e.getError().getErrMsg());
//        model.addAttribute("recover",e.getError().getRecover());
//        model.addAttribute("errId",e.getUuid().toString());
//        return "error";
//    }
//
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public String exceptionHandler(Exception e, Model model) {
//        UUID uuid = UUID.randomUUID();
//        model.addAttribute("errCode","50000");
//        model.addAttribute("errMsg","系统内部错误");
//        model.addAttribute("recover","您可以在群内或投诉渠道反馈此问题，" +
//                "我们将会安排专人为您解决");
//        model.addAttribute("errId",uuid.toString());
//        return "error";
//    }
//}
