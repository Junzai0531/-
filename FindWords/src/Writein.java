import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Writein extends JFrame {
    private JLabel label1=new JLabel("英:");
    private JLabel label2=new JLabel("中:");

    private JTextField textField1=new JTextField(18);
    private JTextField textField2=new JTextField(18);

    private JButton button1=new JButton("录入");
    private JButton button2=new JButton("清空");
    private JButton button3=new JButton("退出");

    public Writein() throws IOException {
        super("录入");
        this.setSize(650,350);
        this.setLocationRelativeTo(null);

        this.addComponent();
        this.addListener();

        this.setVisible(true);
    }

    private void addComponent(){
        this.setLayout(null);
        label1.setBounds(140,65,110,50);
        label1.setFont(new Font("微软雅黑",Font.BOLD,28));

        label2.setBounds(140,135,110,50);
        label2.setFont(new Font("微软雅黑",Font.BOLD,28));

        textField1.setBounds(200,65,300,50);
        textField1.setFont(new Font("微软雅黑",Font.BOLD,28));

        textField2.setBounds(200,135,300,50);
        textField2.setFont(new Font("微软雅黑",Font.BOLD,28));

        button1.setBounds(220,220,100,50);
        button1.setFont(new Font("微软雅黑",Font.BOLD,28));

        button2.setBounds(330,220,100,50);
        button2.setFont(new Font("微软雅黑",Font.BOLD,28));

        button3.setBounds(510,220,100,50);
        button3.setFont(new Font("微软雅黑",Font.BOLD,28));

        this.add(label1);
        this.add(label2);
        this.add(textField1);
        this.add(textField2);
        this.add(button1);
        this.add(button2);
        this.add(button3);
    }

    private void addListener() throws IOException {
        String path="/Users/ruanzijun/Library/Mobile Documents/com~apple~CloudDocs/IdeaProjects 2/FindWords/Word";
        button1.addActionListener(e -> {
            String value_English=textField1.getText();
            String value_Chinese=textField2.getText();
            String value_EC=value_English+"  "+value_Chinese+"\n";
            String value_CE=value_Chinese+"  "+value_English+"\n";
            BufferedWriter bw= null;
            try {
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path,true)));
                bw.write(value_EC);
                bw.write(value_CE);
                bw.close();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            textField1.setText("");
            textField2.setText("");
        });

        button2.addActionListener(e -> {
            textField1.setText("");
            textField2.setText("");
        });

        button3.addActionListener(e -> {
            this.setVisible(false);
            try {
                Subject_find subject_find=new Subject_find();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
    }
}
