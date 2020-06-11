package simpleBatis;

import java.io.Serializable;

public class Entity01User implements Serializable {
    private static final long serialVersionUID = 1111L;
    private String name;
    private String password;
    private String uID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return uID;
    }

    public void setUserID(String userID) {
        this.uID = userID;
    }

    @Override
    public String toString() {
        return (name + " | " + password + " | " + uID);
    } 
}
