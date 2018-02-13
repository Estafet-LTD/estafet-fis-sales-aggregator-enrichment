package com.estafet.fis.sales.aggregator.restful.sales.enrichment;

import org.apache.activemq.jms.pool.PooledConnectionFactory;
import org.apache.camel.component.amqp.AMQPComponent;
import org.apache.qpid.jms.JmsConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean(name = "amqp-component")
    public AMQPComponent amqpComponent(AMQPConfiguration config) {
		JmsConnectionFactory qpid = new JmsConnectionFactory("sales", "sales",
				"amqp://broker-amq-amqp.sales-aggregator.svc:5672");
		qpid.setTopicPrefix("topic://");
		PooledConnectionFactory factory = new PooledConnectionFactory();
		factory.setConnectionFactory(qpid);
		return new AMQPComponent(factory);
	}
	
}
