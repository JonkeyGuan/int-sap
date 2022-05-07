package com.mi.intsap.common;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "outboundFormatAdjustProcessor")
public class OutboundFormatAdjustProcessor {

	private final static Logger log = LoggerFactory.getLogger(OutboundAuthProcessor.class);

	public void process(Exchange ex) throws Exception {
		log.debug("outboundFormatAdjustProcessor");

		String body = ex.getIn().getBody(String.class);
		if (body.indexOf("\"IT_OUT\":\"\"") >= 0) {
			body = body.replaceAll("\"IT_OUT\":\"\"", "\"IT_OUT\":{}");
			ex.getOut().setBody(body, String.class);
		}
 	}

}