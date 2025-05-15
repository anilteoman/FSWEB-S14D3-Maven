import org.example.arge.CarSkeleton;
import org.example.arge.ElectricCar;
import org.example.arge.GasPoweredCar;
import org.example.arge.HybridCar;
import org.example.company.Car;
import org.example.company.Ford;
import org.example.company.Holden;
import org.example.company.Mitsubishi;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(ResultAnalyzer.class)
public class MainTest {

    Car car;
    Mitsubishi mitsubishi;
    Holden holden;
    Ford ford;
    CarSkeleton carSkeleton;
    GasPoweredCar gasPoweredCar;
    HybridCar hybridCar;
    ElectricCar electricCar;


    @BeforeEach
    void setUp() {
        car = new Car(4, "Mercedes");
        mitsubishi = new Mitsubishi(4, "Mitsubishi");
        holden = new Holden(4, "Holden");
        ford = new Ford(4, "Ford");
        carSkeleton = new CarSkeleton("Test", "test");
        electricCar = new ElectricCar("Test", "test", 10, 5);
        gasPoweredCar = new GasPoweredCar("Test", "test", 10, 4);
        hybridCar = new HybridCar("Test", "test", 10, 5, 4);
    }

    @DisplayName("Car sınıf değişkenleri doğru access modifier değerlerine sahip mi ?")
    @Test
    public void testCarAccessModifiers() throws NoSuchFieldException {
        Field nameField = car.getClass().getDeclaredField("name");
        Field cylindersField = car.getClass().getDeclaredField("cylinders");
        Field engineField = car.getClass().getDeclaredField("engine");
        Field wheelsField = car.getClass().getDeclaredField("wheels");

        assertEquals(nameField.getModifiers(), 2);
        assertEquals(cylindersField.getModifiers(), 2);
        assertEquals(engineField.getModifiers(), 2);
        assertEquals(wheelsField.getModifiers(), 2);
    }

    @DisplayName("Car sınıf değişkenleri doğru type değerlerine sahip mi ?")
    @Test
    public void testLampAccessModifiers() throws NoSuchFieldException {
        assertThat(car.getName(), instanceOf(String.class));
        assertThat(car.getCylinders(), instanceOf(Integer.class));
    }

    @DisplayName("Car startEngine metodu doğru çalışıyor mu ?")
    @Test
    public void testStartEngineMethod() throws NoSuchFieldException {
        PrintStream saveOut = System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertEquals(car.startEngine(), "the car's engine is starting");
        assertThat(out.toString(), containsString(car.getClass().getSimpleName()));
    }

    @DisplayName("Car accelerate metodu doğru çalışıyor mu ?")
    @Test
    public void testAccelerate() throws NoSuchFieldException {
        PrintStream saveOut = System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertEquals(car.accelerate(), "the car is accelerating");
        assertThat(out.toString(), containsString(car.getClass().getSimpleName()));
    }

    @DisplayName("Car brake metodu doğru çalışıyor mu ?")
    @Test
    public void testBrake() throws NoSuchFieldException {
        PrintStream saveOut = System.out;
        final ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        assertEquals(car.brake(), "the car is braking");
        assertThat(out.toString(), containsString(car.getClass().getSimpleName()));
    }

    @DisplayName("Mitsubishi, Ford, Holden doğru sınıf tipinde mi ?")
    @Test
    public void testChildClassTypes() throws NoSuchFieldException {
        assertThat(mitsubishi, instanceOf(Car.class));
        assertThat(ford, instanceOf(Ford.class));
        assertThat(holden, instanceOf(Holden.class));
    }

    @DisplayName("CarSkeleton sınıf değişkenleri doğru type değerlerine sahip mi ?")
    @Test
    public void testCarSkeletonInstanceTypes() throws NoSuchFieldException {
        assertThat(carSkeleton.getName(), instanceOf(String.class));
        assertThat(carSkeleton.getDescription(), instanceOf(String.class));
    }

    @DisplayName("CarSkeleton metodları doğru type değerlerine sahip mi ?")
    @Test
    public void testCarSkeletonMethodTypes() throws NoSuchMethodException {
        Method startEngineMethod = carSkeleton.getClass().getDeclaredMethod("startEngine");
        Method driveMethod = carSkeleton.getClass().getDeclaredMethod("drive");

        assertEquals(startEngineMethod.getModifiers(), 1);
        assertEquals(driveMethod.getModifiers(), 1);
    }

    @DisplayName("ElectricCar sınıf değişkenleri doğru type değerlerine sahip mi ?")
    @Test
    public void testElectricCar() throws NoSuchMethodException {
        assertThat(electricCar.getName(), instanceOf(String.class));
        assertThat(electricCar.getDescription(), instanceOf(String.class));
        assertThat(electricCar.getBatterySize(), instanceOf(Integer.class));
        assertThat(electricCar.getAvgKmPerCharge(), instanceOf(Double.class));
    }

    @DisplayName("GasPoweredCar sınıf değişkenleri doğru type değerlerine sahip mi ?")
    @Test
    public void testGasPoweredCar() throws NoSuchMethodException {
        assertThat(gasPoweredCar.getName(), instanceOf(String.class));
        assertThat(gasPoweredCar.getDescription(), instanceOf(String.class));
        assertThat(gasPoweredCar.getAvgKmPerLitre(), instanceOf(Double.class));
        assertThat(gasPoweredCar.getCylinders(), instanceOf(Integer.class));
    }

    @DisplayName("HybridCar sınıf değişkenleri doğru type değerlerine sahip mi ?")
    @Test
    public void testHybridCar() throws NoSuchMethodException {
        assertThat(hybridCar.getName(), instanceOf(String.class));
        assertThat(hybridCar.getDescription(), instanceOf(String.class));
        assertThat(hybridCar.getCylinders(), instanceOf(Integer.class));
        assertThat(hybridCar.getAvgKmPerLiter(), instanceOf(Double.class));
        assertThat(hybridCar.getBatterySize(), instanceOf(Integer.class));
    }

    @DisplayName("GasPoweredCar, ElectricCar ve HybridCar sınıf değişkenleri doğru type değerlerine sahip mi ?")
    @Test
    public void testCarTypes() throws NoSuchMethodException {
        assertThat(electricCar, instanceOf(CarSkeleton.class));
        assertThat(gasPoweredCar, instanceOf(CarSkeleton.class));
        assertThat(hybridCar, instanceOf(CarSkeleton.class));
    }
}
