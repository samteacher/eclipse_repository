package com.sam.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "person_demo", catalog = "hibernatetest")
public class Person implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Integer age;

	@ElementCollection(targetClass = String.class)
	@CollectionTable(name = "person_school", joinColumns = { @JoinColumn(name = "person_id", nullable = false) })
	@OrderColumn(name = "list_order")
	private List<String> schools;

	@ElementCollection(targetClass = String.class)
	@CollectionTable(name = "person_classmates", joinColumns = { @JoinColumn(name = "person_id", nullable = false) })
	@OrderColumn(name = "array_order")
	private String[] classmates;

	@ElementCollection(targetClass = String.class)
	@CollectionTable(name = "person_firends", joinColumns = { @JoinColumn(name = "person_id", nullable = false) })
	private Set<String> firends;

	@ElementCollection(targetClass = Float.class)
	@CollectionTable(name = "person_scores", joinColumns = { @JoinColumn(name = "person_id", nullable = false) })
	@MapKeyClass(String.class)
	@MapKeyColumn(name = "subject_name")
	@Column(name = "person_score")
	private Map<String, Float> score;

	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "school_name")
	public List<String> getSchools() {
		return schools;
	}

	public void setSchools(List<String> schools) {
		this.schools = schools;
	}

	@Column(name = "classmates_name")
	public String[] getClassmates() {
		return classmates;
	}

	public void setClassmates(String[] classmates) {
		this.classmates = classmates;
	}

	@Column(name = "firends_name")
	public Set<String> getFirends() {
		return firends;
	}

	public void setFirends(Set<String> firends) {
		this.firends = firends;
	}

	public Map<String, Float> getScore() {
		return score;
	}

	public void setScore(Map<String, Float> score) {
		this.score = score;
	}

	public Person(String name, Integer age, List<String> schools,
			String[] classmates, Set<String> firends, Map<String, Float> score) {
		this.name = name;
		this.age = age;
		this.schools = schools;
		this.classmates = classmates;
		this.firends = firends;
		this.score = score;
	}

	public Person(Integer id) {
		this.id = id;
	}

	public Person() {
		super();
	}

}
