package com.Spring.InReGe.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SearchRequest {
	
	 private String gender;
	 private String startDate;
	 private String endDate;
	 private String planName;
	 private String status;
	
	
	
}
