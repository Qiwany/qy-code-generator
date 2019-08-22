package qy.generator.demo.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.qy.code.api.query.Query;
import qy.generator.demo.entity.DemoEntity;
@Mapper
public interface DemoMapper {
	
	/**
	* @author 七脉
	* 描述 Query查询
	* @param query
	* @return
	*/	@Select("<script>"		+"SELECT  id AS id, unique_index AS uniqueIndex, common_index AS commonIndex, name AS name, age AS age, interest AS interest, married AS married, delete_flag AS deleteFlag FROM t_demo "		+"<trim prefix='WHERE' prefixOverrides='and|or'>"		+	"<if test='query.andList != null and query.andList.size>0'>"		+		"<foreach collection='query.andList' item='item' index='index' open=' AND ' close='' separator=' AND '>"		+		"<choose>"		+			"<when test='item.operator==\"eq\"'>"		+				"${item.key} = #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"neq\"'>"		+				"${item.key} != #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"gt\"'>"		+				"${item.key} &gt; #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"ge\"'>"		+				"${item.key} &gt;= #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"lt\"'>"		+				"${item.key} &lt; #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"le\"'>"		+				"${item.key} &lt;= #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"like\"'>"		+				"${item.key} like CONCAT('%',#{item.value},'%')"		+			"</when >"		+			"<when test='item.operator==\"llike\"'>"		+				"${item.key} like CONCAT('%',#{item.value})"		+			"</when >"		+			"<when test='item.operator==\"rlike\"'>"		+				"${item.key} like CONCAT(#{item.value},'%')"		+			"</when >"		+			"<when test='item.operator==\"in\"'>"		+				"<if test='item.value != null and item.value.size>0'>"		+					"${item.key} in"		+					"<foreach collection='item.value' item='inv' index='index' open=' (' close=') ' separator=','>"		+						"#{inv}"		+					"</foreach>"		+				"</if>"		+			"</when >"		+			"<when test='item.operator==\"notin\"'>"		+				"<if test='item.value != null and item.value.size>0'>"		+					"${item.key} not in"		+					"<foreach collection='item.value' item='inv' index='index' open=' (' close=') ' separator=','>"		+						"#{inv}"		+					"</foreach>"		+				"</if>"		+			"</when >"		+			"<when test='item.operator==\"isnull\"'>"		+				"${item.key} is null"		+			"</when >"		+			"<when test='item.operator==\"isnotnull\"'>"		+				"${item.key} is not null"		+			"</when >"		+			"<otherwise>"		+				"${item.key} = #{item.value}"		+			"</otherwise>"		+		"</choose>"		+		"</foreach>"		+	"</if>"		+	"<if test='query.orList != null and query.orList.size>0'>"		+		"<foreach collection='query.orList' item='item' index='index' open=' OR ' close='' separator=' OR '>"		+		"<choose>"		+			"<when test='item.operator==\"eq\"'>"		+				"${item.key} = #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"neq\"'>"		+				"${item.key} != #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"gt\"'>"		+				"${item.key} &gt; #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"ge\"'>"		+				"${item.key} &gt;= #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"lt\"'>"		+				"${item.key} &lt; #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"le\"'>"		+				"${item.key} &lt;= #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"like\"'>"		+				"${item.key} like CONCAT('%',#{item.value},'%')"		+			"</when >"		+			"<when test='item.operator==\"llike\"'>"		+				"${item.key} like CONCAT('%',#{item.value})"		+			"</when >"		+			"<when test='item.operator==\"rlike\"'>"		+				"${item.key} like CONCAT(#{item.value},'%')"		+			"</when >"		+			"<when test='item.operator==\"in\"'>"		+				"<if test='item.value != null and item.value.size>0'>"		+					"${item.key} in"		+					"<foreach collection='item.value' item='inv' index='index' open=' (' close=') ' separator=','>"		+						"#{inv}"		+					"</foreach>"		+				"</if>"		+			"</when >"		+			"<when test='item.operator==\"notin\"'>"		+				"<if test='item.value != null and item.value.size>0'>"		+					"${item.key} not in"		+					"<foreach collection='item.value' item='inv' index='index' open=' (' close=') ' separator=','>"		+						"#{inv}"		+					"</foreach>"		+				"</if>"		+			"</when >"		+			"<when test='item.operator==\"isnull\"'>"		+				"${item.key} is null"		+			"</when >"		+			"<when test='item.operator==\"isnotnull\"'>"		+				"${item.key} is not null"		+			"</when >"		+			"<otherwise>"		+				"${item.key} = #{item.value}"		+			"</otherwise>"		+		"</choose>"		+		"</foreach>"		+	"</if>"		+"</trim>"		+"<if test='query.groupKeys != null and query.groupKeys.size>0'>"		+	" GROUP BY "		+	"<foreach collection='query.groupKeys' item='item' index='index' open='' close='' separator=','>"		+		"${item}"		+	"</foreach>"		+"</if>"		+"<if test='query.sorts != null and query.sorts.size>0'>"		+	" ORDER BY "		+	"<foreach collection='query.sorts' item='item' index='index' open='' close='' separator=','>"		+		"${item.key} ${item.asc}"		+	"</foreach>"		+"</if>"		+"</script>")	List<DemoEntity> selectByQuery(@Param("query") Query query);
	
