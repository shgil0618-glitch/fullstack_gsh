package com.thejoa703.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SboardDto {
    private int id;
    private int appUserId;
    private String btitle;
    private String bcontent;
    private String bpass;
    private String bfile;
    private int bhit;
    private String bip;
    private String createdAt;
}
