package com.estafet.fis.sales.aggregator.sales.enrichment.service;

import org.apache.camel.Body;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estafet.fis.sales.aggregator.sales.enrichment.dao.ProductDAO;
import com.estafet.fis.sales.aggregator.sales.enrichment.model.ProductSale;
import com.estafet.fis.sales.aggregator.sales.enrichment.model.ProductSalesBatch;

@Component
public class ProductSalesBatchEnricher {

	@Autowired
	private ProductDAO dao;
	
	public void enrich(@Body ProductSalesBatch batch) {
		for (ProductSale sale : batch.getProductSales()) {
			sale.setProduct(dao.getProduct(sale.getProduct().getId()));
		}
	}
	
}
