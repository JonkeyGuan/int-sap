package com.mi.intsap.kpzt.model.out;

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
public class KPZT {

    private int ev_code;
    private String ev_message;
    private String zvbeln;
    private String zwerks;
    private String zfkstk;
    private String zerdat;
    private String zerzet;

}