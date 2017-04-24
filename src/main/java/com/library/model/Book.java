package com.library.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK", catalog = "LIBRARY")
public class Book implements java.io.Serializable {

	private Long id;
	private String name;
	private Short publicationYear;

	public Book() {
	}

	public Book(String name, Short publicationYear) {
		this.name = name;
		this.publicationYear = publicationYear;
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

	@Column(name = "PUBLICATION_YEAR", length = 4)
	public Short getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Short publicationYear) {
		this.publicationYear = publicationYear;
	}

	@Override
	public String toString() {
		return "Book [id = " + id
				+ ", name = " + name
				+ ", publicationYear = " + publicationYear
				+ "]";
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (! (other instanceof Book)) {
			return false;
		}

		final Book book = (Book) other;

		if (book.getId().equals(getId())) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return getId().intValue();
	}

}