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

    private int ev_code;
    private String ev_message;
    private String zvbeln;
    private String zwerks;
    private String zxdjcjg;
    private int zxdce;
    private String zwaerk;
    private String zerdat;
    private String zerzet;

}