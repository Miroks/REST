package poject.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Shape")
public class Circle {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @Column(name = "type")
    @JsonIgnore
    private String name;

    @Column(name = "length")
    private double radius;

    @Column(name = "area")
    @JsonIgnore
    private double area;

    public String getName() {
        return name;
    }

    public Circle(double radius) {
        this.name = "Circle";
        this.radius = radius;
        this.area = Math.PI*Math.pow(radius,2);
    }

    public Circle(){}

    public void setName(String name) {
        this.name = name;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

}
