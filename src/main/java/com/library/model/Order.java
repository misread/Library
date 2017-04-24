package com.library.model;

import javax.persistence.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Entity
@Table(name = "ORDER", catalog = "LIBRARY")
public class Order implements java.io.Serializable {

	private Long id;
	private Calendar date;
	private Status status;
	private Book book;
	private Visitor visitor;

	public static enum Status {
		REQUESTED,
		APPROVED,
		REJECTED,
		IN_USE,
		RETURNED
	}

	public Order() {
	}

	public Order(Book book, Visitor visitor) {
		this.date = Calendar.getInstance();
		this.status = Status.REQUESTED;
		this.book = book;
		this.visitor = visitor;
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

	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", length = 20)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "BOOK_ID")
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "VISITOR_ID")
	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	@Override
	public String toString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return "Order [id = " + id
				+ ", date = " + dateFormat.format(date.getTime())
				+ ", status = " + status
				+ ", bookId = " + book
				+ ", visitorId = " + visitor
				+ "]";
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (! (other instanceof Order)) {
			return false;
		}

		final Order order = (Order) other;

		if (order.getId().equals(getId())) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return getId().intValue();
	}

}