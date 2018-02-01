package com.dnr.brrts.web.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.authentication.AbstractAuthenticationToken;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="SW_RRESUBM_USER")
public class NfUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "nfuserid_generator")
    @SequenceGenerator(name = "nfuserid_generator", sequenceName = "sw_rresubm_userid_seq", allocationSize = 1)
    private Long userId;

    @JsonIgnore
    private String password;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "sw_rresubm_user_role_xref", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<NfRole> roles;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user")
//    private NfReport report;


    public NfUser(String password, String firstName, String lastName) {
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public NfUser() {
    }

    public NfUser(String username) {
        this.username = username;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<NfRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<NfRole> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
