package com.mi.intsap.xdjc.processor;

import com.mi.intsap.xdjc.model.out.Item_out;
import com.mi.intsap.xdjc.model.out.XDJCJG;
import com.mi.intsap.xdjc.model.out.XDJCJG_SAP;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value = "xdjcMapSapToLocalProdessor")
public class MapSapToLocalProdessor {

	private final static Logger log = LoggerFactory.getLogger(MapSapToLocalProdessor.class);

	public void process(Exchange ex) throws Exception {
		log.debug("mapSapToLocalProdessor");

		XDJCJG_SAP xdjcjg_sap = ex.getIn().getBody(XDJCJG_SAP.class);

		log.info("Received: {}", xdjcjg_sap);

		Item_out item_out = xdjcjg_sap.getIT_OUT().getItem().get(0);
		XDJCJG xdjcjg = XDJCJG.builder()
				.fanHuiMa(xdjcjg_sap.getEV_CODE())
				.fanHuiXinXi(xdjcjg_sap.getEV_MESSAGE())
				.jiaoHuoDan(item_out.getZVBELN())
				.gongChang(item_out.getZWERKS())
				.xinDaiJianChaJieGuo(item_out.getZXDJCJG())
				.xinDaiChaoEr(item_out.getZXDCE())
				.huoBi(item_out.getZWAERK())
				.gengXinRiQi(item_out.getZERDAT())
				.gengXinShiJian(item_out.getZERZET())
				.build();

		ex.getIn().setBody(xdjcjg, XDJCJG.class);

	}

}