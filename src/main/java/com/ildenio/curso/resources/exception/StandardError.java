package com.ildenio.curso.resources.exception;

import java.io.Serializable;

public class StandardError implements Serializable {
    private Integer id;
    private String msg;
    private Long timeStamd;

    public StandardError(Integer id, String msg, Long timeStamd) {
        super();
        this.id = id;
        this.msg = msg;
        this.timeStamd = timeStamd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getTimeStand() {
        return timeStamd;
    }

    public void setTimeStand(Long timeStand) {
        this.timeStamd = timeStand;
    }
}
