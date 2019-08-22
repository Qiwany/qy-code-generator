package qy.generator.demo.service;
import java.util.List;
import java.util.Map;
import com.qy.code.api.query.Query;
import qy.generator.demo.entity.DemoCompositeEntity;
public interface IDemoCompositeService {
	
	/**
	* @author 七脉
	* 描述 Query查询
	* @param query
	* @return
	*/
	List<DemoCompositeEntity> select(Query query);
	
	/**
	* @author 七脉
	* 描述：主键查询
	* @param userId
	* @param roleId
	* @return
	*/
	DemoCompositeEntity select(Integer userId, Integer roleId);
	
	/**
	* @author 七脉
	* 描述：查询
	* @param map
	* @return
	*/
	List<DemoCompositeEntity> select(Map<String,Object> map);
	
	/**
	* @author 七脉
	* 描述：插入
	* @param demoCompositeEntity
	* @return
	*/
	boolean insert(DemoCompositeEntity demoCompositeEntity);
	
	/**
	* @author 七脉
	* 描述：批量插入
	* @param demoCompositeEntitys
	* @return
	*/
	boolean insert(List<DemoCompositeEntity> demoCompositeEntitys);
	
	/**
	* @author 七脉
	* 描述：更新
	* @param demoCompositeEntity
	* @return
	*/
	boolean update(DemoCompositeEntity demoCompositeEntity);
	
	/**
	* @author 七脉
	* 描述：更新
	* @param demoCompositeEntity
	* @param setNull
	* @return
	*/
	boolean update(DemoCompositeEntity demoCompositeEntity, boolean isSetNull);
	
	/**
	* @author 七脉
	* 描述：批量更新
	* @param demoCompositeEntitys
	* @return
	*/
	boolean update(List<DemoCompositeEntity> demoCompositeEntitys);
	
	/**
	* @author 七脉
	* 描述：批量更新
	* @param demoCompositeEntitys
	* @param setNull
	* @return
	*/
	boolean update(List<DemoCompositeEntity> demoCompositeEntitys, boolean isSetNull);
	
	/**
	* @author 七脉
	* 描述：主键删除
	* @param userId
	* @param roleId
	* @return
	*/
	boolean delete(Integer userId, Integer roleId);
	
	/**
	* @author 七脉
	* 描述：主键删除
	* @param userId
	* @param roleId
	* @return
	*/
	boolean delete(DemoCompositeEntity demoCompositeEntity);
}