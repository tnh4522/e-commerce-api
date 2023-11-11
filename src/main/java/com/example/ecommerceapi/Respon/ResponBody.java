package com.example.ecommerceapi.Respon;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Getter
@Setter
public class ResponBody {
    private String message;
    private Object data;
    private int status;
    public ResponBody(String message, Object data, int status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }
    public ResponBody(String message, int status) {
        this.message = message;
        this.status = status;
    }
}
