package qy.generator.demo.entity;

import com.qy.code.api.annotion.sql.Column;
import com.qy.code.api.annotion.sql.Comment;
import com.qy.code.api.annotion.sql.Table;
import com.qy.code.generator.util.QyUtils;

@Comment("复合主键demo")
@Table("demo_composite")
public class DemoCompositeEntity {
	
	public static void main(String[] args) {
		QyUtils.createJavaFileEnforce(DemoCompositeEntity.class);
		//执行结束后，刷新entity上级目录或项目，即可看到生成的代码，必要时 maven -> update project。
	}
	
	@Comment("用户主键")
	@Column(id = true,compositeId=true)
	private Integer userId;
	
	@Comment("角色主键")
	@Column(id = true,compositeId=true)
	private Integer roleId;
	
	
}
