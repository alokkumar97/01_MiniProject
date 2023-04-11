package com.Spring.InReGe.Service;

import com.Spring.InReGe.DTO.SearchRequest;
import com.Spring.InReGe.Entities.CustomersPlan;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

public interface ICustomerService {


   List<String> getPlanName();
   public List<String> getPlanStatus();
   public List<CustomersPlan> searchCust(SearchRequest request);
   public boolean exportExcel(HttpServletResponse response)throws Exception;
   public boolean exportPdf(HttpServletResponse response)throws Exception;
}
