/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.dummy.client.service;

import com.github.javafaker.Faker;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pl.tsa.soft.navigator.dummy.client.model.SuperNumber;
import pl.tsa.soft.navigator.dummy.client.producer.SuperNumberProducer;

/**
 *
 * @author potatolot
 */
@Service
public class RandomNavigationSnapshotGeneratorService {


    private SuperNumberProducer superNumberProducer;

    public RandomNavigationSnapshotGeneratorService(SuperNumberProducer superNumberProducer) {
        this.superNumberProducer = superNumberProducer;
    }

    @Scheduled(fixedRate = 5000)
    public void send() {
        int number = (int) (Math.random() * 10) + 1;
        Faker faker = new Faker();
        SuperNumber superNumber = new SuperNumber(number, new Date().getTime(), 
            faker.gameOfThrones().character());
        
        superNumberProducer.publish(superNumber);
    }
}
