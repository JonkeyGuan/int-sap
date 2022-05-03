package com.mi.intsap.cwjz.model.out;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class GZZT {

    private int fanHuiMa;
    private String fanHuiXinXi;
    private String jiaoHuoDan;
    private String gongChang;
    private String jiaoHuoShiFouYiWangCheng;
    private String gengXinRiQi;
    private String gengXinShiJian;
    private String gongSiDaiMa;
    private String piaoJuHao;
    private String caiNian;

}