package com.Spring.InReGe.Runner;

import com.Spring.InReGe.Entities.CustomersPlan;
import com.Spring.InReGe.Repository.ICustomerRepository;
import com.Spring.InReGe.Service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;



@Configuration
public class CustomRunner implements CommandLineRunner {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {

    	//customerRepository.deleteAll();

        //--------------Cash plan--------------
        CustomersPlan c1 = new CustomersPlan();
        c1.setName("Alok");
        c1.setEmail("alok@gmail.com");
        c1.setGender("Male");
        c1.setStartDate(LocalDate.now().minusMonths(2));
        c1.setEndDate(LocalDate.now().plusMonths(4));
        c1.setPlanName("Cash");
        c1.setStatus("Approved");
        c1.setBenifits(10000.00);

        CustomersPlan c2 = new CustomersPlan();
        c2.setName("Puja");
        c2.setEmail("puja@gmail.com");
        c2.setGender("Fe-Male");
        c2.setStartDate(LocalDate.now().minusMonths(1));
        c2.setEndDate(LocalDate.now().plusMonths(5));
        c2.setPlanName("Cash");
        c2.setStatus("Approved");
        c2.setBenifits(15000.00);

        CustomersPlan c3 = new CustomersPlan();
        c3.setName("Arun");
        c3.setEmail("arun@gmail.com");
        c3.setGender("Male");
        c3.setPlanName("Cash");
        c3.setStatus("Denied");
        c3.setDeniedReason("Document Issue");

        CustomersPlan c4 = new CustomersPlan();
        c4.setName("Prakash");
        c4.setEmail("praksh@gmail.com");
        c4.setGender("Male");
        c4.setPlanName("Cash");
        c4.setStartDate(LocalDate.now().minusMonths(3));
        c4.setStatus("Terminated");
        c4.setTerminateDate(LocalDate.now());
        c4.setTerminateReason("Govt.job");
        //---------------------Food Plan----------------------------
        CustomersPlan c5 = new CustomersPlan();
        c5.setName("Roja");
        c5.setEmail("roja@gmail.com");
        c5.setGender("Fe-Male");
        c5.setStartDate(LocalDate.now());
        c5.setEndDate(LocalDate.now().plusMonths(6));
        c5.setPlanName("Food");
        c5.setStatus("Approved");
        c5.setBenifits(6000.00);

        CustomersPlan c6 = new CustomersPlan();
        c6.setName("Barsha");
        c6.setEmail("barsha@gmail.com");
        c6.setGender("Fe-Male");
        c6.setStartDate(LocalDate.now().minusMonths(1));
        c6.setEndDate(LocalDate.now().plusMonths(5));
        c6.setPlanName("Food");
        c6.setStatus("Approved");
        c6.setBenifits(5000.00);

        CustomersPlan c7 = new CustomersPlan();
        c7.setName("Akash");
        c7.setEmail("akash@gmail.com");
        c7.setGender("Male");
        c7.setPlanName("Food");
        c7.setStatus("Denied");
        c7.setDeniedReason("Property");

        CustomersPlan c8 = new CustomersPlan();
        c8.setName("Ashok");
        c8.setEmail("ashok@gmail.com");
        c8.setGender("Male");
        c8.setPlanName("Food");
        c8.setStartDate(LocalDate.now().minusMonths(3));
        c8.setStatus("Terminated");
        c8.setTerminateDate(LocalDate.now());
        c8.setTerminateReason("Employee");

        //---------------Medical-----------------

        CustomersPlan c9 = new CustomersPlan();
        c9.setName("Robert");
        c9.setEmail("robert@gmail.com");
        c9.setGender("Male");
        c9.setStartDate(LocalDate.now().minusMonths(2));
        c9.setEndDate(LocalDate.now().plusMonths(4));
        c9.setPlanName("Medical");
        c9.setStatus("Approved");
        c9.setBenifits(10000.00);

        CustomersPlan c10 = new CustomersPlan();
        c10.setName("Cathey");
        c10.setEmail("cathey@gmail.com");
        c10.setGender("Fe-Male");
        c10.setStartDate(LocalDate.now().minusMonths(1));
        c10.setEndDate(LocalDate.now().plusMonths(5));
        c10.setPlanName("Medical");
        c10.setStatus("Approved");
        c10.setBenifits(15000.00);

        CustomersPlan c11 = new CustomersPlan();
        c11.setName("Albert");
        c11.setEmail("albert@gmail.com");
        c11.setGender("Male");
        c11.setPlanName("Medical");
        c11.setStatus("Denied");
        c11.setDeniedReason("Document Issue");

        CustomersPlan c12 = new CustomersPlan();
        c12.setName("Joy");
        c12.setEmail("joy@gmail.com");
        c12.setGender("Male");
        c12.setPlanName("Medical");
        c12.setStartDate(LocalDate.now().minusMonths(3));
        c12.setStatus("Terminated");
        c12.setTerminateDate(LocalDate.now());
        c12.setTerminateReason("Govt.job");
        //---------------------Employment Plan----------------------------
        CustomersPlan c13 = new CustomersPlan();
        c13.setName("Buttler");
        c13.setEmail("buttler@gmail.com");
        c13.setGender("Male");
        c13.setStartDate(LocalDate.now());
        c13.setEndDate(LocalDate.now().plusMonths(6));
        c13.setPlanName("Employment");
        c13.setStatus("Approved");
        c13.setBenifits(6000.00);

        CustomersPlan c14 = new CustomersPlan();
        c14.setName("Neels");
        c14.setEmail("neels@gmail.com");
        c14.setGender("Fe-Male");
        c14.setStartDate(LocalDate.now().minusMonths(1));
        c14.setEndDate(LocalDate.now().plusMonths(5));
        c14.setPlanName("Employment");
        c14.setStatus("Approved");
        c14.setBenifits(5000.00);

        CustomersPlan c15 = new CustomersPlan();
        c15.setName("Jonathon");
        c15.setEmail("jonathon@gmail.com");
        c15.setGender("Male");
        c15.setPlanName("Employment");
        c15.setStatus("Denied");
        c15.setDeniedReason("Property");

        CustomersPlan c16 = new CustomersPlan();
        c16.setName("Steve");
        c16.setEmail("steve@gmail.com");
        c16.setGender("Male");
        c16.setPlanName("Employment");
        c16.setStartDate(LocalDate.now().minusMonths(3));
        c16.setStatus("Terminated");
        c16.setTerminateDate(LocalDate.now());
        c16.setTerminateReason("Employee");

//        List list =Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16);
 //       customerRepository.saveAll(list);

    }
}
