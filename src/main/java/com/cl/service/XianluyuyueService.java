package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XianluyuyueEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XianluyuyueView;


/**
 * 线路预约
 *
 * @author 
 * @email 
 * @date 2024-03-18 10:01:16
 */
public interface XianluyuyueService extends IService<XianluyuyueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XianluyuyueView> selectListView(Wrapper<XianluyuyueEntity> wrapper);
   	
   	XianluyuyueView selectView(@Param("ew") Wrapper<XianluyuyueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XianluyuyueEntity> wrapper);
   	

}

