/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.dummy.client.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import pl.tsa.soft.navigator.dummy.client.model.SuperNumber;

/**
 *
 * @author potatolot
 */
@Component
public class SuperNumberProducer implements MessageProducer<SuperNumber> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SuperNumberProducer.class);
    private KafkaTemplate<String, Object> kafkaTemplate;

    public SuperNumberProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(SuperNumber message) {
        kafkaTemplate.send("superNumber", String.valueOf(message.getNumber()), message)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        LOGGER.info("Sent message={} with offset={} partition ={}[", message.getNumber(),
                                result.getRecordMetadata().offset(),
                                result.getRecordMetadata().partition());
                    } else {
                        LOGGER.error("Unable to send message", ex);
                    }
                });
    }

    private String buildKey(SuperNumber superNumber) {
        return superNumber.getNumber() > 5 ? "highNumber" : "lowNumber";
    }

}
