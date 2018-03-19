package test.dubbo.demo;

import javax.validation.constraints.NotNull;

public interface ISayNo {
	public void sayNo(@NotNull String name);
	public void toto(@NotNull TestParams params);
}
