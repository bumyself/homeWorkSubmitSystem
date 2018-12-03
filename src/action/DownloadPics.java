package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.FileWriter;
import java.io.InputStream;
import java.io.Writer;
import java.util.Map;

public class DownloadPics extends ActionSupport{
        private String targetUrl;
        private String inputPath;

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getInputPath() {
        return inputPath;
    }

    public void setInputPath(String value)
        {
            inputPath = value;
        }

        public InputStream getTargetFile() throws Exception
        {
            Writer writer = new FileWriter("E:\\homeWorkSubmitSystem\\homeWorkSubmitSystem\\web\\zipFile.zip");
            writer.write("");
            CallPython callPython = new CallPython();
            callPython.execute(getTargetUrl(), "111");
            System.out.println("下载和压缩操作执行完毕。");
            InputStream in =  ServletActionContext.getServletContext().getResourceAsStream(inputPath);
            return in;
        }
}