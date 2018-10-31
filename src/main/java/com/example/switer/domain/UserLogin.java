package com.example.switer.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usr")
public class UserLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String password;
    private boolean activity;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public long getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Getter for property 'userName'.
     *
     * @return Value for property 'userName'.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter for property 'userName'.
     *
     * @param userName Value to set for property 'userName'.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter for property 'password'.
     *
     * @return Value for property 'password'.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter for property 'password'.
     *
     * @param password Value to set for property 'password'.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter for property 'activity'.
     *
     * @return Value for property 'activity'.
     */
    public boolean isActivity() {
        return activity;
    }

    /**
     * Setter for property 'activity'.
     *
     * @param activity Value to set for property 'activity'.
     */
    public void setActivity(boolean activity) {
        this.activity = activity;
    }

    /**
     * Getter for property 'roles'.
     *
     * @return Value for property 'roles'.
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Setter for property 'roles'.
     *
     * @param roles Value to set for property 'roles'.
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
