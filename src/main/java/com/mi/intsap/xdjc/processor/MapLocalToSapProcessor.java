package com.mi.intsap.xdjc.processor;

import java.util.List;

import com.mi.intsap.xdjc.model.in.IT_IN;
import com.mi.intsap.xdjc.model.in.Item_in;
import com.mi.intsap.xdjc.model.in.JHDSJ;
import com.mi.intsap.xdjc.model.in.JHDSJ_SAP;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "xdjcMapLocalToSapProcessor")
public class MapLocalToSapProcessor {

	private final static Logger log = LoggerFactory.getLogger(MapLocalToSapProcessor.class);

	public void process(Exchange ex) throws Exception {
		log.debug("mapLocalToSapProcessor");
		JHDSJ jhdsj = ex.getIn().getBody(JHDSJ.class);

		Item_in item_in = Item_in.builder()
				.ZVBELN(jhdsj.getZvbeln())
				.ZKUNAG(jhdsj.getZkunag())
				.ZDDYFP(jhdsj.getZddyfp())
				.ZPOSNR(jhdsj.getZposnr())
				.ZWERKS(jhdsj.getZwerks())
				.ZMATNR(jhdsj.getZmatnr())
				.ZLFIMM(jhdsj.getZlfimm())
				.ZMEINS(jhdsj.getZmeins())
				.ZNETWR(jhdsj.getZnetwr())
				.ZMWSBP(jhdsj.getZmwsbp())
				.ZWAERK(jhdsj.getZwaerk())
				.ZWHBS(jhdsj.getZwhbs())
				.ZERDAT(jhdsj.getZerdat())
				.ZERZET(jhdsj.getZerzet())
				.build();
		IT_IN it_in = IT_IN.builder().item(List.of(item_in)).build();
		JHDSJ_SAP jhdsj_sap = JHDSJ_SAP.builder().IT_IN(it_in).build();
		ex.getIn().setBody(jhdsj_sap, JHDSJ_SAP.class);

		log.info("Construct: {}", jhdsj_sap);
	}

}