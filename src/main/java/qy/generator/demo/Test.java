package qy.generator.demo;

import com.qy.code.generator.util.QyUtils;

import qy.generator.demo.entity.DemoCompositeEntity;
import qy.generator.demo.entity.DemoEntity;

public class Test {
	public static void main(String[] args) {
		QyUtils.createJavaFileAndTableEnforce(DemoEntity.class);
		QyUtils.createJavaFileAndTableEnforce(DemoCompositeEntity.class);
		//执行结束后，刷新entity上级目录或项目，即可看到生成的代码，必要时 maven -> update project。
	}
}
