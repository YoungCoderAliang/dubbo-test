package test.dubbo.demo;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.service.GenericService;

public class TestClient {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test\\dubbo\\demo\\ac-client.xml");
		attachParam(context);
		System.exit(0);
	}

	private static void attachParam(ClassPathXmlApplicationContext context) {
		RpcContext.getContext().setAttachment("attach", "hello").setAttachment("attach2", "world");
		validation(context);
	}

	private static void validation(ClassPathXmlApplicationContext context) {
		ISayNo sayNo = context.getBean(test.dubbo.demo.ISayNo.class);
		TestParams params = new TestParams();
		params.setAge(3);
		params.setName("haha");
		sayNo.toto(params);
	}

	private static void generic(ClassPathXmlApplicationContext context) {
		GenericService gs = (GenericService) context.getBean("sayNo");
		for (int i = 0; i < 1; i++) {
			TestParams params = new TestParams();
			params.setAge(3);
			params.setName("haha");
			// sayNo.toto(params);
			Object result = gs.$invoke("toto", new String[] { "test.dubbo.demo.TestParams" }, new Object[] { params });
			System.out.println(String.valueOf(result));
		}
	}
}
