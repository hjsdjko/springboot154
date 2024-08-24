package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YuyuejieguoEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YuyuejieguoView;


/**
 * 预约结果
 *
 * @author 
 * @email 
 * @date 2024-03-18 10:01:16
 */
public interface YuyuejieguoService extends IService<YuyuejieguoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YuyuejieguoView> selectListView(Wrapper<YuyuejieguoEntity> wrapper);
   	
   	YuyuejieguoView selectView(@Param("ew") Wrapper<YuyuejieguoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YuyuejieguoEntity> wrapper);
   	

}

