package com.Spring.InReGe.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.Spring.InReGe.DTO.SearchRequest;
import com.Spring.InReGe.Entities.CustomersPlan;
import com.Spring.InReGe.Repository.ICustomerRepository;
import com.Spring.InReGe.Util.ExportExcel;
import com.Spring.InReGe.Util.ExportPDF;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	@Autowired
	private ExportPDF exportPDF;

	@Autowired
	private ExportExcel excel;

	@Override
	public List<CustomersPlan> searchCust(SearchRequest request) {
		CustomersPlan entity = new CustomersPlan();
		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if (null != request.getStatus() && !"".equals(request.getStatus())) {
			entity.setStatus(request.getStatus());
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(startDate, formater);
			entity.setStartDate(date);
		}
		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
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
		List<CustomersPlan> plan = customerRepository.findAll();
		excel.generateExcel(response, plan);
		return true;
	}

	// Pdf Export
	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
		List<CustomersPlan> plan = customerRepository.findAll();
		exportPDF.generatePdf(response, plan);
		return true;
	}

}
