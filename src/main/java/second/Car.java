package second;

/**
 * @author ZD
 * @date 2020-09-15 12:56
 */
public class Car extends Vehicle{
    protected Integer loader;

    public Car(Integer wheels, Integer weight) {
        super(wheels, weight);
    }

    public Car(Integer wheels, Integer weight,Integer loader){
        super(wheels, weight);
        this.loader = loader;
    }

    @Override
    public void display(){
        System.out.println("该车的车轮数为：" + wheels);
        System.out.println("该车的重量为：" + weight);
        System.out.println("该车的载人数为：" + loader);
    }
}
