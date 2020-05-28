@SuppressWarnings("all")
public class Cp4_Bitwise{
    static byte i = (byte) 0b00010001;
    static byte j = (byte) 0b00110010;
    public static void main (String[] args){
	byte k = (byte) (i & j);
	byte l = (byte) (i | j);
	System.out.println(k);
	//System.out.println(((byte) i | (byte) j).getClass().getName());
	//Class e = ((byte) i | (byte) j).getClass();
	Object o = (byte) i | (byte) j;
	Object m = ((byte) i )/ ((byte) j);
	System.out.println(o.getClass());
	System.out.println(m.getClass());
	Object p = i;
	System.out.println(p.getClass());
	Object q = i-i;
	System.out.println(q.getClass());
	//try overflow
	int r = 2147483647;
	System.out.println(r << 1);
	System.out.println(r >>> 1);
	System.out.println(Integer.toBinaryString(-1));
	
    }
}
