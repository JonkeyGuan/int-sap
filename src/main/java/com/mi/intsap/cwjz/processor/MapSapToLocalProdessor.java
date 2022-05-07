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

		GZZT gzzt;
		if (gzzt_sap.getIT_OUT().getItem() != null) {
			Item_out item_out = gzzt_sap.getIT_OUT().getItem().get(0);
			gzzt = GZZT.builder()
					.fanHuiMa(gzzt_sap.getEV_CODE())
					.fanHuiXinXi(gzzt_sap.getEV_MESSAGE())
					.jiaoHuoDan(item_out.getZVBELN())
					.gongChang(item_out.getZWERKS())
					.jiaoHuoShiFouYiWangCheng(item_out.getZWBSTK())
					.gengXinRiQi(item_out.getZERDAT())
					.gengXinShiJian(item_out.getZERZET())
					.gongSiDaiMa(item_out.getBUKRS())
					.piaoJuHao(item_out.getBELNR())
					.caiNian(item_out.getGJAHR())
					.build();
		} else {
			gzzt = GZZT.builder()
					.fanHuiMa(gzzt_sap.getEV_CODE())
					.fanHuiXinXi(gzzt_sap.getEV_MESSAGE())
					.build();
		}

		ex.getIn().setBody(gzzt, GZZT.class);

	}

}