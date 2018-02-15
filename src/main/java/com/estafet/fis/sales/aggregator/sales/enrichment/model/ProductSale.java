package com.estafet.fis.sales.aggregator.sales.enrichment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductSale {

	private Product product;

	private int sold;

	public int getSold() {
		return sold;
	}

	public Product getProduct() {
		return product;
	}

	public ProductSale setProduct(Product product) {
		this.product = product;
		return this;
	}

}
