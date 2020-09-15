package second;

/**
 * 三角形
 *
 * @author ZD
 * @date 2020-09-15 13:08
 */
public class Triangle extends Coordinates implements Shape {
    protected Double side1;
    protected Double side2;
    protected Double side3;

    Triangle(Double length, Double width) {
        super(length, width);
    }

    @Override
    public Double getArea() {
        return length * width / 2;
    }

    @Override
    public Double getPerimeter() {
        return side1 + side2 + side3;
    }
}
