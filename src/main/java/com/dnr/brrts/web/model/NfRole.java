package com.dnr.brrts.web.model;

import javax.persistence.*;

@Entity
@Table(name="SW_RRESUBM_ROLE")
public class NfRole {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nfroleid_generator")
    @SequenceGenerator(name = "nfroleid_generator", sequenceName = "sw_rresubm_roleid_seq", allocationSize = 1)
    @Column(name="role_id")
    private int id;

    @Column(name="role")
    private String role;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }


}
