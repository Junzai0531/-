import javax.swing.*;
import java.awt.*;

public class Error2 extends JFrame {
    private JPanel panel1;
    private JLabel label1;

    public Error2(){
        super("Error");

        this.setSize(350,100);
        this.setLocationRelativeTo(null);
        panel1=new JPanel();

        label1=new JLabel("请输入您要查找的单词");
        label1.setFont(new Font("微软雅黑",Font.BOLD,15));

        panel1.add(label1);

        this.add(panel1);

        this.setVisible(true);
    }
}
