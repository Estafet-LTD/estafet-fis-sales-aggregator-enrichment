package com.estafet.fis.sales.aggregator.restful.sales.enrichment.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estafet.fis.sales.aggregator.restful.sales.enrichment.model.ProductSalesBatch;
import com.estafet.fis.sales.aggregator.restful.sales.enrichment.service.ProductSalesBatchEnricher;

@Component
public class EnrichmentConsumerRouteBuilder extends RouteBuilder {

	@Autowired
	private ProductSalesBatchEnricher enricher;
		
	@Override
	public void configure() throws Exception {	
		
		 from("amqp:queue:incoming.sales")
		 	.unmarshal()
		 		.json(JsonLibrary.Jackson, ProductSalesBatch.class)
		 	.bean(enricher, "enrich")
		 	.marshal()
		 		.json(JsonLibrary.Jackson)
		 	.to("amqp:topic:enriched.sales");
		 
	}

}
