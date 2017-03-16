package servives;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import model.Car;
import model.Made;

public class CarService {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("carUnit");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction tx = em.getTransaction();

	public Car createCar(Car car) {		
		tx.begin();
		
		//The car is managed (is now an entity) and can be save to DB
		//after persist() is call
		em.persist(car);
		
		//After commit, the entity is saved in the DB
		//Calling commit ends transaction. We could use persit rather, so that we can rollback 
		//without the DB knowing what's going on.
		tx.commit();
		return car;
	}

	public Car updateCarOwner(Car c, String newOwner) {
		
       //manage the car from the DB
		Car cr = em.merge(c);
		tx.begin();
		cr.setOwner(newOwner);
		tx.commit();
		return cr;
	}
	
	public Car deleteCar(Car c) {
		
		//manage the car from the DB
		Car ca = em.merge(c);
		tx.begin();
		em.remove(c);
		tx.commit();
		return ca;
	}
}
