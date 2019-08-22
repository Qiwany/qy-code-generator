package qy.generator.demo.service.impl;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qy.code.api.query.Query;
import qy.generator.demo.entity.DemoEntity;
import qy.generator.demo.mapper.DemoMapper;
import qy.generator.demo.service.IDemoService;
@Service
public class DemoServiceImpl implements IDemoService{
	@Autowired
	private DemoMapper demoMapper;

	/**
	* Query查询
	*/
	@Override
	public List<DemoEntity> select(Query query) {
		return demoMapper.selectByQuery(query);
	}

	/**
	* 主键查询
	*/
	@Override
	public DemoEntity select(Long id) {
		return demoMapper.selectById(id);
	}

	/**
	* 主键查询
	*/
	@Override
	public List<DemoEntity> select(List<Long> ids) {
		return demoMapper.selectByIds(ids);
	}

	/**
	* 查询
	*/
	@Override
	public List<DemoEntity> select(Map<String,Object> map) {
		return demoMapper.select(map);
	}

	/**
	* 插入
	*/
	@Override
	public boolean insert(DemoEntity demoEntity) {
		return demoMapper.insert(demoEntity);
	}

	/**
	* 批量插入
	*/
	@Override
	public boolean insert(List<DemoEntity> demoEntitys) {
		return demoMapper.insertBatch(demoEntitys);
	}

	/**
	* 更新
	*/
	@Override
	public boolean update(DemoEntity demoEntity) {
		return demoMapper.update(demoEntity);
	}

	/**
	* 更新
	*/
	@Override
	public boolean update(DemoEntity demoEntity, boolean isSetNull) {
		return demoMapper.updateSetNull(demoEntity, isSetNull);
	}

	/**
	* 批量更新
	*/
	@Override
	public boolean update(List<DemoEntity> demoEntitys) {
		return demoMapper.updateBatch(demoEntitys);
	}

	/**
	* 批量更新
	*/
	@Override
	public boolean update(List<DemoEntity> demoEntitys, boolean isSetNull) {
		return demoMapper.updateBatchSetNull(demoEntitys, isSetNull);
	}

	/**
	* 主键删除
	*/
	@Override
	public boolean delete(Long id) {
		return demoMapper.deleteById(id);
	}

	/**
	* 主键删除
	*/
	@Override
	public boolean delete(DemoEntity demoEntity) {
		return demoMapper.deleteByEntity(demoEntity);
	}

	/**
	* 主键批量删除
	*/
	@Override
	public boolean delete(List<Long> ids) {
		return demoMapper.deleteByIds(ids);
	}

	/**
	* 批量删除
	*/
	@Override
	public boolean deletes(List<DemoEntity> demoEntitys) {
		return demoMapper.deleteBatch(demoEntitys);
	}
}