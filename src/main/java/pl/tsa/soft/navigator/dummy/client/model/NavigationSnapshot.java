/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pl.tsa.soft.navigator.dummy.client.model;

/**
 *
 * @author potatolot
 */
public class NavigationSnapshot {

    private double longitude;
    private double latitude;
    private String userName;
    private long snapshotTimestamp;
    private String serviceName;

    public NavigationSnapshot() {
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getSnapshotTimestamp() {
        return snapshotTimestamp;
    }

    public void setSnapshotTimestamp(long snapshotTimestamp) {
        this.snapshotTimestamp = snapshotTimestamp;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public NavigationSnapshot withLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public NavigationSnapshot withLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public NavigationSnapshot withUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public NavigationSnapshot withSnapshotTimestamp(long snapshotTimestamp) {
        this.snapshotTimestamp = snapshotTimestamp;
        return this;
    }

    public NavigationSnapshot withServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }
}
