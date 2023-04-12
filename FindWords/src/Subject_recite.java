import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Random;

public class Subject_recite extends JFrame{
    private JLabel label1=new JLabel("英：");
    private JLabel label2=new JLabel("中：");
    private JLabel label3=new JLabel("");
    private JLabel label4=new JLabel("");

    private JButton button1=new JButton();
    private JButton button2=new JButton();
    private JButton button3=new JButton("显示翻译");
    private JButton button4=new JButton("退出");
    private JButton button5=new JButton();

    private JComboBox jComboBox=new JComboBox();

    private String randomkey,y;

    private String[] alphabet={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

    public Subject_recite() throws FileNotFoundException {
        this(null,true);
        this.setVisible(true);
    }

    public Subject_recite(Frame owner, boolean modal) throws FileNotFoundException {
        super("背单词小程序");

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

        label3.setBounds(225,80,300,50);
        label3.setFont(new Font("微软雅黑",Font.BOLD,28));

        label4.setBounds(225,150,300,50);
        label4.setFont(new Font("微软雅黑",Font.BOLD,28));

        button1.setBounds(360,220,100,50);
        button1.setFont(new Font("微软雅黑",Font.BOLD,28));
        button1.setText("开始");

        button2.setBounds(250,220,100,50);
        button2.setFont(new Font("微软雅黑",Font.BOLD,28));
        button2.setText("退出");

        button3.setBounds(250,280,100,50);
        button3.setFont(new Font("微软雅黑",Font.BOLD,16));
        button3.setVisible(false);

        button4.setBounds(550,280,100,50);
        button4.setFont(new Font("微软雅黑",Font.BOLD,16));
        button4.setVisible(false);

        button5.setBounds(360,280,100,50);
        button5.setFont(new Font("微软雅黑",Font.BOLD,16));
        button5.setText("英->中");
        button5.setVisible(false);

        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
    }

    private void addListener() throws FileNotFoundException {
        Processfile profile = new Processfile();
        HashMap<String, String> map = profile.readfile("Word");

        button1.addActionListener(e -> {
            button1.setText("下一个");
            button1.setFont(new Font("微软雅黑",Font.BOLD,22));

            button2.setText("上一个");
            button2.setFont(new Font("微软雅黑",Font.BOLD,22));

            String button5text=button5.getText();

            String[] keys=map.keySet().toArray(new String[map.size()]);
            String key=keys[new Random().nextInt(keys.length)];

            byte[] p=key.getBytes();
            int i=p.length;
            int j=key.length();

            if(button5text.equals("英->中")){
                if(i==j){
                    y=randomkey;
                    randomkey=key;
                    label3.setText(key);
                    label4.setText("");
                }
            }else if(button5text.equals("中->英")){
                if(i!=j){
                    y=randomkey;
                    randomkey=key;
                    label4.setText(key);
                    label3.setText("");
                }
            }
//            y=randomkey;
//            randomkey=key;
//            label3.setText(key);
//            label4.setText("");

            button3.setVisible(true);
            button4.setVisible(true);
            button5.setVisible(true);
        });

        button2.addActionListener(e -> {
            String x=button2.getText();
            if(x.equals("退出")){
                this.setVisible(false);
            }else if(x.equals("上一个")){
                label3.setText(y);
                if(map.containsKey(y)){
                    String value=map.get(y);
                    label4.setText(value);
                }
            }
        });

        button3.addActionListener(e -> {
            String button5text=button5.getText();
            if(map.containsKey(randomkey)){
                String value=map.get(randomkey);
                byte[] p=randomkey.getBytes();
                int i=p.length;
                int j=randomkey.length();

                if(button5text.equals("英->中")){
                    if(i==j){
                        label4.setText(value);
                    }
                }else if(button5text.equals("中->英")){
                    if(i!=j){
                        label3.setText(value);
                    }
                }
            }
        });

        button4.addActionListener(e -> {
            this.setVisible(false);
        });

        button5.addActionListener(e -> {
            String buttontext=button5.getText();
            if(buttontext.equals("英->中")){
                button5.setText("中->英");
                label3.setText("");
                label4.setText("");
            }else if(buttontext.equals("中->英")){
                button5.setText("英->中");
                label3.setText("");
                label4.setText("");
            }
        });
    }
}