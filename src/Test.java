import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Test {

    public static void main(String[] args) throws IOException {
    	
        //目录
        File dataDir = new File("D:\\baiduyundownload\\book");
        //存放目录及其子目录下的所有文件对象
        List<File> myfile = new ArrayList<File>();
        //开始遍历
        listDirectory(dataDir, myfile);
        
        for (int i = 0; i < myfile.size(); i++) {
        	  System.out.println(i+1+"---"+myfile.get(i).getName()); 
        	 copyFile(myfile.get(i).getAbsolutePath(), "D:\\baiduyundownload\\temp\\"+myfile.get(i).getName());
       }
        System.out.println("目录下包含 " + myfile.size() + "个文件：");
        
        
        Math.sqrt(234);
        
    }
    
    public static void copyFile(String oldPath, String newPath) { 
        try { 
            int bytesum = 0; 
            int byteread = 0; 
            File oldfile = new File(oldPath); 
            if (oldfile.exists()) {                  //文件存在时 
                InputStream inStream = new FileInputStream(oldPath);      //读入原文件 
                FileOutputStream fs = new FileOutputStream(newPath); 
                byte[] buffer = new byte[1444]; 
                int length; 
                while ( (byteread = inStream.read(buffer)) != -1) { 
                    bytesum += byteread;            //字节数 文件大小 
                    fs.write(buffer, 0, byteread); 
                } 
                inStream.close(); 
            } 
        }  catch (Exception e) { 
            System.out.println("复制单个文件操作出错"); 
            e.printStackTrace(); 
        } 
    } 
    /**
     * 遍历目录及其子目录下的所有文件并保存
     * @param path 目录全路径
     * @param myfile 列表：保存文件对象
     */
    public static void listDirectory(File path, List<File> myfile){
        if (!path.exists()){
            System.out.println("文件名称不存在!");
        }
        else
        {
            if (path.isFile()){
                myfile.add(path);
            } else{
                File[] files = path.listFiles();
                for (int i = 0; i < files.length; i++  ){
                    listDirectory(files[i], myfile);
                }
            }
        }
    }
}
