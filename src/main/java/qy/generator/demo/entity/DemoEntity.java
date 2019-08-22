package qy.generator.demo.entity;

import com.qy.code.api.annotion.sql.Column;
import com.qy.code.api.annotion.sql.Comment;
import com.qy.code.api.annotion.sql.Index;
import com.qy.code.api.annotion.sql.LogicDelete;
import com.qy.code.api.annotion.sql.Table;
import com.qy.code.api.enums.sql.ColumnType;
import com.qy.code.api.enums.sql.IndexType;
import com.qy.code.generator.util.QyUtils;


@Table("t_demo")
public class DemoEntity {
	public static void main(String[] args) {
		QyUtils.createJavaFileAndTableEnforce(DemoEntity.class);
		//执行结束后，刷新entity上级目录或项目，即可看到生成的代码，必要时 maven -> update project。
	}
	
	@Column(id=true,comment="主键")
    private Long id;
    
	@Index(type=IndexType.UNIQUE)
	@Column(comment="唯一索引")
    private String uniqueIndex;
    
	@Column(comment="普通索引")
	@Index(type=IndexType.COMMON)
    private String commonIndex;
    
	@Comment("姓名")
	@Column(value="name")
    private String name;
    
	@Comment("年龄")
	@Column(value="age")
    private Integer age;
    
	@Comment("爱好")
	@Column(value="interest",type=ColumnType.VARCHAR,length=10)
    private String interest;
    
	@Comment("是否已婚")
	@Column(value="married",type=ColumnType.BOOL)
    private boolean married;
	
	@LogicDelete
	@Column(comment="逻辑删除字段")
	private boolean deleteFlag;
	
}
