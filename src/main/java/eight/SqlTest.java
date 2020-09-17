package eight;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author ZD
 * @date 2020-09-17 16:00
 */
public class SqlTest {

    private static String url = "jdbc:mysql://localhost:3306/studentinfo?serverTimezone=GMT";
    private static String userName = "root";
    private static String password = "admin";

    public static void using() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection conn = DriverManager.getConnection(url, userName, password);
        String sql = "";
        Statement sm = conn.createStatement();
        ResultSet rs = null;
        String i;
        String j;
        while (true) {
            System.out.println("请选择操作：1.查询，2.修改，3.添加，4.删除");
            j = scanner.nextLine();
            switch (j) {
                case "1":
                    System.out.println("请输入需要查询的姓名");
                    String queryValue = scanner.nextLine();
                    sql = "select * from student where name ='" + queryValue + "'";
//                    sql = "select * from student";
                    rs = sm.executeQuery(sql);

                    boolean isExist = false;
                    while (rs.next()) {
                        String id = rs.getString("id");
                        String name = rs.getString("name");
                        String sex = rs.getString("sex");
                        String age = rs.getString("age");
                        System.out.println("id:" + id + "\tname:" + name + "\tsex:" + sex + "\tage:" + age);
                        isExist = true;
                    }
                    if (!isExist) {
                        System.out.println("查询结果为空");
                    }
                    break;
                case "2":
                    System.out.println("请输入需要修改信息的学生id");
                    j = scanner.nextLine();
                    rs = sm.executeQuery("select * from student where id=" + j);
                    if (!rs.next()) {
                        System.out.println("此学号不存在！");
                        break;
                    }
                    String field;
                    while (true) {
                        System.out.println("请输入需要修改的属性(不可以修改id)");
                        System.out.println("name sex age");
                        field = scanner.next();
                        if (!"name".equals(field) && !"sex".equals(field) && !"age".equals(field)) {
                            System.out.println("输入错误，请重输");
                        } else {
                            break;
                        }
                    }
                    System.out.println("修改为:");
                    String newValue = scanner.next();
                    String updateSql = "update student set " + field + "='" + newValue + "'" + "where id=" + j;
                    sm.executeUpdate(updateSql);
                    System.out.println("更新成功！");
                    break;
                case "3":
                    System.out.println("请按照顺序输入姓名、性别、年龄(以空格分隔)");
                    String name = scanner.next();
                    String sex = scanner.next();
                    String age = scanner.next();
                    sm.executeUpdate("insert into student(name,sex,age)" + "values('" + name + "','" + sex + "','" + age + "')");
                    System.out.println("添加成功！");
                    break;
                case "4":
                    System.out.println("请输入要删除的学生id");
                    int id = scanner.nextInt();
                    sm.executeUpdate("delete from student where id = " + id);
                    System.out.println("删除成功！");
                    break;
                default:
                    System.out.println("输入错误请重输：");
                    break;
            }
            System.out.println("请输入数据进行选择：（0代表结束程序，1代表继续运行程序）");
            i = scanner.nextLine();
            if ("0".equals(i)) {
                break;
            }
        }
        if (rs != null) {
            rs.close();
            rs = null;
        }
        if (sm != null) {
            sm.close();
            sm = null;
        }
        if (conn != null) {
            conn.close();
            conn = null;
        }
        System.out.println("程序结束！");
    }

    public static void searchForOlderThan18() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection conn = DriverManager.getConnection(url, userName, password);
        String sql = "";
        Statement sm = conn.createStatement();
        ResultSet rs = null;
        rs = sm.executeQuery("select * from student where age > 18");

        boolean isExist = false;
        while (rs.next()) {
            String id = rs.getString("id");
            String student_id = rs.getString("student_id");
            String score = rs.getString("score");
            System.out.println("id:" + id + "\tname:" + student_id + "\tsex:" + score);
            isExist = true;
        }
        if (!isExist) {
            System.out.println("查询结果为空");
        }
        if (rs != null) {
            rs.close();
            rs = null;
        }
        if (sm != null) {
            sm.close();
            sm = null;
        }
        if (conn != null) {
            conn.close();
            conn = null;
        }
    }

    public static void gradeOperation() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Connection conn = DriverManager.getConnection(url, userName, password);
        String sql = "";
        Statement sm = conn.createStatement();
        ResultSet rs = null;
        String i;
        String j;
        while (true) {
            System.out.println("请选择操作：1.查询，2.修改，3.添加，4.删除，5.统计");
            j = scanner.nextLine();
            switch (j) {
                case "1":
                    System.out.println("请输入需要查询的学生id");
                    String queryValue = scanner.nextLine();
                    sql = "select * from grade where student_id =" + queryValue;
//                    sql = "select * from grade";
                    rs = sm.executeQuery(sql);
                    boolean isExist = false;
                    while (rs.next()) {
                        String id = rs.getString("id");
                        String student_id = rs.getString("student_id");
                        String score = rs.getString("score");
                        System.out.println("id:" + id + "\tstudent_id:" + student_id + "\tscore:" + score);
                        isExist = true;
                    }
                    if (!isExist) {
                        System.out.println("查询结果为空");
                    }
                    break;
                case "2":
                    System.out.println("请输入需要修改信息的学生id");
                    j = scanner.nextLine();
                    rs = sm.executeQuery("select * from grade where student_id =" + j);
                    if (!rs.next()) {
                        System.out.println("此学生id不存在！");
                        break;
                    }
                    System.out.println("请输入修改后的分数:");
                    String newValue = scanner.next();
                    String updateSql = "update grade set score ='" + newValue + "'" + "where student_id =" + j;
                    sm.executeUpdate(updateSql);
                    System.out.println("更新成功！");
                    break;
                case "3":
                    System.out.println("请按照顺序输入学生id、分数（以空格间隔开）");
                    String studentId = scanner.next();
                    String score = scanner.next();
                    sm.executeUpdate("insert into grade(student_id,score)" + "values('" + studentId + "','" + score + "')");
                    System.out.println("添加成功！");
                    break;
                case "4":
                    System.out.println("请输入要删除的分数单id");
                    int id = scanner.nextInt();
                    sm.executeUpdate("delete from grade where id = " + id);
                    System.out.println("删除成功！");
                    break;
                case "5":
                    rs = sm.executeQuery("select * from grade");
                    float sum = 0;
                    int numbers = 0;
                    while (rs.next()) {
                        sum += rs.getFloat("score");
                        numbers++;
                    }
                    System.out.println("学生总分为:" + sum);
                    System.out.println("学生平均分为:" + sum / numbers);
                    break;
                default:
                    System.out.println("输入错误请重输");
                    break;
            }
            System.out.println("请输入数据进行选择：（0代表结束程序，1代表继续运行程序）");
            i = scanner.nextLine();
            if ("0".equals(i)) {
                break;
            }
        }
        if (rs != null) {
            rs.close();
            rs = null;
        }
        if (sm != null) {
            sm.close();
            sm = null;
        }
        if (conn != null) {
            conn.close();
            conn = null;
        }
        System.out.println("程序结束！");
    }

    public static void main(String[] args) {
        try {
            gradeOperation();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
    }
}
