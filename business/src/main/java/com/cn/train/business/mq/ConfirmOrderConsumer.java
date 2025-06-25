package com.cn.train.business.mq;

 import com.alibaba.fastjson.JSON;
 import com.cn.train.business.dto.dto.ConfirmOrderMQDto;
 import com.cn.train.business.service.IConfirmOrderService;
 import jakarta.annotation.Resource;
 import org.apache.rocketmq.common.message.MessageExt;
 import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
 import org.apache.rocketmq.spring.core.RocketMQListener;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.slf4j.MDC;
 import org.springframework.stereotype.Component;

 @Component
 @RocketMQMessageListener(consumerGroup = "default", topic = "CONFIRM_ORDER")
 public class ConfirmOrderConsumer implements RocketMQListener<MessageExt> {

     private static final Logger LOG = LoggerFactory.getLogger(ConfirmOrderConsumer.class);

     @Resource
     private IConfirmOrderService confirmOrderService;

     @Override
     public void onMessage(MessageExt messageExt) {
         byte[] body = messageExt.getBody();
         ConfirmOrderMQDto dto = JSON.parseObject(new String(body), ConfirmOrderMQDto.class);
         MDC.put("LOG_ID", dto.getLogId());
         LOG.info("ROCKETMQ收到消息：{}", new String(body));
         confirmOrderService.doConfirm(dto);
     }
 }
