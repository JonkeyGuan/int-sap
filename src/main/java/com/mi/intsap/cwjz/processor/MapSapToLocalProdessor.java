package com.mi.intsap.cwjz.processor;

import com.mi.intsap.cwjz.model.out.GZZT;
import com.mi.intsap.cwjz.model.out.GZZT_SAP;
import com.mi.intsap.cwjz.model.out.Item_out;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "cwjzMapSapToLocalProdessor")
public class MapSapToLocalProdessor {

	private final static Logger log = LoggerFactory.getLogger(MapSapToLocalProdessor.class);

	public void process(Exchange ex) throws Exception {
		log.debug("mapSapToLocalProdessor");

		GZZT_SAP gzzt_sap = ex.getIn().getBody(GZZT_SAP.class);

		log.info("Received: {}", gzzt_sap);

		Item_out item_out = gzzt_sap.getIT_OUT().getItem().get(0);
		GZZT gzzt = GZZT.builder()
				.ev_code(gzzt_sap.getEV_CODE())
				.ev_message(gzzt_sap.getEV_MESSAGE())
				.zvbeln(item_out.getZVBELN())
				.zwerks(item_out.getZWERKS())
				.zwbstk(item_out.getZWBSTK())
				.zerdat(item_out.getZERDAT())
				.zerzet(item_out.getZERZET())
				.bukrs(item_out.getBUKRS())
				.belnr(item_out.getBELNR())
				.gjahr(item_out.getGJAHR())
				.build();

		ex.getIn().setBody(gzzt, GZZT.class);

	}

}