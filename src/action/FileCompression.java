package action;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileCompression {
	String sourceFile1 = "";
	String zipFile1 = "";

	public FileCompression(String sourceFile, String zipFile){
		this.sourceFile1 = sourceFile;
		this.zipFile1 = zipFile;
	}

    public int execute() throws Exception{
        FileOutputStream fos = new FileOutputStream(new File(zipFile1));
        File zipFile = new File(zipFile1);
        File sourceFile = new File(sourceFile1);
        int index = 0;
        if(!sourceFile.exists()) {
            Writer writer = new FileWriter(sourceFile1);
            writer.write("");
        }else {
            File []fileList = sourceFile.listFiles();
            for(File childFile : fileList) {
                File []childFileList = childFile.listFiles();
                for(File superChildFile : childFileList) {
                    ZipOutputStream zos = new ZipOutputStream(fos);
                    String fileName = index + ".jpg";
                    zos.putNextEntry(new ZipEntry(fileName));
                    System.out.println(index);
                    index++;
                    byte[] buf = new byte[4096];
                    int len;
                    FileInputStream in = new FileInputStream(superChildFile);
                    while ((len = in.read(buf)) != -1){
                        zos.write(buf, 0, len);
                    }
                    zos.closeEntry();
                    in.close();
                }
            }

        }
//        System.out.println("压缩程序执行完毕，");
        Thread.sleep(2000);
        return 0;
    }


}
