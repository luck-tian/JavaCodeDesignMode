package 接口的适配器模式;

public class SourceSub2 extends Wrapper {

	@Override
	public void method2() {
		System.out.println("this is SourceSub2 method2");
	}
}
