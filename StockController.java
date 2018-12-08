package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {
	@Autowired
	JmsTemplate jmsTemplate;

	@GetMapping("/stock/{symbol}")
	public void getStockValue(@PathVariable String symbol) {

		jmsTemplate.convertAndSend("StockQueue", symbol);
		
	}

}
