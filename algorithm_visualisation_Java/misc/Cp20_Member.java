import Cp20AnnotationPkg.*;

@DBTable(name = "MEMBER")
public class Cp20_Member {
    @SQLString(30) // the shortcut for assigning value for the variable *value*
    String firstName;
    @SQLString(50)
    String lastName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30, constraints = @Constraints(primaryKey = true))
    String handle;
    //@SQLString(value = 31, constraints = @Constraints(allowNull = true, primaryKey = true))
    //String customized;
    static int memberCount;

    public String getHandle() {
        return handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return handle;
    }

    public Integer getAge() {
        return age;
    }

    public static void main(String[] args) {
        System.out.println("hi");
    }

}
