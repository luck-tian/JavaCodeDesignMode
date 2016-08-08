package 对象的适配器模式;

public class AdapterTest {

	public static void main(String[] args) {
		Targetable targetable = new Wrapper(new Source());
		targetable.method1();
		targetable.method2();
	}
}
