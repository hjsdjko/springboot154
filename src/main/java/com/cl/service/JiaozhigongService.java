package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiaozhigongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaozhigongView;


/**
 * 教职工
 *
 * @author 
 * @email 
 * @date 2024-03-18 10:01:15
 */
public interface JiaozhigongService extends IService<JiaozhigongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaozhigongView> selectListView(Wrapper<JiaozhigongEntity> wrapper);
   	
   	JiaozhigongView selectView(@Param("ew") Wrapper<JiaozhigongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaozhigongEntity> wrapper);
   	

}

