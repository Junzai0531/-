import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Choose extends JFrame {
    private JButton button1=new JButton("查单词");
    private JButton button2=new JButton("背单词");
    private JButton button3=new JButton("录入单词");
    private JButton button4 =new JButton("退出");

    private JLabel label1=new JLabel("欢迎您使用查、背、录单词小程序");

    public Choose(){
        super("小程序");
        this.setSize(500,300);
        this.setLocationRelativeTo(null);

        this.setLayout(null);
        button1.setBounds(80,100,100,40);
        button1.setFont(new Font("微软雅黑",Font.BOLD,15));

        button2.setBounds(190,100,100,40);
        button2.setFont(new Font("微软雅黑",Font.BOLD,15));

        button3.setBounds(300,100,100,40);
        button3.setFont(new Font("微软雅黑",Font.BOLD,15));

        button4.setBounds(190,170,100,40);
        button4.setFont(new Font("微软雅黑",Font.BOLD,15));

        label1.setBounds(55,10,450,80);
        label1.setFont(new Font("微软雅黑",Font.BOLD,25));


        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(label1);

        this.setVisible(true);

        button1.addActionListener(e -> {
            try {
                Subject_find demo2=new Subject_find();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        button2.addActionListener(e -> {
            try {
                Subject_recite demo3=new Subject_recite();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });

        button3.addActionListener(e -> {
            try {
                Writein writein=new Writein();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        button4.addActionListener(e -> {
            this.setVisible(false);
        });
    }
}