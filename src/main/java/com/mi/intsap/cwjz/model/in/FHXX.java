package com.mi.intsap.cwjz.model.in;

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
public class FHXX {

    private String jiaoHuoDan;
    private String gongChang;
    private String jiaoHuoShiFouYiWangCheng;
    private String gengXinRiQi;
    private String gengXinShiJian;
    
}