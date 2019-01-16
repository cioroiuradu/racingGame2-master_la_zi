package org.fasttrackit;

import org.fasttrackit.cheater.CheatingCar;

/**
 * Hello world!
 */

// this is a comment
public class App {
    public static void main(String[] args) {
        // polymorphism - an object can take multiple forms
        Vehicle cheatingCar = new CheatingCar();
        // implementation of accelerate method from CheatingCar will be used
        cheatingCar.accelerate(10, 2);

        // type casting
        ((CheatingCar) cheatingCar).testMethod();


//
//
//        Engine firstEngine = new Engine();
//        firstEngine.manufacturer = "Renault";
//
//        System.out.println(firstEngine);
//
//        CheatingCar cheatingCompetitor= new CheatingCar();
//        cheatingCompetitor.setName("Test1");
//        double distance = cheatingCompetitor.accelerate(70);
//
//        System.out.println("Cheating parcurge distanta de " + distance);

//        new AutoVehicle().accelerate(100);
//
//        // sout prints a message to the console
//        System.out.println(firstEngine.manufacturer);
//
//        // declaring a variable and instantiating a Car object
//        // this is also called initializing a variable
//        Car firstCompetitor = new Car(firstEngine);
//        firstCompetitor.setName("    Dacia   ");
//        firstCompetitor.setColor("black");
//        firstCompetitor.doorCount = 5;
//        firstCompetitor.setMileage(9.5);
//
//        // local variables are variables declared inside a method
//        // they don't receive default values
//        Car secondCompetitor = new Car(new Engine());
//        secondCompetitor.setName("Golf");
//
//        System.out.println(firstEngine.manufacturer);
//        System.out.println(firstCompetitor.engine.manufacturer);
//
//        double traveledDistance =
//                firstCompetitor.accelerate(100, 30);
//
//        Engine autoVehicleEngine = new Engine();
//        autoVehicleEngine.manufacturer = "Renault";
//
//        AutoVehicle autoVehicle = new AutoVehicle(autoVehicleEngine);
    }
}
