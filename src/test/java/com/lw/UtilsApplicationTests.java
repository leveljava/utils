package com.lw;

import com.lw.utils.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UtilsApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 测试redis存入数据
     */
    @Test
    void contextLoads() {
        redisUtil.set("redis-key","redis-value");
    }

    /**
     * 测试redis取出数据
     */
    @Test
    void testGet() {
        String value = (String) redisUtil.get("redis-key");
        System.out.println(value);
    }



}
