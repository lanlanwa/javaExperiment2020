package fourth;

import javax.swing.*;
import java.awt.*;

/**
 * @author ZD
 * @date 2020-09-16 16:37
 */
public class One {
    public static void main(String[] args) {
        // 新建窗口对象
        Frame frame = new Frame("显示整数数字");


        // 设置Frame 布局
        frame.setLayout(new BorderLayout(4,4));

        // 创建panel容器
        Panel panel = new Panel();

        panel.setLayout(new GridLayout(4, 2,4,4));
        // 在panel里添加子元素
        panel.add(new JLabel("整数"));
        panel.add(new TextField(25));
        panel.add(new JLabel("百位"));
        panel.add(new JLabel(""));
        panel.add(new JLabel("十位"));
        panel.add(new JLabel(""));
        panel.add(new JLabel("个位"));
        panel.add(new JLabel(""));

        // 把容器放入窗口中
        frame.add(panel,BorderLayout.CENTER);

        // 设置最佳大小方法
        frame.pack();

        // 窗口居中
        frame.setLocationRelativeTo(null);

        // 设置窗口可见，一定放最后
        frame.setVisible(true);
    }
}
