package com.thejoa703.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserAuthDto {
	private String email;
	private String password;
	private List<AuthDto> authList;
}
