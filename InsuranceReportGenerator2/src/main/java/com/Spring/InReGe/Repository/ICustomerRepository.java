package com.Spring.InReGe.Repository;

import com.Spring.InReGe.Entities.CustomersPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerRepository extends JpaRepository<CustomersPlan,Integer> {


    @Query("SELECT DISTINCT(planName) FROM CustomersPlan ")
    public List<String> getPlanname();

    @Query("SELECT DISTINCT(status) FROM CustomersPlan ")
    public List<String> getPlanStatus();
}
