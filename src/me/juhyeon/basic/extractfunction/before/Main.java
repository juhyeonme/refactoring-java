package me.juhyeon.basic.extractfunction.before;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import me.juhyeon.basic.extractfunction.Invoice;
import me.juhyeon.basic.extractfunction.Invoice.Order;

public class Main {
	public static void main(String[] args) {
		List<Invoice.Order> orders = List.of(
			new Order(1000),
			new Order(2000),
			new Order(3000)
		);
		Invoice invoice = new Invoice("김주현", orders);

		printOwing(invoice);
	}

	private static void printOwing(Invoice invoice) {
		int outstanding = 0;

		System.out.println("*************");
		System.out.println("***고객 채무***");
		System.out.println("*************");

		// 미해결 채무를 개선한다.
		for (Order o : invoice.getOrders()) {
			outstanding += o.getAmount();
		}

		// 마감일 (dueDate) 를 기록한다.
		Instant today = Instant.now();
		invoice = invoice.withDueDate(
			today.plus(30, ChronoUnit.DAYS)
		);

		// 세부사항을 출력한다.
		System.out.println("고객명 : " + invoice.getCustomer());
		System.out.println("채무액 : " + outstanding);
		System.out.println("마감일 : " + invoice.getDueDate());
	}
}
