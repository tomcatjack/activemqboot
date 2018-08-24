package com.luqi.activemqboot.demo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LUCCI
 * @date 2018/8/24 17:33
 * @Description: 发消息
 * @Modify:
 */
@RestController
@RequestMapping("/msg")
public class TestMessageController {
    @Autowired
    private MqUtils mqUtils;

    @RequestMapping("/send")
    public String sendMessage() {
        mqUtils.sendQueueMessage("TestQ","队列模式的消息11");
        mqUtils.sendTopicMessage("TestT","发布订阅模式的消息111");
        return "success";
    }
}
