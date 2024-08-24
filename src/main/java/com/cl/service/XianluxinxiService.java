package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XianluxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XianluxinxiView;


/**
 * 线路信息
 *
 * @author 
 * @email 
 * @date 2024-03-18 10:01:16
 */
public interface XianluxinxiService extends IService<XianluxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XianluxinxiView> selectListView(Wrapper<XianluxinxiEntity> wrapper);
   	
   	XianluxinxiView selectView(@Param("ew") Wrapper<XianluxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XianluxinxiEntity> wrapper);
   	

}

