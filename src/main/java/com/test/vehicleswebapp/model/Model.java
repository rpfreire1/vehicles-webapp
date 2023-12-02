package com.test.vehicleswebapp.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;
@Entity
@Table(name = "Model")
@NamedQueries({
@NamedQuery(name = "Model.findAll", query = "SELECT m FROM Model m")
})
public class Model implements Serializable{
    private static final long  serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_code")
    private Long modelCode;

    @Column(name = "model_year")
    private Integer modelYear;

    @Column(name = "model_brand")
    private String modelBrand;

    @Column(name = "model_manufacturer")
    private String modelManufacturer;

    // Constructor, getters, and setters

    public Model() {
    }

    public Model(Integer modelYear, String modelBrand, String modelManufacturer) {
        this.modelYear = modelYear;
        this.modelBrand = modelBrand;
        this.modelManufacturer = modelManufacturer;
    }

    public Long getModelCode() {
        return modelCode;
    }

    public void setModelCode(Long modelCode) {
        this.modelCode = modelCode;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public String getModelBrand() {
        return modelBrand;
    }

    public void setModelBrand(String modelBrand) {
        this.modelBrand = modelBrand;
    }

    public String getModelManufacturer() {
        return modelManufacturer;
    }

    public void setModelManufacturer(String modelManufacturer) {
        this.modelManufacturer = modelManufacturer;
    }

    @Override
    public String toString() {
        return "Model{" +
                "modelCode=" + modelCode +
                ", modelYear=" + modelYear +
                ", modelBrand='" + modelBrand + '\'' +
                ", modelManufacturer='" + modelManufacturer + '\'' +
                '}';
    }


}