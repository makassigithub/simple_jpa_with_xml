package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Voiture")
public class Car {
	
	@Id @GeneratedValue
	private int id;
	
	@Column(name="proprio")
	private String owner;
	
	@Temporal(TemporalType.DATE)
	private Date constructDate;
	
	@Column(name="the_age")
	private int age;
	
	@Column(name="marque")
	private Made made;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Date getConstructDate() {
		return constructDate;
	}
	public void setConstructDate(Date constructDate) {
		this.constructDate = constructDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Made getMade() {
		return made;
	}
	public void setMade(Made made) {
		this.made = made;
	}
	

}
