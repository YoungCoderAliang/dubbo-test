package test.dubbo.demo;

public class SayHi implements ISayHi {
	@Override
	public void sayHi() {
		System.out.println("hi");
	}
}
