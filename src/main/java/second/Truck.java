package second;

/**
 * @author ZD
 * @date 2020-09-15 12:57
 */
public class Truck extends Car{
    protected Float payload;

    public Truck(Integer wheels, Integer weight, Integer loader) {
        super(wheels, weight, loader);
    }

    public Truck(Integer wheels, Integer weight, Integer loader,Float payload){
        super(wheels, weight, loader);
        this.payload = payload;
    }

    @Override
    public void display(){
        System.out.println("该车的车轮数为：" + wheels);
        System.out.println("该车的重量为：" + weight);
        System.out.println("该车的载人数为：" + loader);
        System.out.println("该车的载重量为：" + payload);
    }
}
