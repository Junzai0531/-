import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Processfile {
    public HashMap<String,String> readfile(String filename) throws FileNotFoundException{
        // 在此添加代码，完成将文件”中的内容加载到HashMap中
        BufferedReader br = new BufferedReader(new FileReader(filename));
        HashMap<String,String> id=new HashMap();  	//创建动态数组
        String line=null;
        // 在此处添加代码，完成将磁盘文件的内容载入HashMap
        try {
            while((line=br.readLine())!=null){    // 从文件中读一行，当为null时，表示文件读完了
                String array[]=line.split("  "); // 将文件中读出的一行以“:”为分割进行拆分成单词和解释
                id.put(array[0],array[1]);  // 将字典放入Hushmap
            }
            br.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return id;
    }
}
