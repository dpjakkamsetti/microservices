package com.bmo.quotes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuotesController {


	@Autowired
	private QuotesService service; 
	
	
	@GetMapping("/quotes/{account}")
	public List<Quote> getQuotes(@PathVariable String account){
		return service.getQuotes(account);
	}
	
	@GetMapping("/quotes/details/{id}")
	public QuoteDetails getQuoteDetails(@PathVariable String id) {
		return service.getQuoteDetails(id);
	}
}
