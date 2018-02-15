package com.estafet.fis.sales.aggregator.restful.sales.enrichment.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {

	@Id
	@Column(name = "PRODUCT_ID")
	private Integer id;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "PRODUCT_CATEGORY_ID", nullable = false, referencedColumnName = "PRODUCT_CATEGORY_ID")
	private ProductCategory category;

	public Integer getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public ProductCategory getCategory() {
		return category;
	}

}
