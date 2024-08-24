package com.cl.dao;

import com.cl.entity.XianluxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XianluxinxiView;


/**
 * 线路信息
 * 
 * @author 
 * @email 
 * @date 2024-03-18 10:01:16
 */
public interface XianluxinxiDao extends BaseMapper<XianluxinxiEntity> {
	
	List<XianluxinxiView> selectListView(@Param("ew") Wrapper<XianluxinxiEntity> wrapper);

	List<XianluxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<XianluxinxiEntity> wrapper);
	
	XianluxinxiView selectView(@Param("ew") Wrapper<XianluxinxiEntity> wrapper);
	

}
