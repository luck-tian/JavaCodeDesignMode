package ÀàÊÊÅäÆ÷Ä£Ê½;

public class AdapterTest {

	public static void main(String[] args) {
		Targetable targetable = new Adapter();
		targetable.method1();
		targetable.method2();
	}
}
