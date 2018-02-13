package com.estafet.fis.sales.aggregator.restful.sales.enrichment.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_SALES_BATCH")
public class ProductSalesBatch {

	@Id
	@SequenceGenerator(name = "PRODUCT_SALES_BATCH_ID_SEQ", sequenceName = "PRODUCT_SALES_BATCH_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCT_SALES_BATCH_ID_SEQ")
	@Column(name = "PRODUCT_SALES_BATCH_ID")
	private Integer batchId;

	@Column(name = "START_DATE", nullable = false, unique = true)
	private String startDate;

	@OneToMany(mappedBy = "batch", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ProductSale> productSales = new HashSet<ProductSale>();

	public Integer getBatchId() {
		return batchId;
	}

	public String getStartDate() {
		return startDate;
	}

	public Set<ProductSale> getProductSales() {
		return productSales;
	}

}
