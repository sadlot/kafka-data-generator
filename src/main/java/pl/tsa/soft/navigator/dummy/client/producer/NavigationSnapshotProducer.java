/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.dummy.client.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import pl.tsa.soft.navigator.dummy.client.model.NavigationSnapshot;

/**
 *
 * @author potatolot
 */
@Service
public class NavigationSnapshotProducer implements MessageProducer<NavigationSnapshot> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NavigationSnapshotProducer.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void publish(NavigationSnapshot message) {
        kafkaTemplate.send("navigationSnapshot", message)
                .whenComplete((result, ex) -> {
                    if (ex == null) {
                        LOGGER.info("Sent message=[" + message
                                + "] with offset=[" + result.getRecordMetadata().offset() + "]");
                    } else {
                        LOGGER.error("Unable to send message", ex);
                    }
                });
    }

}
