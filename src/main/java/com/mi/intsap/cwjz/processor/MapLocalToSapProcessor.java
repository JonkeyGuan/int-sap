package com.mi.intsap.cwjz.processor;

import java.util.List;

import com.mi.intsap.cwjz.model.in.FHXX;
import com.mi.intsap.cwjz.model.in.FHXX_SAP;
import com.mi.intsap.cwjz.model.in.IT_IN;
import com.mi.intsap.cwjz.model.in.Item_in;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "cwjzMapLocalToSapProcessor")
public class MapLocalToSapProcessor {

	private final static Logger log = LoggerFactory.getLogger(MapLocalToSapProcessor.class);

	public void process(Exchange ex) throws Exception {
		log.debug("mapLocalToSapProcessor");
		FHXX fhxx = ex.getIn().getBody(FHXX.class);

		Item_in item_in = Item_in.builder()
				.ZVBELN(fhxx.getJiaoHuoDan())
				.ZWERKS(fhxx.getGongChang())
				.ZWBSTK(fhxx.getJiaoHuoShiFouYiWangCheng())
				.ZERDAT(fhxx.getGengXinRiQi())
				.ZERZET(fhxx.getGengXinShiJian())
				.build();
		IT_IN it_in = IT_IN.builder().item(List.of(item_in)).build();
		FHXX_SAP fhxx_sap = FHXX_SAP.builder().IT_IN(it_in).build();
		ex.getIn().setBody(fhxx_sap, FHXX_SAP.class);

		log.info("Construct: {}", fhxx_sap);
	}

}