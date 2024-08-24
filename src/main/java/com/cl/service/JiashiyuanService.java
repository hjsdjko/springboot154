package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiashiyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiashiyuanView;


/**
 * 驾驶员
 *
 * @author 
 * @email 
 * @date 2024-03-18 10:01:15
 */
public interface JiashiyuanService extends IService<JiashiyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiashiyuanView> selectListView(Wrapper<JiashiyuanEntity> wrapper);
   	
   	JiashiyuanView selectView(@Param("ew") Wrapper<JiashiyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiashiyuanEntity> wrapper);
   	

}