	/**
	* @author 七脉
	* 描述：主键查询
	* @param id
	* @return
	*/	@Select("SELECT id AS id, unique_index AS uniqueIndex, common_index AS commonIndex, name AS name, age AS age, interest AS interest, married AS married, delete_flag AS deleteFlag FROM t_demo WHERE id = #{id}")	DemoEntity selectById(@Param("id") Long id);
	
	/**
	* @author 七脉
	* 描述：主键查询
	* @param ids
	* @return
	*/	@Select("<script>"		+"SELECT id AS id, unique_index AS uniqueIndex, common_index AS commonIndex, name AS name, age AS age, interest AS interest, married AS married, delete_flag AS deleteFlag FROM t_demo WHERE id IN "		+"<foreach collection='list' item='id' index='index' open='(' close=')' separator=','>"		+"#{id}"		+"</foreach>"		+"</script>")	List<DemoEntity> selectByIds(@Param("list") List<Long>ids);
	
	/**
	* @author 七脉
	* 描述：查询
	* @param map
	* @return
	*/	@Select("<script>"		+"SELECT id AS id, unique_index AS uniqueIndex, common_index AS commonIndex, name AS name, age AS age, interest AS interest, married AS married, delete_flag AS deleteFlag FROM t_demo"		+"<trim prefix='WHERE' prefixOverrides='and|or'>"		+"<if test='id != null'> AND id = #{id}</if>"		+"<if test='uniqueIndex != null'> AND unique_index = #{uniqueIndex}</if>"		+"<if test='commonIndex != null'> AND common_index = #{commonIndex}</if>"		+"<if test='name != null'> AND name = #{name}</if>"		+"<if test='age != null'> AND age = #{age}</if>"		+"<if test='interest != null'> AND interest = #{interest}</if>"		+"<if test='married != null'> AND married = #{married}</if>"		+"<if test='deleteFlag != null'> AND delete_flag = #{deleteFlag}</if>"		+"</trim>"		+"</script>")	List<DemoEntity> select(Map<String,Object> map);
	
	/**
	* @author 七脉
	* 描述：插入
	* @param demoEntity
	* @return
	*/	@Insert("INSERT INTO t_demo ( ID, UNIQUE_INDEX, COMMON_INDEX, NAME, AGE, INTEREST, MARRIED, DELETE_FLAG) VALUES ( #{id}, #{uniqueIndex}, #{commonIndex}, #{name}, #{age}, #{interest}, #{married}, #{deleteFlag})")	boolean insert(DemoEntity demoEntity);
	
	/**
	* @author 七脉
	* 描述：批量插入
	* @param demoEntitys
	* @return
	*/	@Insert("<script>"		+"INSERT INTO t_demo"		+"( ID, UNIQUE_INDEX, COMMON_INDEX, NAME, AGE, INTEREST, MARRIED, DELETE_FLAG)"		+"VALUES "		+"<foreach collection='list' item='item' index='index' separator=','>"		+"( #{item.id}, #{item.uniqueIndex}, #{item.commonIndex}, #{item.name}, #{item.age}, #{item.interest}, #{item.married}, #{item.deleteFlag})"		+"</foreach>"		+"</script>")	boolean insertBatch(@Param("list") List<DemoEntity> demoEntitys);
	
	/**
	* @author 七脉
	* 描述：更新
	* @param demoEntity
	* @return
	*/	@Update("<script>"		+"UPDATE t_demo"		+"<trim prefix='set' suffixOverrides=',' suffix=' WHERE id=#{id}'>"		+" id=#{id},"		+" unique_index=#{uniqueIndex},"		+" common_index=#{commonIndex},"		+" name=#{name},"		+" age=#{age},"		+" interest=#{interest},"		+" married=#{married},"		+" delete_flag=#{deleteFlag},"		+"</trim>"		+"</script>")	boolean update(DemoEntity demoEntity);
	
