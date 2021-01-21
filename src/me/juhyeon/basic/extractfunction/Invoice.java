package me.juhyeon.basic.extractfunction;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;

import java.time.Instant;
import java.util.List;

public class Invoice {

	private final String customer;

	private final List<Order> orders;

	private final Instant dueDate;

	public Invoice(String customer, List<Order> orders) {
		this.customer = customer;
		this.orders = orders;
		this.dueDate = Instant.now();
	}

	public Invoice(String customer, List<Order> orders, Instant dueDate) {
		this.customer = customer;
		this.orders = orders;
		this.dueDate = dueDate;
	}

	public Invoice withDueDate(Instant dueDate) {
		return new Invoice(this.customer, this.orders, dueDate);
	}

	public String getCustomer() {
		return this.customer;
	}

	public List<Order> getOrders() {
		return this.orders == null ? emptyList() : unmodifiableList(this.orders);
	}

	public Instant getDueDate() {
		return dueDate;
	}

	public static class Order {
		private final int amount;

		public Order(int amount) {
			this.amount = amount;
		}

		public int getAmount() {
			return this.amount;
		}
	}
}
