/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.dummy.client.model;

import java.io.Serializable;

/**
 *
 * @author potatolot
 */
public class SuperNumber implements Serializable {

    private int number;

    private long timestamp;

    private String owner;

    public SuperNumber() {
    }

    public SuperNumber(int number, long timestamp, String owner) {
        this.number = number;
        this.timestamp = timestamp;
        this.owner = owner;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

}
