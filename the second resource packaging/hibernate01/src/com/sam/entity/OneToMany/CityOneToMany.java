package com.sam.entity.OneToMany;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "onetomany_city")
public class CityOneToMany implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private List<PersonOneToMany> perons = new ArrayList<PersonOneToMany>();

	public CityOneToMany(String name, List<PersonOneToMany> perons) {
		super();
		this.name = name;
		this.perons = perons;
	}

	public CityOneToMany(Integer id) {
		this.id = id;
	}

	public CityOneToMany() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@OneToMany(cascade=CascadeType.ALL,mappedBy="city",fetch=FetchType.LAZY)
	public List<PersonOneToMany> getPerons() {
		return perons;
	}

	public void setPerons(List<PersonOneToMany> perons) {
		this.perons = perons;
	}

}
