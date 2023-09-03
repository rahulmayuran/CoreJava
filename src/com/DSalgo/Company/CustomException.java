package com.DSalgo.Company;

public class CustomException extends Exception{

    public CustomException(){

    }

    public CustomException(Throwable cause){
        super(cause);
    }

    public CustomException(String message, Throwable cause){
        super(message, cause);
    }

    public CustomException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
