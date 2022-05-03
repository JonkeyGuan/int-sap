package com.mi.intsap.xdjc.model.out;

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
public class XDJCJG {

    private int fanHuiMa;
    private String fanHuiXinXi;
    private String jiaoHuoDan;
    private String gongChang;
    private String xinDaiJianChaJieGuo;
    private int xinDaiChaoEr;
    private String huoBi;
    private String gengXinRiQi;
    private String gengXinShiJian;

}