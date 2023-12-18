package org.example.domain;

import lombok.Data;

@Data
public class Result {
    private boolean flag;
    private Object data;

    public Result(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }
}
