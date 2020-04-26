package dto;

public class CircleDto {



    private Long id;
    private String name;
    private double radius;
    private double area;

    public String getName() {
        return name;
    }

    public CircleDto(double radius) {
        this.name = "Circle";
        this.radius = radius;
        this.area = Math.PI*Math.pow(radius,2);
    }

    public CircleDto(){}

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
