package qy.generator.demo.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;


import qy.generator.demo.mapper.DemoCompositeMapper;
import qy.generator.demo.service.IDemoCompositeService;

public class DemoCompositeServiceImpl implements IDemoCompositeService{

	private DemoCompositeMapper demoCompositeMapper;

	/**
	* Query查询
	*/
	@Override
	public List<DemoCompositeEntity> select(Query query) {
		return demoCompositeMapper.selectByQuery(query);
	}

	/**
	* 主键查询
	*/
	@Override
	public DemoCompositeEntity select(Integer userId, Integer roleId) {
		return demoCompositeMapper.selectById(userId, roleId);
	}

	/**
	* 查询
	*/
	@Override
	public List<DemoCompositeEntity> select(Map<String,Object> map) {
		return demoCompositeMapper.select(map);
	}

	/**
	* 插入
	*/
	@Override
	public boolean insert(DemoCompositeEntity demoCompositeEntity) {
		return demoCompositeMapper.insert(demoCompositeEntity);
	}

	/**
	* 批量插入
	*/
	@Override
	public boolean insert(List<DemoCompositeEntity> demoCompositeEntitys) {
		return demoCompositeMapper.insertBatch(demoCompositeEntitys);
	}

	/**
	* 更新
	*/
	@Override
	public boolean update(DemoCompositeEntity demoCompositeEntity) {
		return demoCompositeMapper.update(demoCompositeEntity);
	}

	/**
	* 更新
	*/
	@Override
	public boolean update(DemoCompositeEntity demoCompositeEntity, boolean isSetNull) {
		return demoCompositeMapper.updateSetNull(demoCompositeEntity, isSetNull);
	}

	/**
	* 批量更新
	*/
	@Override
	public boolean update(List<DemoCompositeEntity> demoCompositeEntitys) {
		return demoCompositeMapper.updateBatch(demoCompositeEntitys);
	}

	/**
	* 批量更新
	*/
	@Override
	public boolean update(List<DemoCompositeEntity> demoCompositeEntitys, boolean isSetNull) {
		return demoCompositeMapper.updateBatchSetNull(demoCompositeEntitys, isSetNull);
	}

	/**
	* 主键删除
	*/
	@Override
	public boolean delete(Integer userId, Integer roleId) {
		return demoCompositeMapper.deleteById(userId, roleId);
	}

	/**
	* 主键删除
	*/
	@Override
	public boolean delete(DemoCompositeEntity demoCompositeEntity) {
		return demoCompositeMapper.deleteByEntity(demoCompositeEntity);
	}
