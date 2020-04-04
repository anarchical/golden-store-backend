//package com.leaf.backstagegood.utils;
//
//import com.aliyun.oss.OSS;
//import com.aliyun.oss.OSSClientBuilder;
//import com.leaf.backstagegood.properties.AliYunOssProperties;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//
///**
// * @author YeYaqiao
// * @email yaqiao.ye@mobilityasia.com.cn
// * @time 2020-03-22 16:00
// */
//@Slf4j
//@Component
//public class AliOssUtil {
//
//    @Autowired
//    AliYunOssProperties aliYunOssProperties;
//
//    public String getImageUrl(MultipartFile file) {
//        OSS ossClient = new OSSClientBuilder().build(
//                aliYunOssProperties.getEndpoint(),
//                aliYunOssProperties.getAccessKeyId(),
//                aliYunOssProperties.getAccessKeySecret());
//        String fileName = file.getOriginalFilename();
//        try {
//            ossClient.putObject(aliYunOssProperties.getBucketName(), fileName, file.getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        assert fileName != null;
//        return aliYunOssProperties.getOssUrl().concat(fileName);
//    }
//
//}
