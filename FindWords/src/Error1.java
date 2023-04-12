import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Error1 extends JFrame {
    private JLabel label1=new JLabel("词典中暂未收录此单词");
    private JLabel label2=new JLabel("是否帮助录入词库？");;

    private JButton button1=new JButton("是");
    private JButton button2=new JButton("否");

    public Error1(){
        super("Error");

        this.setSize(350,200);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        label1.setBounds(70,-10,500,100);
        label1.setFont(new Font("微软雅黑",Font.BOLD,20));

        label2.setBounds(85,30,500,100);
        label2.setFont(new Font("微软雅黑",Font.BOLD,20));

        button1.setBounds(70,110,80,30);
        button1.setFont(new Font("微软雅黑",Font.BOLD,18));

        button2.setBounds(190,110,80,30);
        button2.setFont(new Font("微软雅黑",Font.BOLD,18));

        this.add(label1);
        this.add(label2);
        this.add(button1);
        this.add(button2);

        this.addListener();

        this.setVisible(true);
    }

    private void addListener() {
        button1.addActionListener(e -> {
            try {
                Writein demo2=new Writein();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            this.setVisible(false);
        });

        button2.addActionListener(e -> {
            this.setVisible(false);
        });
    }
}