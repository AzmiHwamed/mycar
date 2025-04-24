package com.example.mycar;

public class Vehicle {
    String chassis;
    String carburant;
    String immat;
    String owner;

    public Vehicle(String chassis, String carburant, String immat, String owner) {
        this.chassis = chassis;
        this.carburant = carburant;
        this.immat = immat;
        this.owner = owner;
    }

    public String getChassis() {
        return chassis;
    }

    public String getCarburant() {
        return carburant;
    }

    public String getImmat() {
        return immat;
    }

    public String getOwner() {
        return owner;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public void setImmat(String immat) {
        this.immat = immat;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Vehicle() {
    }
}
