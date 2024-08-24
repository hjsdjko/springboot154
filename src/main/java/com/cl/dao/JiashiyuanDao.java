package com.cl.dao;

import com.cl.entity.JiashiyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiashiyuanView;


/**
 * 驾驶员
 * 
 * @author 
 * @email 
 * @date 2024-03-18 10:01:15
 */
public interface JiashiyuanDao extends BaseMapper<JiashiyuanEntity> {
	
	List<JiashiyuanView> selectListView(@Param("ew") Wrapper<JiashiyuanEntity> wrapper);

	List<JiashiyuanView> selectListView(Pagination page,@Param("ew") Wrapper<JiashiyuanEntity> wrapper);
	
	JiashiyuanView selectView(@Param("ew") Wrapper<JiashiyuanEntity> wrapper);
	

}
