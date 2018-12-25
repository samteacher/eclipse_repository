package com.sam.entity.OneToMany;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "onetomany_person")
public class PersonOneToMany implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private CityOneToMany city;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="city_id",referencedColumnName="id")
	public CityOneToMany getCity() {
		return city;
	}

	public void setCity(CityOneToMany city) {
		this.city = city;
	}

	public PersonOneToMany() {
		super();
	}

	public PersonOneToMany(Integer id) {
		this.id = id;
	}

	public PersonOneToMany(String name,CityOneToMany city) {
		super();
		this.name = name;
		this.city = city;
	}

}
