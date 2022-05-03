package com.mi.intsap.common;

import java.util.Base64;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component(value = "outboundAuthProcessor")
public class OutboundAuthProcessor {

	private final static Logger log = LoggerFactory.getLogger(OutboundAuthProcessor.class);

	@Value("${sap.username}")
	private String username;

	@Value("${sap.password}")
	private String password;

	public void process(Exchange ex) throws Exception {
		log.debug("outboundAuthProcessor");

		String authString = username + ":" + password;
		byte[] authEncBytes = Base64.getEncoder().encode(authString.getBytes());
		String authStringEnc = new String(authEncBytes);

		ex.getIn().setHeader(HttpHeaders.AUTHORIZATION, "Basic " + authStringEnc);
	}

}