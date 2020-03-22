package com.leaf.backstagegood.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.BucketInfo;
import com.leaf.backstagegood.properties.AliYunOssProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author YeYaqiao
 * @email yaqiao.ye@mobilityasia.com.cn
 * @time 2020-03-22 16:00
 */
@Slf4j
@Component
public class AliOssUtil {

    @Autowired
    AliYunOssProperties aliYunOssProperties;

    public OSS getOssClient() {
        OSS ossClient = new OSSClientBuilder().build(
                aliYunOssProperties.getEndpoint(),
                aliYunOssProperties.getAccessKeyId(),
                aliYunOssProperties.getAccessKeySecret());
        BucketInfo info = ossClient.getBucketInfo(aliYunOssProperties.getBucketName());
        System.out.println("Bucket " + aliYunOssProperties.getBucketName() + "的信息如下：");
        System.out.println("\t数据中心：" + info.getBucket().getLocation());
        System.out.println("\t创建时间：" + info.getBucket().getCreationDate());
        System.out.println("\t用户标志：" + info.getBucket().getOwner());
        return ossClient;
    }


}
