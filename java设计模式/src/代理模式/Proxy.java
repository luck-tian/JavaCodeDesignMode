package 代理模式;

public class Proxy implements Sourceable {

	private Source source;

	public Proxy(Source source) {
		this.source = source;
	}

	@Override
	public void method() {
		atfer();
		source.method();
		befor();
	}

	private void atfer() {
		System.out.println("atfer");
	}

	private void befor() {
		System.out.println("befor");
	}

}
