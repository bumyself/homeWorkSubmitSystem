package intercepter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class AuthorityInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation invocation) throws Exception{
        System.out.println("It is here");
        ActionContext actionContext = invocation.getInvocationContext();
        Map session = actionContext.getSession();
        String name  = (String)session.get("name");
        String pass = (String)session.get("pass");
        System.out.println(name  + " is name, " + pass + " is pass");
        if(name != null || pass != null){
            return invocation.invoke();
        }
        actionContext.put("tip", "还没有登录~~");
        return invocation.invoke();
    }
}
