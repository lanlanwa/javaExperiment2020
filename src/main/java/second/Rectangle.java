package second;

/**
 * 矩形
 *
 * @author ZD
 * @date 2020-09-15 13:07
 */
public class Rectangle extends Coordinates implements Shape {
    Rectangle(Double length, Double width) {
        super(length, width);
    }

    @Override
    public Double getArea() {
        return length * width;
    }

    @Override
    public Double getPerimeter() {
        return (length + width) * 2;
    }
}
