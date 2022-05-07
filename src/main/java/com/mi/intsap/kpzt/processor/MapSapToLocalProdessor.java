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

		KPZT kpzt;
		if (kpzt_sap.getIT_OUT().getItem() != null) {
			Item_out item_out = kpzt_sap.getIT_OUT().getItem().get(0);
			kpzt = KPZT.builder()
					.fanHuiMa(kpzt_sap.getEV_CODE())
					.fanHuiXinXi(kpzt_sap.getEV_MESSAGE())
					.jiaoHuoDan(item_out.getZVBELN())
					.gongChang(item_out.getZWERKS())
					.kaiPiaoZhuangTai(item_out.getZFKSTK())
					.gengXinRiQi(item_out.getZERDAT())
					.gengXinShiJian(item_out.getZERZET())
					.build();
		} else {
			kpzt = KPZT.builder()
					.fanHuiMa(kpzt_sap.getEV_CODE())
					.fanHuiXinXi(kpzt_sap.getEV_MESSAGE())
					.build();
		}

		ex.getIn().setBody(kpzt, KPZT.class);

	}

}