package com.estafet.fis.sales.aggregator.restful.sales.enrichment.model;

import java.util.ArrayList;
import java.util.List;

public class ProductSalesBatch {

	private String startDate;

	private List<ProductSale> productSales = new ArrayList<ProductSale>();

	public String getStartDate() {
		return startDate;
	}

	public List<ProductSale> getProductSales() {
		return productSales;
	}

}
