package com.bmo.quotes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class QuotesService {

	private static List<Quote> quotes = new ArrayList<>(); 
	static {
		quotes.add(new Quote("100", "BMO"));
		quotes.add(new Quote("101", "ABN"));
		quotes.add(new Quote("102", "DEL"));
		quotes.add(new Quote("103", "IBM"));
		quotes.add(new Quote("104", "BOA"));
	}
	
	public List<Quote> getQuotes(String account){
		
		return  quotes;
	}
	
	public QuoteDetails getQuoteDetails(String id) {
		
		return new QuoteDetails("100", "BMO", 100, 70, 150, null, null);
	}
}
