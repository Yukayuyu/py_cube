package libBasic;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@SuppressWarnings("all")
public class reflectionToString {
	private String a = "avalue";
	private String b = "bvalue";

	private void f() {
		System.out.println("void f();");
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
	public static void main(String[] args) {
		reflectionToString x = new reflectionToString();
		System.out.println(x);
	} 
}
