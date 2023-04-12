import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class Subject_find extends JFrame {
    private JLabel label1=new JLabel("英：");
    private JLabel label2=new JLabel("中：");

    private JTextField textField1=new JTextField(20);
    private JTextField textField2=new JTextField(20);

    private JButton button1=new JButton("查找");
    private JButton button2=new JButton("清空");
    private JButton button3=new JButton();
    private JButton button4 =new JButton("退出");

    public Subject_find() throws FileNotFoundException{
        this(null,true);
        this.setVisible(true);
    }

    public Subject_find(Frame owner, boolean modal) throws FileNotFoundException {
        super("查单词小程序");

        this.init();
        this.addComponent();
        this.addListener();

        this.setVisible(true);
    }

    private void init(){
        this.setSize(710,400);
        this.setLocationRelativeTo(null);
    }

    private void addComponent(){
        this.setLayout(null);

        label1.setBounds(160,80,110,50);
        label1.setFont(new Font("微软雅黑",Font.BOLD,28));

        label2.setBounds(160,150,110,50);
        label2.setFont(new Font("微软雅黑",Font.BOLD,28));

        textField1.setBounds(225,80,300,50);
        textField1.setFont(new Font("微软雅黑",Font.BOLD,28));

        textField2.setBounds(225,150,300,50);
        textField2.setFont(new Font("微软雅黑",Font.BOLD,28));
        textField2.setBackground(Color.WHITE);
        textField2.setEditable(false);

        button1.setBounds(250,220,100,50);
        button1.setFont(new Font("微软雅黑",Font.BOLD,28));

        button2.setBounds(360,220,100,50);
        button2.setFont(new Font("微软雅黑",Font.BOLD,28));

        button3.setBounds(250,280,100,50);
        button3.setFont(new Font("微软雅黑",Font.BOLD,20));
        button3.setText("英->中");

        button4.setBounds(360,280,100,50);
        button4.setFont(new Font("微软雅黑",Font.BOLD,28));

        this.add(label1);
        this.add(label2);
        this.add(textField1);
        this.add(textField2);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
    }

    private void addListener() throws FileNotFoundException {
        Processfile profile = new Processfile();
        HashMap<String, String> map = profile.readfile("Word");

        button1.addActionListener(e -> {

            String button3text=button3.getText();

            if(button3text.equals("英->中")){
                String str=textField1.getText();
                str=str.toLowerCase();
                if(str.equals("")){
                    Error2 error2=new Error2();
                }else{
                    if(map.containsKey(str)){
                        String value=map.get(str);
                        textField2.setText(value);
                    }else{
                        Error1 erroe1=new Error1();
                        textField1.setText("");
                        textField2.setText("");
                        this.setVisible(false);
                    }
                }
            }else if(button3text.equals("中->英")){
                String str=textField2.getText();
                str=str.toLowerCase();
                if(str.equals("")){
                    Error2 error2=new Error2();
                }else{
                    if(map.containsKey(str)){
                        String value=map.get(str);
                        textField1.setText(value);
                    }else{
                        Error1 erroe1=new Error1();
                        textField1.setText("");
                        textField2.setText("");
                        this.setVisible(false);
                    }
                }
            }
        });

        button2.addActionListener(e -> {
            textField1.setText("");
            textField2.setText("");
        });

        button3.addActionListener(e -> {
            String buttontext=button3.getText();
            if(buttontext.equals("英->中")){
                button3.setText("中->英");
                textField1.setEditable(false);
                textField2.setEditable(true);
                textField1.setText("");
                textField2.setText("");
            }else if(buttontext.equals("中->英")){
                button3.setText("英->中");
                textField1.setEditable(true);
                textField2.setEditable(false);
                textField1.setText("");
                textField2.setText("");
            }
        });

        button4.addActionListener(e -> {
            this.setVisible(false);
        });
    }
}