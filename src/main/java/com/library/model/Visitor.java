package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VISITOR", catalog = "LIBRARY")
public class Visitor implements java.io.Serializable {

	private Long id;
	private String name;
	private Short age;

	public Visitor() {
	}

	public Visitor(String name, Short age) {
		this.name = name;
		this.age = age;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false, length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "AGE", length = 3)
	public Short getAge() {
		return age;
	}

	public void setAge(Short age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Visitor [id = " + id
				+ ", name = " + name
				+ ", age = " + age
				+ "]";
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (! (other instanceof Visitor)) {
			return false;
		}

		final Visitor visitor = (Visitor) other;

		if (visitor.getId().equals(getId())) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return getId().intValue();
	}

}