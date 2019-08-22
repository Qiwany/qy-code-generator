package qy.generator.demo.mapper;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.qy.code.api.query.Query;
import qy.generator.demo.entity.DemoCompositeEntity;
@Mapper
public interface DemoCompositeMapper {
	
	/**
	* @author 七脉
	* 描述 Query查询
	* @param query
	* @return
	*/	@Select("<script>"		+"SELECT  user_id AS userId, role_id AS roleId FROM demo_composite "		+"<trim prefix='WHERE' prefixOverrides='and|or'>"		+	"<if test='query.andList != null and query.andList.size>0'>"		+		"<foreach collection='query.andList' item='item' index='index' open=' AND ' close='' separator=' AND '>"		+		"<choose>"		+			"<when test='item.operator==\"eq\"'>"		+				"${item.key} = #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"neq\"'>"		+				"${item.key} != #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"gt\"'>"		+				"${item.key} &gt; #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"ge\"'>"		+				"${item.key} &gt;= #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"lt\"'>"		+				"${item.key} &lt; #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"le\"'>"		+				"${item.key} &lt;= #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"like\"'>"		+				"${item.key} like CONCAT('%',#{item.value},'%')"		+			"</when >"		+			"<when test='item.operator==\"llike\"'>"		+				"${item.key} like CONCAT('%',#{item.value})"		+			"</when >"		+			"<when test='item.operator==\"rlike\"'>"		+				"${item.key} like CONCAT(#{item.value},'%')"		+			"</when >"		+			"<when test='item.operator==\"in\"'>"		+				"<if test='item.value != null and item.value.size>0'>"		+					"${item.key} in"		+					"<foreach collection='item.value' item='inv' index='index' open=' (' close=') ' separator=','>"		+						"#{inv}"		+					"</foreach>"		+				"</if>"		+			"</when >"		+			"<when test='item.operator==\"notin\"'>"		+				"<if test='item.value != null and item.value.size>0'>"		+					"${item.key} not in"		+					"<foreach collection='item.value' item='inv' index='index' open=' (' close=') ' separator=','>"		+						"#{inv}"		+					"</foreach>"		+				"</if>"		+			"</when >"		+			"<when test='item.operator==\"isnull\"'>"		+				"${item.key} is null"		+			"</when >"		+			"<when test='item.operator==\"isnotnull\"'>"		+				"${item.key} is not null"		+			"</when >"		+			"<otherwise>"		+				"${item.key} = #{item.value}"		+			"</otherwise>"		+		"</choose>"		+		"</foreach>"		+	"</if>"		+	"<if test='query.orList != null and query.orList.size>0'>"		+		"<foreach collection='query.orList' item='item' index='index' open=' OR ' close='' separator=' OR '>"		+		"<choose>"		+			"<when test='item.operator==\"eq\"'>"		+				"${item.key} = #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"neq\"'>"		+				"${item.key} != #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"gt\"'>"		+				"${item.key} &gt; #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"ge\"'>"		+				"${item.key} &gt;= #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"lt\"'>"		+				"${item.key} &lt; #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"le\"'>"		+				"${item.key} &lt;= #{item.value}"		+			"</when >"		+			"<when test='item.operator==\"like\"'>"		+				"${item.key} like CONCAT('%',#{item.value},'%')"		+			"</when >"		+			"<when test='item.operator==\"llike\"'>"		+				"${item.key} like CONCAT('%',#{item.value})"		+			"</when >"		+			"<when test='item.operator==\"rlike\"'>"		+				"${item.key} like CONCAT(#{item.value},'%')"		+			"</when >"		+			"<when test='item.operator==\"in\"'>"		+				"<if test='item.value != null and item.value.size>0'>"		+					"${item.key} in"		+					"<foreach collection='item.value' item='inv' index='index' open=' (' close=') ' separator=','>"		+						"#{inv}"		+					"</foreach>"		+				"</if>"		+			"</when >"		+			"<when test='item.operator==\"notin\"'>"		+				"<if test='item.value != null and item.value.size>0'>"		+					"${item.key} not in"		+					"<foreach collection='item.value' item='inv' index='index' open=' (' close=') ' separator=','>"		+						"#{inv}"		+					"</foreach>"		+				"</if>"		+			"</when >"		+			"<when test='item.operator==\"isnull\"'>"		+				"${item.key} is null"		+			"</when >"		+			"<when test='item.operator==\"isnotnull\"'>"		+				"${item.key} is not null"		+			"</when >"		+			"<otherwise>"		+				"${item.key} = #{item.value}"		+			"</otherwise>"		+		"</choose>"		+		"</foreach>"		+	"</if>"		+"</trim>"		+"<if test='query.groupKeys != null and query.groupKeys.size>0'>"		+	" GROUP BY "		+	"<foreach collection='query.groupKeys' item='item' index='index' open='' close='' separator=','>"		+		"${item}"		+	"</foreach>"		+"</if>"		+"<if test='query.sorts != null and query.sorts.size>0'>"		+	" ORDER BY "		+	"<foreach collection='query.sorts' item='item' index='index' open='' close='' separator=','>"		+		"${item.key} ${item.asc}"		+	"</foreach>"		+"</if>"		+"</script>")	List<DemoCompositeEntity> selectByQuery(@Param("query") Query query);
	
