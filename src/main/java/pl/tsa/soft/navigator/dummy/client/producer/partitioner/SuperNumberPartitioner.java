/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.dummy.client.producer.partitioner;

import java.util.Map;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.tsa.soft.navigator.dummy.client.model.SuperNumber;

/**
 *
 * @author potatolot
 */
public class SuperNumberPartitioner implements Partitioner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SuperNumberPartitioner.class);
    private static final int DEFAULT_PARTITION = 0;

    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object message, byte[] messageBytes, Cluster clstr) {
        if (message instanceof SuperNumber superNumber) {
            if (superNumber.getNumber() == 0) {
                return DEFAULT_PARTITION;
            }
            return superNumber.getNumber() > 5 ? 2 : 1;
        }
        LOGGER.warn("Unknown message in paritioner, sending to default partition");
        return DEFAULT_PARTITION;
    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> map) {

    }

}
