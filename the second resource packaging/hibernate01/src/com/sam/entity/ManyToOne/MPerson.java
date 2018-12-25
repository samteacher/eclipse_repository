package com.sam.entity.ManyToOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.sun.scenario.effect.InvertMask;

@Entity
@Table(name = "my_person")
public class MPerson implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Integer age;
	private MAddress address;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 300)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@ManyToOne(targetEntity = MAddress.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	public MAddress getAddress() {
		return address;
	}

	public void setAddress(MAddress address) {
		this.address = address;
	}

	public MPerson() {
		super();
	}

	public MPerson(Integer id) {
		this.id = id;
	}

	public MPerson(String name, Integer age, MAddress address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

}
