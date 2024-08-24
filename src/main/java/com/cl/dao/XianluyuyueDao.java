package com.cl.dao;

import com.cl.entity.XianluyuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XianluyuyueView;


/**
 * 线路预约
 * 
 * @author 
 * @email 
 * @date 2024-03-18 10:01:16
 */
public interface XianluyuyueDao extends BaseMapper<XianluyuyueEntity> {
	
	List<XianluyuyueView> selectListView(@Param("ew") Wrapper<XianluyuyueEntity> wrapper);

	List<XianluyuyueView> selectListView(Pagination page,@Param("ew") Wrapper<XianluyuyueEntity> wrapper);
	
	XianluyuyueView selectView(@Param("ew") Wrapper<XianluyuyueEntity> wrapper);
	

}
