package appDAO.dataObjects;

public class UserDO {
    private String id;
    private String uPWHashed;
    private String email;

    public UserDO(String id, String pwHashed, String mail) {
        setId(id);
        setUPWHashed(pwHashed);
        setEmail(mail);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setUPWHashed(String uPWHashed) {
        this.uPWHashed = uPWHashed;
    }

    public String getUPWHashed() {
        return this.uPWHashed;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
}