package com.cl.dao;

import com.cl.entity.JiashiyuanquerenxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiashiyuanquerenxinxiView;


/**
 * 驾驶员确认信息
 * 
 * @author 
 * @email 
 * @date 2024-03-18 10:01:16
 */
public interface JiashiyuanquerenxinxiDao extends BaseMapper<JiashiyuanquerenxinxiEntity> {
	
	List<JiashiyuanquerenxinxiView> selectListView(@Param("ew") Wrapper<JiashiyuanquerenxinxiEntity> wrapper);

	List<JiashiyuanquerenxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiashiyuanquerenxinxiEntity> wrapper);
	
	JiashiyuanquerenxinxiView selectView(@Param("ew") Wrapper<JiashiyuanquerenxinxiEntity> wrapper);
	

}
