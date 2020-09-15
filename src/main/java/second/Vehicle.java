package second;

/**
 * @author ZD
 * @date 2020-09-15 12:55
 */
public class Vehicle {
    protected Integer wheels;
    protected Integer weight;

    public Vehicle(Integer wheels,Integer weight){
        this.wheels = wheels;
        this.weight = weight;
    }

    public void display(){
        System.out.println("该车的车轮数为：" + wheels);
        System.out.println("该车的重量为：" + weight);
    }
}
