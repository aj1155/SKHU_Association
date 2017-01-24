package me.skhu.controller.model.response;

/**
 * Created by Manki Kim on 2016. 12. 30..
 */
public class AsctApiResponse<T> {
    //Common
    public static final Integer OK = 200;

    public static final Integer INVALID_USERPASSWORD = 1002;
    public static final Integer INVALID_COOKIE = 1003;
    public static final Integer DUPLICATE_LOGINID = 1004;

    public static final Integer EXCEPTION = 3001;
    public static final Integer NOT_FOUND = 3002;
    public static final Integer INVALID_STATUS = 3003;

    public static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private Integer code;
    private T result;

    public AsctApiResponse() {
        this.code = OK;
    }

    public AsctApiResponse(Integer code) {
        this.code = code;
    }

    public AsctApiResponse(T result) {
        this.code = OK;
        this.result = result;
    }

    public AsctApiResponse(Integer code, T result) {
        this.code = code;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public T getResult() {
        return result;
    }
}
