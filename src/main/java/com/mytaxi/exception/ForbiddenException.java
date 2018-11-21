package com.mytaxi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Driver needs to be online in order to slect a car")
public class ForbiddenException extends Exception
{
    static final long serialVersionUID = -3387516993334229948L;


    public ForbiddenException(String message)
    {
        super(message);
    }

}
