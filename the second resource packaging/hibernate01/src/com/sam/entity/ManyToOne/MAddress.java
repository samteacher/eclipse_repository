package com.sam.entity.ManyToOne;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="my_person_address")
public class MAddress implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String address;
	private MPerson person;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "address", length = 100)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public MAddress() {
		super();
	}

	public MAddress(Integer id) {
		this.id = id;
	}

	public MAddress(String address) {
		super();
		this.address = address;
	}

	public MPerson getPerson() {
		return person;
	}
	
	@OneToMany(targetEntity = MAddress.class,cascade=CascadeType.ALL,mappedBy="address")
	public void setPerson(MPerson person) {
		this.person = person;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
