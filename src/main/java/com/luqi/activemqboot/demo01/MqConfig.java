package com.luqi.activemqboot.demo01;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

/**
 * @author LUCCI
 * @date 2018/8/24 16:55
 * @Description: 读取配置文件
 * @Modify:
 */
@Configuration
public class MqConfig {
    @Value("${activemq.user:admin}")
    private String usrName;

    @Value("${activemq.password:admin}")
    private String password;

    @Value("${activemq.broker-url}")
    private String brokerUrl;

    @Value("${activemq.trust-all}")
    private boolean trustAllPackages;

    @Value("${activemq.pub-sub-domain}")
    private boolean pubsubdomain;

    @Bean
    public ActiveMQConnectionFactory activeMQConnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL(brokerUrl);
        activeMQConnectionFactory.setUserName(usrName);
        activeMQConnectionFactory.setPassword(password);
        activeMQConnectionFactory.setTrustAllPackages(trustAllPackages);
        return activeMQConnectionFactory;
    }

    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate() {
        return new JmsMessagingTemplate(activeMQConnectionFactory());
    }


    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainer() {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        //设置为发布订阅方式, 默认情况下使用的生产消费者方式
        bean.setPubSubDomain(pubsubdomain);
        bean.setConnectionFactory(activeMQConnectionFactory());
        return bean;
    }

}
