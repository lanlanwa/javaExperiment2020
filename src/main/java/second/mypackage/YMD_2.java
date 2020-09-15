package second.mypackage;

/**
 * @author ZD
 * @date 2020-09-15 13:24
 */
public class YMD_2 {
    private String name;
    private YMD birth;

    public YMD_2(String name, int y, int m, int d) {
        this(name,new YMD(y,m,d));
    }

    public YMD_2(String name, YMD ymd) {
        this.name = name;
        this.birth = ymd;
    }

    public static void main(String[] args) {
        YMD_2 a = new YMD_2("张弛",1990,1,11);
        a.output();
    }

    private void output() {
        System.out.println("姓名：" + name);
        System.out.println("出生日期：" + birth.toString());
        System.out.println("今年年龄：" + age());
    }

    public int age(){
        return YMD.thisYear() - birth.year();
    }


}
