package qy.generator.demo.service;
import java.util.List;
import java.util.Map;
import com.qy.code.api.query.Query;
import qy.generator.demo.entity.DemoEntity;
public interface IDemoService {
	
	/**
	* @author 七脉
	* 描述 Query查询
	* @param query
	* @return
	*/
	List<DemoEntity> select(Query query);
	
	/**
	* @author 七脉
	* 描述：主键查询
	* @param id
	* @return
	*/
	DemoEntity select(Long id);
	
	/**
	* @author 七脉
	* 描述：主键查询
	* @param ids
	* @return
	*/
	List<DemoEntity> select(List<Long>ids);
	
	/**
	* @author 七脉
	* 描述：查询
	* @param map
	* @return
	*/
	List<DemoEntity> select(Map<String,Object> map);
	
	/**
	* @author 七脉
	* 描述：插入
	* @param demoEntity
	* @return
	*/
	boolean insert(DemoEntity demoEntity);
	
	/**
	* @author 七脉
	* 描述：批量插入
	* @param demoEntitys
	* @return
	*/
	boolean insert(List<DemoEntity> demoEntitys);
	
	/**
	* @author 七脉
	* 描述：更新
	* @param demoEntity
	* @return
	*/
	boolean update(DemoEntity demoEntity);
	
	/**
	* @author 七脉
	* 描述：更新
	* @param demoEntity
	* @param setNull
	* @return
	*/
	boolean update(DemoEntity demoEntity, boolean isSetNull);
	
	/**
	* @author 七脉
	* 描述：批量更新
	* @param demoEntitys
	* @return
	*/
	boolean update(List<DemoEntity> demoEntitys);
	
	/**
	* @author 七脉
	* 描述：批量更新
	* @param demoEntitys
	* @param setNull
	* @return
	*/
	boolean update(List<DemoEntity> demoEntitys, boolean isSetNull);
	
	/**
	* @author 七脉
	* 描述：主键删除
	* @param id
	* @return
	*/
	boolean delete(Long id);
	
	/**
	* @author 七脉
	* 描述：主键删除
	* @param id
	* @return
	*/
	boolean delete(DemoEntity demoEntity);
	
	/**
	* @author 七脉
	* 描述：主键批量删除
	* @param ids
	* @return
	*/
	boolean delete(List<Long> ids);
	
	/**
	* @author 七脉
	* 描述：批量删除
	* @param demoEntitys
	* @return
	*/
	boolean deletes(List<DemoEntity> demoEntitys);
}