	/**
	* @author 七脉
	* 描述：主键查询
	* @param userId
	* @param roleId
	* @return
	*/	@Select("SELECT user_id AS userId, role_id AS roleId FROM demo_composite WHERE user_id = #{userId} AND role_id = #{roleId}")	DemoCompositeEntity selectById(@Param("userId") Integer userId, @Param("roleId") Integer roleId);
	
	/**
	* @author 七脉
	* 描述：查询
	* @param map
	* @return
	*/	@Select("<script>"		+"SELECT user_id AS userId, role_id AS roleId FROM demo_composite"		+"<trim prefix='WHERE' prefixOverrides='and|or'>"		+"<if test='userId != null'> AND user_id = #{userId}</if>"		+"<if test='roleId != null'> AND role_id = #{roleId}</if>"		+"</trim>"		+"</script>")	List<DemoCompositeEntity> select(Map<String,Object> map);
	
	/**
	* @author 七脉
	* 描述：插入
	* @param demoCompositeEntity
	* @return
	*/	@Insert("INSERT INTO demo_composite ( USER_ID, ROLE_ID) VALUES ( #{userId}, #{roleId})")	boolean insert(DemoCompositeEntity demoCompositeEntity);
	
	/**
	* @author 七脉
	* 描述：批量插入
	* @param demoCompositeEntitys
	* @return
	*/	@Insert("<script>"		+"INSERT INTO demo_composite"		+"( USER_ID, ROLE_ID)"		+"VALUES "		+"<foreach collection='list' item='item' index='index' separator=','>"		+"( #{item.userId}, #{item.roleId})"		+"</foreach>"		+"</script>")	boolean insertBatch(@Param("list") List<DemoCompositeEntity> demoCompositeEntitys);
	
	/**
	* @author 七脉
	* 描述：更新
	* @param demoCompositeEntity
	* @return
	*/	@Update("<script>"		+"UPDATE demo_composite"		+"<trim prefix='set' suffixOverrides=',' suffix=' WHERE user_id=#{userId} AND role_id=#{roleId}'>"		+" user_id=#{userId},"		+" role_id=#{roleId},"		+"</trim>"		+"</script>")	boolean update(DemoCompositeEntity demoCompositeEntity);
	
	/**
	* @author 七脉
	* 描述：更新
	* @param demoCompositeEntity
	* @param setNull
	* @return
	*/	@Update("<script>"		+"UPDATE demo_composite"		+"<trim prefix='set' suffixOverrides=',' suffix=' WHERE user_id=#{entity.userId} AND role_id=#{entity.roleId}'>"		+"<if test='setNull==true || entity.userId!=null'>user_id=#{entity.userId},</if>"		+"<if test='setNull==true || entity.roleId!=null'>role_id=#{entity.roleId},</if>"		+"</trim>"		+"</script>")	boolean updateSetNull(@Param("entity") DemoCompositeEntity demoCompositeEntity, @Param("setNull") boolean setNull);
	
	/**
	* @author 七脉
	* 描述：批量更新
	* @param demoCompositeEntitys
	* @return
	*/	@Update("<script>"		+"<foreach collection='list' item='item' index='index' open='' close='' separator=';'>"		+"UPDATE demo_composite"		+"<trim prefix='set' suffixOverrides=',' suffix='WHERE user_id=#{item.userId} AND role_id=#{item.roleId}'>"		+" user_id=#{item.userId},"		+" role_id=#{item.roleId},"		+"</trim>"		+"</foreach>"		+"</script>")	boolean updateBatch(@Param("list") List<DemoCompositeEntity> demoCompositeEntitys);
	
	/**
	* @author 七脉
	* 描述：批量更新
	* @param demoCompositeEntitys
	* @param setNull
	* @return
	*/	@Update("<script>"		+"<foreach collection='list' item='item' index='index' open='' close='' separator=';'>"		+"UPDATE demo_composite"		+"<trim prefix='set' suffixOverrides=',' suffix='WHERE user_id=#{item.userId} AND role_id=#{item.roleId}'>"		+"<if test='setNull==true || item.userId!=null'>user_id=#{item.userId},</if>"		+"<if test='setNull==true || item.roleId!=null'>role_id=#{item.roleId},</if>"		+"</trim>"		+"</foreach>"		+"</script>")	boolean updateBatchSetNull(@Param("list") List<DemoCompositeEntity> demoCompositeEntitys, @Param("setNull") boolean setNull);
	
	/**
	* @author 七脉
	* 描述：主键删除
	* @param userId
	* @param roleId
	* @return
	*/	@Delete("DELETE FROM demo_composite WHERE user_id = #{userId} AND role_id = #{roleId}")	boolean deleteById(@Param("userId") Integer userId, @Param("roleId") Integer roleId);
	
	/**
	* @author 七脉
	* 描述：实体删除
	* @param demoCompositeEntity
	* @return
	*/	@Delete("DELETE FROM demo_composite WHERE user_id = #{userId} AND role_id = #{roleId}")	boolean deleteByEntity(DemoCompositeEntity demoCompositeEntity);
}