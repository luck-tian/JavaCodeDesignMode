package 接口的适配器模式;

public class SourceSub1 extends Wrapper {

	@Override
	public void method1() {
		System.out.println("this is sourceSub1 method1");
	}
}
