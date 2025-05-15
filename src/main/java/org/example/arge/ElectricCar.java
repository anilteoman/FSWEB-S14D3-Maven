package org.example.arge;



public class ElectricCar extends CarSkeleton {

   private double avgKmPerCharge;
   private int batterySize;

    public ElectricCar(String name, String description, double avgKmPerCharge, int batterySize) {
        super(name, description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batterySize = batterySize;
    }



    public double getAvgKmPerCharge() {
        return avgKmPerCharge;
    }

    public int getBatterySize() {
        return batterySize;
    }

    @Override
    public String startEngine() {
        runEngine(this);
        return super.startEngine();
    }

    @Override
    public String drive() {
        return "run from Electric car";
    }
}
