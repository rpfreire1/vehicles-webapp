package com.test.vehicleswebapp.model;



import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Vehicle")
@NamedQueries({@NamedQuery(name = "Vehicle.findAll", query = "SELECT p FROM Vehicle p"), @NamedQuery(name = "Vehicle.findByPurchasedDateOrMaintenanceDate", query = "select p from Vehicle p where p.vehiclePurchasedDate =:filteredDate or p.vehicleLastMaintenance=:filteredDate")})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vehicle_code")
    private Long vehicleCode;

    @Column(name = "vehicle_plates", length = 8)
    private String vehiclePlates;

    @Column(name = "vehicle_comment")
    private String vehicleComment;

    @Column(name = "vehicle_purchasedDate")
    private LocalDate vehiclePurchasedDate;

    @Column(name = "vehicle_lastMaintenance")
    private LocalDate vehicleLastMaintenance;

    @Column(name = "vehicle_price")
    private Double vehiclePrice;

    @ManyToOne
    @JoinColumn(name = "model_code", referencedColumnName = "model_code")
    private Model model;

    // Constructor, getters, and setters

    public Vehicle(String vehiclePlates, String vehicleComment, LocalDate vehiclePurchasedDate, LocalDate vehicleLastMaintenance, Double vehiclePrice, Model model) {
        this.vehiclePlates = vehiclePlates;
        this.vehicleComment = vehicleComment;
        this.vehiclePurchasedDate = vehiclePurchasedDate;
        this.vehicleLastMaintenance = vehicleLastMaintenance;
        this.vehiclePrice = vehiclePrice;
        this.model = model;
    }

    public Vehicle() {
    }

    public Long getVehicleCode() {
        return vehicleCode;
    }

    public void setVehicleCode(Long vehicleCode) {
        this.vehicleCode = vehicleCode;
    }

    public String getVehiclePlates() {
        return vehiclePlates;
    }

    public void setVehiclePlates(String vehiclePlates) {
        this.vehiclePlates = vehiclePlates;
    }

    public String getVehicleComment() {
        return vehicleComment;
    }

    public void setVehicleComment(String vehicleComment) {
        this.vehicleComment = vehicleComment;
    }

    public LocalDate getVehiclePurchasedDate() {
        return vehiclePurchasedDate;
    }

    public void setVehiclePurchasedDate(LocalDate vehiclePurchasedDate) {
        this.vehiclePurchasedDate = vehiclePurchasedDate;
    }

    public LocalDate getVehicleLastMaintenance() {
        return vehicleLastMaintenance;
    }

    public void setVehicleLastMaintenance(LocalDate vehicleLastMaintenance) {
        this.vehicleLastMaintenance = vehicleLastMaintenance;
    }

    public Double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(Double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "vehicleCode=" + vehicleCode + ", vehiclePlates='" + vehiclePlates + '\'' + ", vehicleComment='" + vehicleComment + '\'' + ", vehiclePurchasedDate=" + vehiclePurchasedDate + ", vehicleLastMaintenance=" + vehicleLastMaintenance + ", vehiclePrice=" + vehiclePrice + ", model=" + model + '}';
    }
}