	/**
	* @author 七脉
	* 描述：更新
	* @param demoEntity
	* @param setNull
	* @return
	*/	@Update("<script>"		+"UPDATE t_demo"		+"<trim prefix='set' suffixOverrides=',' suffix=' WHERE id=#{entity.id}'>"		+"<if test='setNull==true || entity.id!=null'>id=#{entity.id},</if>"		+"<if test='setNull==true || entity.uniqueIndex!=null'>unique_index=#{entity.uniqueIndex},</if>"		+"<if test='setNull==true || entity.commonIndex!=null'>common_index=#{entity.commonIndex},</if>"		+"<if test='setNull==true || entity.name!=null'>name=#{entity.name},</if>"		+"<if test='setNull==true || entity.age!=null'>age=#{entity.age},</if>"		+"<if test='setNull==true || entity.interest!=null'>interest=#{entity.interest},</if>"		+"<if test='setNull==true || entity.married!=null'>married=#{entity.married},</if>"		+"<if test='setNull==true || entity.deleteFlag!=null'>delete_flag=#{entity.deleteFlag},</if>"		+"</trim>"		+"</script>")	boolean updateSetNull(@Param("entity") DemoEntity demoEntity, @Param("setNull") boolean setNull);
	
	/**
	* @author 七脉
	* 描述：批量更新
	* @param demoEntitys
	* @return
	*/	@Update("<script>"		+"<foreach collection='list' item='item' index='index' open='' close='' separator=';'>"		+"UPDATE t_demo"		+"<trim prefix='set' suffixOverrides=',' suffix='WHERE id=#{item.id}'>"		+" id=#{item.id},"		+" unique_index=#{item.uniqueIndex},"		+" common_index=#{item.commonIndex},"		+" name=#{item.name},"		+" age=#{item.age},"		+" interest=#{item.interest},"		+" married=#{item.married},"		+" delete_flag=#{item.deleteFlag},"		+"</trim>"		+"</foreach>"		+"</script>")	boolean updateBatch(@Param("list") List<DemoEntity> demoEntitys);
	
	/**
	* @author 七脉
	* 描述：批量更新
	* @param demoEntitys
	* @param setNull
	* @return
	*/	@Update("<script>"		+"<foreach collection='list' item='item' index='index' open='' close='' separator=';'>"		+"UPDATE t_demo"		+"<trim prefix='set' suffixOverrides=',' suffix='WHERE id=#{item.id}'>"		+"<if test='setNull==true || item.id!=null'>id=#{item.id},</if>"		+"<if test='setNull==true || item.uniqueIndex!=null'>unique_index=#{item.uniqueIndex},</if>"		+"<if test='setNull==true || item.commonIndex!=null'>common_index=#{item.commonIndex},</if>"		+"<if test='setNull==true || item.name!=null'>name=#{item.name},</if>"		+"<if test='setNull==true || item.age!=null'>age=#{item.age},</if>"		+"<if test='setNull==true || item.interest!=null'>interest=#{item.interest},</if>"		+"<if test='setNull==true || item.married!=null'>married=#{item.married},</if>"		+"<if test='setNull==true || item.deleteFlag!=null'>delete_flag=#{item.deleteFlag},</if>"		+"</trim>"		+"</foreach>"		+"</script>")	boolean updateBatchSetNull(@Param("list") List<DemoEntity> demoEntitys, @Param("setNull") boolean setNull);
	
	/**
	* @author 七脉
	* 描述：主键删除
	* @param id
	* @return
	*/	@Update("UPDATE t_demo SET delete_flag = true WHERE id = #{id}")	boolean deleteById(@Param("id") Long id);
	
	/**
	* @author 七脉
	* 描述：实体删除
	* @param demoEntity
	* @return
	*/	@Update("UPDATE t_demo SET delete_flag = true WHERE id = #{id}")	boolean deleteByEntity(DemoEntity demoEntity);
	
	/**
	* @author 七脉
	* 描述：主键批量删除
	* @param ids
	* @return
	*/	@Update("<script>"		+"UPDATE t_demo SET delete_flag = true WHERE id IN "		+"<foreach collection='list' item='id' index='index' open='(' close=')' separator=','>"		+"#{id}"		+"</foreach>"		+"</script>")	boolean deleteByIds(@Param("list") List<Long> ids);
	
	/**
	* @author 七脉
	* 描述：批量删除
	* @param demoEntitys
	* @return
	*/	@Update("<script>"		+"UPDATE t_demo SET delete_flag = true WHERE id IN "		+"<foreach collection='list' item='item' index='index' open='(' close=')' separator=','>"		+"#{item.id}"		+"</foreach>"		+"</script>")	boolean deleteBatch(@Param("list") List<DemoEntity> demoEntitys);
}