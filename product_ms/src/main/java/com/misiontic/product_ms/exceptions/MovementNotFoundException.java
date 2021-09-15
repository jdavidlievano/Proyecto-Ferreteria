package com.misiontic.product_ms.exceptions;

public class MovementNotFoundException extends RuntimeException{
    public MovementNotFoundException(String message){
        super(message);
    }
}
