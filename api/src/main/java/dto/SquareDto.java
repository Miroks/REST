package dto;

public class SquareDto {

    private Long id;
    private String name;
    private double side;
    private double area;

    public SquareDto(double side) {
        this.name = "Square";
        this.side = side;
        this.area = Math.pow(side,2);
    }

    public SquareDto(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
