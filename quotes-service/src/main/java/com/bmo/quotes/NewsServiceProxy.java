package com.bmo.quotes;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="news-service", url="localhost:8080")
@FeignClient(name="news-service")
@RibbonClient(name="news-service")
public interface NewsServiceProxy {

	@GetMapping("/news/{quoteId}")
	public QuoteDetails getNews(@PathVariable String quoteId);
		
}
