package com.luqi.activemqboot.demo01;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author LUCCI
 * @date 2018/8/24 18:05
 * @Description:  这个是实时监听的,只要你发信息这边就会接收到
 * @Modify:
 */
@Component
@Slf4j
public class Receive {

    @JmsListener(destination = "TestQ")
    public void receiveQueue(Object text) {
        log.info("ConsumerQueue收到的报文为:"+text);
    }

    @JmsListener(destination = "TestT")
    public void receiveTopic(Object text) {
        log.info("ConsumerTopic收到的报文为:"+text);
    }

    @JmsListener(destination = "TestT1")
    public void receiveTopic1(Object text) {
        log.info("ConsumerTopic1收到的报文为:"+text);
    }


}
