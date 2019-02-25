package com.bmo.microservices.newsservice;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

	private static Logger log = LoggerFactory.getLogger(NewsController.class);
	
	@Autowired
	private Environment env;
	
	@GetMapping("/news/{quoteId}")
	public QuoteDetails getNews(@PathVariable String quoteId){
		
		log.info("In NewsController to fetch news for a given quote id "+ quoteId);
		
		QuoteDetails quoteDetails = new QuoteDetails(null, null, 0.0, 0.0, 0.0,
											Arrays.asList("News1","News2","News3","News4","News5"),	
											env.getProperty("local.server.port"));
				
		return quoteDetails ;
	}
}
