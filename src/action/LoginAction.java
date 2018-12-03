package action;

import action.dao.SearchNameAndPass;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

public class LoginAction  extends ActionSupport {
    private String name;
    private String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String execute() throws Exception{

        SearchNameAndPass searchNameAndPass =
                new SearchNameAndPass();

        Map<String, String> nameAndPass=  searchNameAndPass.search();
        //得到数据库中所有名字和密码

        ActionContext ctx = ActionContext.getContext();
        Map<String,Object> session = ctx.getSession();
        session.put("name" , getName());
        session.put("pass", getPass());

        if(nameAndPass.get(getName()).equals(getPass())){
            return SUCCESS;
        }
        return ERROR;
    }
}

