package com.mi.intsap.kpzt.processor;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "kpztOutboundUriProcessor")
public class OutboundUriProcessor {

	private final static Logger log = LoggerFactory.getLogger(OutboundUriProcessor.class);

	@Value("${sap.kpzt.url}")
	private String url;

	public void process(Exchange ex) throws Exception {
		log.debug("destinationUrlProcessor");
		ex.getIn().setHeader(Exchange.HTTP_URI, url);
	}

}