package action.dao;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
/**
 * Demo SearchNameAndPass
 *
 * @author lin
 * @date 2018/11/22
 */

public class SearchNameAndPass extends ActionSupport {
    private String driver;
    private String  url;
    private String user;
    private String pass;

/**     通过读取属性文件来获得属性 */
    private void iniParam() throws Exception{

//        依次读取属性文件里的各种属性
        driver =  getText("driver");
        System.out.println(driver);
        url=  getText( "url");
        user =   getText("user");
        pass = getText( "pass");
        Class.forName(driver);
    }




/**     在数据库中搜索匹配的用户名和密码。 */
    public   Map<String, String >  search() throws Exception{
        HashMap<String, String>nameAndPass = new HashMap<>(16);
        try(
//                PreparedStatement同样是通过Connection对象来或获得的。
//                具体的构造方法是将要执行的sql语句传进其构造方法里。但是要将具体的数据用？代替
//                然后再在具体执行sql语句的时候将？代替成具体的值
                Connection connection = DriverManager.getConnection(url,user,pass);
                PreparedStatement preparedStatement =
                        connection.prepareStatement(" select *  from students  "))
        {
            ResultSet resultSet = preparedStatement.executeQuery();

            //将在数据库中所有的账号密码存储在一个map中，以账号为键，密码为值
            while (resultSet.next())
            {
                nameAndPass.put(resultSet.getString("account"), resultSet.getString("password1"));
            }
        }
        return nameAndPass;
    }


    public SearchNameAndPass() throws Exception{
        iniParam( );
    }
//    public static void main(String []args) throws Exception{
//        SearchNameAndPass preparedStatementTest  = new SearchNameAndPass();
//        preparedStatementTest.iniParam("E:\\homeWorkSubmitSystem\\homeWorkSubmitSystem\\param.ini");
//        Map<String, String > nameAndPass =  preparedStatementTest.search();
//        System.out.println(nameAndPass.get("15363396874"));
//    }
}
