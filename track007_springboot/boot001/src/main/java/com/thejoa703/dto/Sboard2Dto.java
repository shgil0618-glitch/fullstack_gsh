package com.thejoa703.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sboard2Dto {

    private int id;            // ID
    private int appUserId;     // APP_USER_ID
    private String btitle;      // BTITLE
    private String bcontent;    // BCONTENT
    private String bpass;       // BPASS
    private String bfile;       // BFILE
    private int bhit;       // BHIT
    private String bip;         // BIP
    private String createdAt; // CREATED_AT
}

