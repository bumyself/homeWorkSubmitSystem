package action;


import java.io.File;
import java.io.FileWriter;

/**
 * Demo CallPython
 *
 * @author lin
 * @date 2018/11/28
 * 用于在Java调用python程序，并将爬取到的结果压缩后保存在F盘中。
 */

public class CallPython extends Thread{


    public int execute(String url, String fileName) {
        File file  = new File("F://111");
        delDir(file);
        try {
            FileWriter writer = new FileWriter("openexcel.bat");
            writer.write("@echo  off");
            writer.write("\r\n ");
            writer.write("E:");
            writer.write("\r\n ");
            writer.write("cd dmzj_scrapy");
            writer.write("\r\n ");
            writer.write("\r\n ");
            writer.write("python dmzj_start.py" + " " + url  +" " + fileName);
            writer.write("\r\n ");
            writer.write("exit");
            writer.write("\r\n ");
            writer.write("@echo   on ");
            writer.close();
            Process process =  Runtime.getRuntime().exec("cmd /c start  /wait openexcel.bat");
            process.waitFor();
            return 0;
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return 1;
    }


    private   void delDir(File f) {
        // 判断是否是一个目录, 不是的话跳过, 直接删除; 如果是一个目录, 先将其内容清空.
        if(f.isDirectory()) {
            // 获取子文件/目录
            File[] subFiles = f.listFiles();
            // 遍历该目录
            for (File subFile : subFiles) {
                // 递归调用删除该文件: 如果这是一个空目录或文件, 一次递归就可删除. 如果这是一个非空目录, 多次
                // 递归清空其内容后再删除
                delDir(subFile);
            }
        }
        // 删除空目录或文件
        f.delete();
    }
}