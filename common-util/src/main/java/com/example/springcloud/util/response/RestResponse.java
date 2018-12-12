package com.example.springcloud.util.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author wangyushuai@fang.com
 * @date 2018/9/26
 * Json响应工具类
 */
public class RestResponse implements Serializable {

    private final static long serialVersionUID = 1L;
    private final static int STATUS_SUCCESS = 200;

    private int status;
    @JsonInclude(JsonInclude.Include.NON_NULL)//不为空时,返回
    private Object data;
    private String message;

    /**
     * 时间戳并格式化
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",locale = "lz",timezone = "GMT+8")
    private Date timestamp;

    /**
     * 程序耗时
     */
    //@JsonIgnore//不返回注解
    private long time;

    public RestResponse(int code, String message, Object data) {
        super();
        this.status = code;
        this.message = message;
        this.data = data;
    }

    public static RestResponse buildSuccess(Object data) {
        return new RestResponse(STATUS_SUCCESS, "success", data);
    }

//    public static RestResponse buildError(Object data) {
//        return new RestResponse(STATUS_SUCCESS, "success", data);
//    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return new Date();
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getTime() {
        return time + "ms";
    }

    public void setTime(long time) {
        this.time = time;
    }

}
