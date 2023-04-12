package com.Spring.InReGe.Service;

import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.Spring.InReGe.DTO.SearchRequest;
import com.Spring.InReGe.Entities.CustomersPlan;
import com.Spring.InReGe.Repository.ICustomerRepository;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerRepository customerRepository;
    
    
    @Override
	public List<CustomersPlan> searchCust(SearchRequest request) {
		CustomersPlan entity = new CustomersPlan();
		if(null != request.getPlanName() && !"" .equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if(null != request.getStatus() && !"" .equals(request.getStatus())) {
			entity.setStatus(request.getStatus());
		}
		if(null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if(null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(startDate, formater);
			entity.setStartDate(date);
		}
		if(null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String endDate = request.getEndDate();
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(endDate, formater);
			entity.setStartDate(date);
		}
		return customerRepository.findAll(Example.of(entity));
	}
    
    
    
    @Override
    public List<String> getPlanName() {
        return customerRepository.getPlanname();
    }
    @Override
    public List<String> getPlanStatus() {
        return customerRepository.getPlanStatus();
    }	
    
    
    
    // Excel Export
	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		
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
		
		List<CustomersPlan> details =customerRepository.findAll();
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
		ServletOutputStream sos = response.getOutputStream();
		workbook.write(sos);
		workbook.close();
		
		return true;
	}
	
	
	//Pdf Export
	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		Document doc = new Document(PageSize.A4);
		PdfWriter.getInstance(doc, response.getOutputStream());
		doc.open();
		Paragraph p = new Paragraph("Customers Plans Info");
		p.setAlignment(Paragraph.ALIGN_CENTER);
		doc.add(p);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setColor(Color.BLUE);
		
		PdfPTable table = new PdfPTable(7);
		table.setSpacingBefore(10);
		
		PdfPCell cell = new PdfPCell();
		cell.setPhrase(new Phrase("Sl.No",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Customer name",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Gender",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Plan Name",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Plan Status",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Start Date",font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("End Date",font));
		table.addCell(cell);
		
		List<CustomersPlan> plan =customerRepository.findAll();
		for(CustomersPlan data : plan ) {
			table.addCell(String.valueOf(data.getId()));
			table.addCell(data.getName());
			table.addCell(data.getGender());
			table.addCell(data.getPlanName());
			table.addCell(data.getStatus());
			table.addCell(data.getStartDate()+"");
			table.addCell(data.getEndDate()+"");
		}		
		doc.add(table);
		doc.close();		
		return true;
	}
	
}
