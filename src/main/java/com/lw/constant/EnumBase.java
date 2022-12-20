package com.lw.constant;

/**
 * @program: Utils
 * @description: 枚举基类接口，所有枚举类都要实现该接口，以便于统一处理枚举类的值和描述信息
 * @author: 李伟
 * @create: 2022-12-20 14:57
 **/
public interface EnumBase {
    /**
     * 获取code
     * @return 字符串code
     */
    String getCode();

    /**
     * 获取message
     * @return 字符串message
     */
    String getMessage();
}
