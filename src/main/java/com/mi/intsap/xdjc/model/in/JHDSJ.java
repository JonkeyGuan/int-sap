package com.mi.intsap.xdjc.model.in;

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
public class JHDSJ {

    private String jiaoHuoDan;
    private String shouDaFang;
    private int dingDanYuFuBaiFenBi;
    private int hangXiangMu;
    private String gongChang;
    private String wuLiaoBianMa;
    private int jiaoHuoShuLiang;
    private String jiBenJiLiangDanWei;
    private int xiaoShouEr;
    private int xiaoXiangSuiEr;
    private String huoBi;
    private String weiHuBiaoShi;
    private String gengXinRiQi;
    private String gengXinShiJian;
    
}