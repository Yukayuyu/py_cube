public class test {
	private int i01 = 1;
	private int i = 1;

	test() {
		i = 10;
	}

	public int getI01() {
		return i01;
	}

	public void setI01(int i01) {
		this.i01 = i01;
	}

	void method0() {
		i++;
	}

	public static void main(String[] args) {

		test x = new test();
		x.method0();
		System.out.println(x.i);
		int j = x.i - 10;
		switch (j) {
			case 0:
				System.out.println(j);
				break;
			case 1:
				System.out.println(">10");

				break;
			case 2:
				break;
			default:
				System.out.println("df");
				break;
		}
	}

	void m02() {
		i++;
	}

	/*
	 * Annotation
	 * 
	 * @author k,asd, a,a
	 */
	public void m1() {

	}

}
