package com.example.switer.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotNull
    @Size(min = 5, max = 255)
    private String name;
    @NotNull
    @Min(5)
    private String email;
    private String tag;

    public User(){

    }
    public User(String name, String emasil){
        this.name = name;
        this.email = emasil;
    }
    /**
     * Getter for property 'tag'.
     *
     * @return Value for property 'tag'.
     */
    public String getTag() {
        return tag;
    }

    /**
     * Setter for property 'tag'.
     *
     * @param tag Value to set for property 'tag'.
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Getter for property 'id'.
     *
     * @return Value for property 'id'.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Setter for property 'id'.
     *
     * @param id Value to set for property 'id'.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Getter for property 'name'.
     *
     * @return Value for property 'name'.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for property 'name'.
     *
     * @param name Value to set for property 'name'.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for property 'email'.
     *
     * @return Value for property 'email'.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for property 'email'.
     *
     * @param email Value to set for property 'email'.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
