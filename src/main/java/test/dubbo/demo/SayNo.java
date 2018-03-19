package test.dubbo.demo;

import com.alibaba.dubbo.rpc.RpcContext;


public class SayNo implements ISayNo {
	private int count = 0;
	@Override
	public void sayNo(String name) {
		System.out.println("say no " + ++count);
	}

	@Override
    public void toto(TestParams params) {
	    System.out.println("toto");
	    System.out.println(RpcContext.getContext().getAttachments());
    }
}
