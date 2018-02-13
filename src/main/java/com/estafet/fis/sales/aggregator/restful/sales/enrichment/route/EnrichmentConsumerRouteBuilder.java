package com.estafet.fis.sales.aggregator.restful.sales.enrichment.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

import com.estafet.fis.sales.aggregator.restful.sales.enrichment.model.ProductSalesBatch;

@Component
public class EnrichmentConsumerRouteBuilder extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		 from("amqp:queue:incoming.sales")
		 	.unmarshal().json(JsonLibrary.Jackson, ProductSalesBatch.class)
		 	.enrich().body()
		 	.to("amqp:topic:enriched.sales");
	}

}
