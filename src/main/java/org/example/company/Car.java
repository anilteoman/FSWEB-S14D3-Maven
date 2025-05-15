package org.example.company;

import java.util.Objects;

public class Car {

    private boolean engine;
    private int cylinders;
    private String name;
    private int wheels;


    public Car(int cylinders, String name) {

        this.cylinders = cylinders;
        this.name = name;

    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", cylinders=" + cylinders +
                ", name='" + name + '\'' +
                ", wheels=" + wheels +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getCylinders() == car.getCylinders() && Objects.equals(getName(), car.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCylinders(), getName());
    }

    public String startEngine(){
        return getClass().getSimpleName()+ " starting engine";
    }

    public String accelerate(){

        return getClass().getSimpleName()+ " is accelerating";
    }

    public String brake(){
        return getClass().getSimpleName()+ " is braking";
    }
}
