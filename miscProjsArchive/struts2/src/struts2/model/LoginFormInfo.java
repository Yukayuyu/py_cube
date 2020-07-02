package struts2.model;

public class LoginFormInfo {
    private String uID;
    private String uPW;

    public String getuID() {
        return uID;
    }

    public String getuPW() {
        return uPW;
    }

    public void setuPW(String uPW) {
        this.uPW = uPW;
    }

    public void setuID(String uID) {
        this.uID = uID;
    } 
}