package com.bmo.quotes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class QuotesController {

	private static Logger log = LoggerFactory.getLogger(QuotesController.class);
	
	@Autowired
	private QuotesService service; 
	@Autowired
	private NewsServiceProxy newsProxy;
	
	@GetMapping("/quotes/{account}")
	public List<Quote> getQuotes(@PathVariable String account){
		return service.getQuotes(account);
	}
	
	@GetMapping("/quotes/details-feign/{id}")
	public QuoteDetails getQuoteDetailsWithFeign(@PathVariable String id) {
		
		log.info("In QuotesController to fetch quote details for a given quote id: " + id);
		QuoteDetails quoteDetails = newsProxy.getNews(id);
		return quoteDetails;
	}
	
	@GetMapping("/quotes/details/{id}")
	public QuoteDetails getQuoteDetails(@PathVariable String id) {
		
		log.info("In QuotesController to fetch quote details for a given quote id: " + id);
		QuoteDetails quoteDetails = service.getQuoteDetails(id);
		
		// Invoke News Service to get the news for  a given quote id
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		
		log.info("Invoking News service to fetch news for a given quote id: " + id);
		ResponseEntity<List> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/news/{id}",
															List.class, params);
		
		List<String> news = responseEntity.getBody();
		log.info("News for a given quote id: "+ id + " are \n" + news);
		
		quoteDetails.setNews(news);
		return quoteDetails;
	}
}
