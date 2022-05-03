package com.mi.intsap.kpzt.processor;

import java.util.List;

import com.mi.intsap.kpzt.model.in.IT_IN;
import com.mi.intsap.kpzt.model.in.Item_in;
import com.mi.intsap.kpzt.model.in.JHDBH;
import com.mi.intsap.kpzt.model.in.JHDBH_SAP;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "kpztMapLocalToSapProcessor")
public class MapLocalToSapProcessor {

	private final static Logger log = LoggerFactory.getLogger(MapLocalToSapProcessor.class);

	public void process(Exchange ex) throws Exception {
		log.debug("mapLocalToSapProcessor");
		JHDBH jhdbh = ex.getIn().getBody(JHDBH.class);

		Item_in item_in = Item_in.builder()
				.ZVBELN(jhdbh.getJiaoHuoDan())
				.ZWERKS(jhdbh.getGongChang())
				.ZERDAT(jhdbh.getGengXinRiQi())
				.ZERZET(jhdbh.getGengXinShiJian())
				.build();
		IT_IN it_in = IT_IN.builder().item(List.of(item_in)).build();
		JHDBH_SAP jhdbh_sap = JHDBH_SAP.builder().IT_IN(it_in).build();
		ex.getIn().setBody(jhdbh_sap, JHDBH_SAP.class);

		log.info("Construct: {}", jhdbh_sap);
	}

}