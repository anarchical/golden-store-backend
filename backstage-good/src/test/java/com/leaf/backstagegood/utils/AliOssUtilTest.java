package com.leaf.backstagegood.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-03-22 16:14
 */
@SpringBootTest
class AliOssUtilTest {

    @Autowired
    AliOssUtil aliOssUtil;

    @Test
    public void testOSS(){
        aliOssUtil.getOssClient();
    }

}
