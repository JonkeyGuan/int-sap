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

    private int ev_code;
    private String ev_message;
    private String zvbeln;
    private String zwerks;
    private String zwbstk;
    private String zerdat;
    private String zerzet;
    private String bukrs;
    private String belnr;
    private String gjahr;

}