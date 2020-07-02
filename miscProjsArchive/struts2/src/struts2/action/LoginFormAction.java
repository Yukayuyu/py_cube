package struts2.action;

import com.opensymphony.xwork2.ActionSupport;

import struts2.model.LoginFormInfo;

public class LoginFormAction extends ActionSupport {
    private static final long serialVersionUID = -1292220769035659047L;

    private LoginFormInfo loginFormInfoBean = null;

    public String execute() {
        // DB Operation
        if (this.loginFormInfoBean == null) {
            System.out.println("empty");
            return "success";
        } else {
            System.out.println(this.loginFormInfoBean.getuID());
            return "success";
        }
    }

    public LoginFormInfo getLoginFormInfoBean() {
        return loginFormInfoBean;
    }

    public void setLoginFormInfoBean(LoginFormInfo loginFormInfoBean) {
        this.loginFormInfoBean = loginFormInfoBean;
    }

}