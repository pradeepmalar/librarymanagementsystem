package com.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "members")
public class member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer u_id;

    @Column(name = "u_name", nullable = false)
    private String uName;

    @Column(name = "u_age", nullable = false)
    private Integer uAge;

    @Column(name = "u_mobile", nullable = false, length = 10)
    private String uMobile;

    public member() {}

    public Integer getU_id() { return u_id; }
    public void setU_id(Integer u_id) { this.u_id = u_id; }

    public String getuName() { return uName; }
    public void setuName(String uName) { this.uName = uName; }

    public Integer getuAge() { return uAge; }
    public void setuAge(Integer uAge) { this.uAge = uAge; }

    public String getuMobile() { return uMobile; }
    public void setuMobile(String uMobile) { this.uMobile = uMobile; }
}