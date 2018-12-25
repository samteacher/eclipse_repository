package com.sam.entity.music;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "my_special")
public class Special implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String name;
	private Date createTime;
	private Set<Music> musics = new HashSet<Music>();

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;        
	}
	
	@OneToMany(targetEntity=Music.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="special")
	public Set<Music> getMusics() {
		return musics;
	}
	
	public void setMusics(Set<Music> musics) {
		this.musics = musics;
	}

	public Special(String name, Date createTime) {
		super();
		this.name = name;
		this.createTime = createTime;
	}

	public Special(Integer id) {
		this.id = id;
	}

	public Special() {
		super();
	}

}
