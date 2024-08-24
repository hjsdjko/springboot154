package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiashiyuanquerenxinxiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiashiyuanquerenxinxiView;


/**
 * 驾驶员确认信息
 *
 * @author 
 * @email 
 * @date 2024-03-18 10:01:16
 */
public interface JiashiyuanquerenxinxiService extends IService<JiashiyuanquerenxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiashiyuanquerenxinxiView> selectListView(Wrapper<JiashiyuanquerenxinxiEntity> wrapper);
   	
   	JiashiyuanquerenxinxiView selectView(@Param("ew") Wrapper<JiashiyuanquerenxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiashiyuanquerenxinxiEntity> wrapper);
   	

}

