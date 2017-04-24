package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LIBRARIAN", catalog = "LIBRARY")
public class Librarian implements java.io.Serializable {

	private Long id;
	private String name;

	public Librarian() {
	}

	public Librarian(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Librarian [id = " + id
				+ ", name = " + name
				+ "]";
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (! (other instanceof Librarian)) {
			return false;
		}

		final Librarian librarian = (Librarian) other;

		if (librarian.getId().equals(getId())) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return getId().intValue();
	}

}