package org.example.arge;

public class CarSkeleton {

    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public CarSkeleton() {

    }

    public CarSkeleton(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String startEngine(){
        System.out.println("className: " + getClass().getSimpleName());
        return getName()+ " starting engine";
    }

    protected void runEngine(CarSkeleton carSkeleton){

        if(carSkeleton instanceof ElectricCar){
           double avgKmPerCharge = ((ElectricCar) carSkeleton).getAvgKmPerCharge();
            int batterySize = ((ElectricCar) carSkeleton).getBatterySize();
        } else if (carSkeleton instanceof HybridCar){
            HybridCar hybridCar = (HybridCar) carSkeleton;

        } else if (carSkeleton instanceof GasPoweredCar){
            GasPoweredCar gasPoweredCar = (GasPoweredCar) carSkeleton;
        } else {
            System.out.println("invalid car");
        }


    }

    public String drive(){
        runEngine(this);
        return getName()+ " is driving";
    }
}
