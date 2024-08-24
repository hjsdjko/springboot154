package com.cl.dao;

import com.cl.entity.YuyuejieguoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyuejieguoView;


/**
 * 预约结果
 * 
 * @author 
 * @email 
 * @date 2024-03-18 10:01:16
 */
public interface YuyuejieguoDao extends BaseMapper<YuyuejieguoEntity> {
	
	List<YuyuejieguoView> selectListView(@Param("ew") Wrapper<YuyuejieguoEntity> wrapper);

	List<YuyuejieguoView> selectListView(Pagination page,@Param("ew") Wrapper<YuyuejieguoEntity> wrapper);
	
	YuyuejieguoView selectView(@Param("ew") Wrapper<YuyuejieguoEntity> wrapper);
	

}
