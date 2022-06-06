package com.example.SinauKodingTask5.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
public class Response implements Serializable {
    Object data;
    String message;
    HttpStatus httpStatus;

    public  Response(Object data, String message, HttpStatus httpStatus){
        this.data=data;
        this.message=message;
        this.httpStatus=httpStatus;
    }
}
