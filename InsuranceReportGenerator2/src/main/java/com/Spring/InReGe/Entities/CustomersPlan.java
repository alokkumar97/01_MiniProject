package com.Spring.InReGe.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="customer_plan_tab")
public class CustomersPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="c_id_col")
    private Integer id;
    @Column(name="c_name_col")
    private String name;
    @Column(name="c_email_col")
    private String email;
    @Column(name="c_gender_col")
    private String gender;
    @Column(name="c_start_date_col")
    private LocalDate startDate;
    @Column(name="c_end_date_col")
    private LocalDate endDate;
    @Column(name="c_plan_name_col")
    private String planName;
    @Column(name="c_status_col")
    private String status;
    @Column(name="c_denied_reason_col")
    private String deniedReason;
    @Column(name="c_benifits_col")
    private Double benifits;
    @Column(name="c_terminate_date_col")
    private LocalDate terminateDate;
    @Column(name="c_terminate_reason_col")
    private String terminateReason;

}
