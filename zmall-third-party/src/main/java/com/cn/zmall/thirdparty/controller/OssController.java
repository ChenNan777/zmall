package com.cn.zmall.thirdparty.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.MatchMode;
import com.aliyun.oss.model.PolicyConditions;
import com.cn.zmall.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


@RestController
@RequestMapping("oss")
public class OssController {

    @Autowired
    private OSS ossClient;

    @Value("${alibaba.cloud.oss.endpoint}")
    private String endpoint;

    @Value("${alibaba.cloud.oss.bucket}")
    private String bucket;

    @Value("${alibaba.cloud.access-key}")
    private String accessId;

    @Value("${alibaba.cloud.secret-key}")
    private String accessKey;

    @RequestMapping("/policy")
    public R policy() {

        // 拼接 OSS 存储的域名，格式为 https://bucket.endpoint
        String host = "https://" + bucket + "." + endpoint;

        // 以当前日期作为文件夹前缀
        String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String dir = format;

        Map<String, String> respMap = null;

        try {
            // 设置上传策略的过期时间为 30 秒
            long expireTime = 30;
            long expireEndTime = System.currentTimeMillis() + expireTime * 1000;
            Date expiration = new Date(expireEndTime);

            // 配置上传策略条件
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, 1048576000);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);

            // 生成 POST 策略
            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String encodedPolicy = BinaryUtil.toBase64String(binaryData);

            // 计算 POST 请求的签名
            String postSignature = ossClient.calculatePostSignature(postPolicy);

            // 构建响应 Map，包含生成的策略参数
            respMap = new LinkedHashMap<String, String>();
            respMap.put("accessid", accessId);
            respMap.put("policy", encodedPolicy);
            respMap.put("signature", postSignature);
            respMap.put("dir", dir);
            respMap.put("host", host);
            respMap.put("expire", String.valueOf(expireEndTime / 1000));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            ossClient.shutdown();
        }

        return R.ok().put("data", respMap);
    }
}
