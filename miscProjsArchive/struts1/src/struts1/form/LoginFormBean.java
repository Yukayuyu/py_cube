package struts1.form;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class LoginFormBean extends ActionForm {
    private static final long serialVersionUID = 1L;
    private String uID = null;
    private String uPW = null;


    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        this.setuPW(null);
    }


    public String getuID() {
      return uID;
    }


    public void setuID(String uID) {
      this.uID = uID;
    }


    public String getuPW() {
      return uPW;
    }


    public void setuPW(String uPW) {
      this.uPW = uPW;
    }
}