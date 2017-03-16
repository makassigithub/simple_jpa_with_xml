package model;



import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import servives.CarService;

public class test {

	public static void main(String[] args) {
		CarService cs = new CarService();
		
		//Create a brand new car and set properties
		Car car = new Car();
		       //car.setId(3);
		       car.setOwner("Bembaya");
		       car.setAge(23);
               car.setConstructDate(new Date());
               car.setMade(Made.Dodge);
               
               // The car is created but exixt as an object (not yet managed) in menory
               //Before create car is called
               
                    Car r = cs.createCar(car);
                    //Create return the Car which live cycle has not yet ended
                    System.out.println("Owner: "+r.getOwner());
                    
                    //updateCarOwer updates the car and keeps it in memory
                    Car c= cs.updateCarOwner(r,"Zanga");
                    
                    System.out.println("Owner: "+c.getOwner());  
                    
                    //When the car is deleted, is removed from de DB but
                    //still exista as pojo in memory and is accessible before being GC.
                    Car cari=  cs.deleteCar(c);                  
                    System.out.println("Owner: "+cari.getOwner());
	}
}
