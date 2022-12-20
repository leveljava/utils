package com.lw.utils;

import com.lw.constant.EnumBase;
import lombok.Data;

/**
 * @program: Utils
 * @description: 返回结果集封装类
 * @author: 李伟
 * @create: 2022-12-20 14:52
 **/

@Data
public class Result<T> {
    private static final String OPT_SUCCESS_STATUS = "complete";
    private static final String OPT_ERROR_STATUS = "error";

    /**
     * api执行结果状态：成功:complete 失败: error"
     */
    private String status;

    /**
     * 错误代码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMessage;

    /**
     * 分页查询的总纪录数
     */
    private Long count;

    /**
     * 返回结果数据
     */
    private T resultData;



    public static <T> Result<T> success(T t) {
        return new Result<>("complete", (String)null, (String)null, 0L, t);
    }

    public static Result success() {
        return new Result<>("complete", (String)null, (String)null, 0L, (Object)null);
    }

    public static <T> Result<T> success(T t, Long count) {
        return new Result<>("complete", (String)null, (String)null, count, t);
    }

    public static <T> Result<T> successPage(T t, Long count) {
        return new Result<>("complete", (String)null, (String)null, count, t);
    }

    public static <T> Result<T> fail(String errorCode, String errorMessage) {
        return new Result("error", errorCode, errorMessage, 0L, (Object)null);
    }

    public static <T> Result<T> fail(String errorMessage) {
        return new Result("error", "001", errorMessage, 0L, (Object)null);
    }

    public static <T> Result<T> fail(EnumBase errorCode) {
        return fail(errorCode.getCode(), errorCode.getMessage());
    }

    public static <T> Result<T> failList(EnumBase errorCode, T t) {
        return new Result<>(errorCode.getCode(), errorCode.getMessage(), (String)null, 0L, t);
    }



    @Override
    public String toString() {
        return "Result{" +
                "status='" + status + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", count=" + count +
                ", resultData=" + resultData +
                '}';
    }

    public Result() {
    }

    public Result(String status, String errorCode, String errorMessage, Long count, T resultData) {
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.count = count;
        this.resultData = resultData;
    }
}
