package com.mi.intsap.kpzt.processor;

import com.mi.intsap.kpzt.model.out.Item_out;
import com.mi.intsap.kpzt.model.out.KPZT;
import com.mi.intsap.kpzt.model.out.KPZT_SAP;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "kpztMapSapToLocalProdessor")
public class MapSapToLocalProdessor {

	private final static Logger log = LoggerFactory.getLogger(MapSapToLocalProdessor.class);

	public void process(Exchange ex) throws Exception {
		log.debug("mapSapToLocalProdessor");

		KPZT_SAP kpzt_sap = ex.getIn().getBody(KPZT_SAP.class);

		log.info("Received: {}", kpzt_sap);

		Item_out item_out = kpzt_sap.getIT_OUT().getItem().get(0);
		KPZT kpzt = KPZT.builder()
				.ev_code(kpzt_sap.getEV_CODE())
				.ev_message(kpzt_sap.getEV_MESSAGE())
				.zvbeln(item_out.getZVBELN())
				.zwerks(item_out.getZWERKS())
				.zfkstk(item_out.getZFKSTK())
				.zerdat(item_out.getZERDAT())
				.zerzet(item_out.getZERZET())
				.build();

		ex.getIn().setBody(kpzt, KPZT.class);

	}

}