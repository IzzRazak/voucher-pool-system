package com.project.voucherpool.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseBody {
    private String message;
    private int statusCode;
    private Object data;

    public ResponseBody(String message, int statusCode, Object data) {
        this.message = message;
        this.statusCode = statusCode;
        this.data = data;
    }
    public ResponseBody() {
    }
}
