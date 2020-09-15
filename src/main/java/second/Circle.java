package second;

/**
 * 圆形
 *
 * @author ZD
 * @date 2020-09-15 13:07
 */
public class Circle extends Coordinates implements Shape {
    Circle(Double length, Double width) {
        super(length, width);
    }

    @Override
    public Double getArea() {
        return Math.PI * Math.pow(length / 2, 2);
    }

    @Override
    public Double getPerimeter() {
        return Math.PI * length;
    }
}
