package com.Spring.InReGe.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.Spring.InReGe.Entities.CustomersPlan;

@Component
public class ExportExcel {

	public void generateExcel(HttpServletResponse response,List<CustomersPlan> details, File file) throws Exception {
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet=workbook.createSheet("Customer Plan");
		
		Row headerRow =sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Sl.No");
		headerRow.createCell(1).setCellValue("Customer Name");
		headerRow.createCell(2).setCellValue("Gender");
		headerRow.createCell(3).setCellValue("Plan Name");
		headerRow.createCell(4).setCellValue("Plan Status");
		headerRow.createCell(5).setCellValue("Start Date");
		headerRow.createCell(6).setCellValue("End Date");
		
		int dataRowCount=1;
		
		
		for(CustomersPlan data : details) {
		Row	 dataRow =sheet.createRow(dataRowCount);
			dataRow.createCell(0).setCellValue(data.getId());
			dataRow.createCell(1).setCellValue(data.getName());
			dataRow.createCell(2).setCellValue(data.getGender());
			dataRow.createCell(3).setCellValue(data.getPlanName());
			dataRow.createCell(4).setCellValue(data.getStatus());
			if(null != data.getStartDate()) {
				dataRow.createCell(5).setCellValue(data.getStartDate()+"");
			}else {
				dataRow.createCell(5).setCellValue("N/A");
			}
			if(null != data.getEndDate()) {
				dataRow.createCell(6).setCellValue(data.getEndDate()+"");
			}else {
				dataRow.createCell(6).setCellValue("N/A");
			}
			
			dataRowCount ++;
		}
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
		
		ServletOutputStream sos = response.getOutputStream();
		workbook.write(sos);
		workbook.close();
		
	}
	
}
