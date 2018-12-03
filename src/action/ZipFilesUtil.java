package action;


import java.io.*;
import java.text.ParseException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * Demo ZipFilesUtil
 *
 * @author 来自CSDN大佬
 * @date 2018/11/28
 */

public class ZipFilesUtil {



    public static void compress(File f, String baseDir, ZipOutputStream zos){

        if(!f.exists()){

//            System.out.println("待压缩的文件目录或文件"+f.getName()+"不存在");

            return;

        }

        File[] fs = f.listFiles();

        BufferedInputStream bis = null;

        //ZipOutputStream zos = null;

        byte[] bufs = new byte[1024*10];

        FileInputStream fis = null;

        try{

            //zos = new ZipOutputStream(new FileOutputStream(zipFile));

            for(int i=0; i<fs.length; i++){

                String fName =  fs[i].getName();

                System.out.println("压缩：" + baseDir+fName);

                if(fs[i].isFile()){

                    ZipEntry zipEntry = new ZipEntry(baseDir+fName);

                    zos.putNextEntry(zipEntry);

                    //读取待压缩的文件并写进压缩包里

                    fis = new FileInputStream(fs[i]);

                    bis = new BufferedInputStream(fis, 1024*10);

                    int read = 0;

                    while((read=bis.read(bufs, 0, 1024*10))!=-1){

                        zos.write(bufs, 0, read);

                    }

                    //如果需要删除源文件，则需要执行下面2句

                    fis.close();

                    fs[i].delete();

                }

                else if(fs[i].isDirectory()){

                    compress(fs[i], baseDir+fName+"/", zos);

                }

            }

        }catch  (IOException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        } finally{

            //关闭流

            try {

                if(null!=fis){
                    fis.close();
                }
            } catch (IOException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }

        }
    }


    public ZipFilesUtil(String fileName){

        File sourceDir = new File(fileName);

        File zipFile = new File(fileName+".zip");

        ZipOutputStream zos = null;

        try {

            zos = new ZipOutputStream(new FileOutputStream(zipFile));

            String baseDir = "downloadfiles/";

            compress(sourceDir, baseDir, zos);

        } catch (FileNotFoundException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        } finally{

            if(zos!=null){
                try {

                    zos.close();

                } catch (IOException e) {

                    // TODO Auto-generated catch block

                    e.printStackTrace();

                }
            }



        }
    }

    public static void main( String[] args ) throws ParseException

    {



        String sourceFilePath = "F:/111";



        File sourceDir = new File(sourceFilePath);

        File zipFile = new File(sourceFilePath+".zip");

        ZipOutputStream zos = null;

        try {

            zos = new ZipOutputStream(new FileOutputStream(zipFile));

            String baseDir = "downloadfiles/";

            compress(sourceDir, baseDir, zos);

        } catch (FileNotFoundException e) {

            // TODO Auto-generated catch block

            e.printStackTrace();

        } finally{

            if(zos!=null){
                try {

                    zos.close();

                } catch (IOException e) {

                    // TODO Auto-generated catch block

                    e.printStackTrace();

                }
            }



        }

    }



}
