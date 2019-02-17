package com.bmo.quotes;

import java.util.List;

public class QuoteDetails {
	
	private String id;
	private String name;
	private double price;
	private double yearLow;
	private double yearHigh;
	private List<String> news;
	
	public QuoteDetails(String id, String name, double price, double yearLow, double yearHigh, List<String> news) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.yearLow = yearLow;
		this.yearHigh = yearHigh;
		this.news = news;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getYearLow() {
		return yearLow;
	}
	public void setYearLow(double yearLow) {
		this.yearLow = yearLow;
	}
	public double getYearHigh() {
		return yearHigh;
	}
	public void setYearHigh(double yearHigh) {
		this.yearHigh = yearHigh;
	}
	public List<String> getNews() {
		return news;
	}
	public void setNews(List<String> news) {
		this.news = news;
	}
	
}
