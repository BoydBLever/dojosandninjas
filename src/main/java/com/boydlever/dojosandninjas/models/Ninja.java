package com.boydlever.dojosandninjas.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="ninjas")
public class Ninja {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@NotNull
	@Size(min = 5, max = 200, message="Please make first name 2 characters or more!")
	private String firstName;
	
	@NotNull
	@Size(min = 5, max = 200, message="Please make last name 2 characters or more!")
	private String lastName;
	
	@NotNull
	@Min(value=0, message="Age must be over 18!")
	private Integer age;
	
	//FOREIGN KEY
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="dojo_id") //in MySQL foreign key
	private Dojo dojo; //added one more attribute here, so getters and setters needed
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
		
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	    
	@PrePersist
	protected void onCreate(){
		 this.createdAt = new Date();
	    }
	    
	@PreUpdate
	protected void onUpdate(){
		this.updatedAt = new Date();
		}
	// Zero Argument Constructor
	public Ninja() {}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}

	
}
