package org.springframework.issues.beans;

import java.util.Arrays;
import java.util.List;

import org.springframework.issues.pojos.Order;
import org.springframework.stereotype.Repository;


@Repository
public class OrderService {
	public List<Order> findAllOrders() {
		return Arrays.asList(new Order(1, 1, 20, true, 5, 100), new Order(2, 1, 8, false, 6, 50), 
				new Order(3, 2, 50, true, 8, 70), new Order(4, 3, 100, true, 5, 90), 
				new Order(5, 3, 2, false, 9, 60), new Order(6, 3, 15, false, 3, 20), 
				new Order(7, 4, 10, true, 6, 200), new Order(8, 2, 25, false, 5, 120),
				new Order(9, 5, 150, false, 5, 250), new Order(10, 3, 5, true, 7, 210));
		
	}
}
