package struts1.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import struts1.form.LoginFormBean;

public class LoginAction extends Action {
  @Override
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
      HttpServletResponse response) throws Exception {
    LoginFormBean loginFormBean = (LoginFormBean) form;
    String uID = loginFormBean.getuID();
    String uPW = loginFormBean.getuPW();
    if (uID.equals("a") && uPW.equals("a")) {
      System.err.println(uID + uPW);
      HttpSession ses = request.getSession();
      ses.setAttribute("form", loginFormBean);
      return mapping.findForward("success");
    } else {
      System.err.println(uID + uPW); 
      return mapping.findForward("failure");
    }
  }
}
