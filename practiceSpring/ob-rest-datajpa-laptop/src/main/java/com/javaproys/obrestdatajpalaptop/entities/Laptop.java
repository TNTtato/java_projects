package com.javaproys.obrestdatajpalaptop.entities;

import javax.persistence.*;

@Entity
@Table(name = "TBL_LAPTOPS")
public class Laptop {

    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private String manufacturer;
    private String memoryRam;

    //contructors

    public Laptop() {
    }

    public Laptop(Long id, String model, String manufacturer, String memoryRam) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.memoryRam = memoryRam;
    }

    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryRam() {
        return memoryRam;
    }

    public void setMemoryRam(String memoryRam) {
        this.memoryRam = memoryRam;
    }

    //toString


    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", memoryRam='" + memoryRam + '\'' +
                '}';
    }
}
