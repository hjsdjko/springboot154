package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.JiashiyuanDao;
import com.cl.entity.JiashiyuanEntity;
import com.cl.service.JiashiyuanService;
import com.cl.entity.view.JiashiyuanView;

@Service("jiashiyuanService")
public class JiashiyuanServiceImpl extends ServiceImpl<JiashiyuanDao, JiashiyuanEntity> implements JiashiyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiashiyuanEntity> page = this.selectPage(
                new Query<JiashiyuanEntity>(params).getPage(),
                new EntityWrapper<JiashiyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiashiyuanEntity> wrapper) {
		  Page<JiashiyuanView> page =new Query<JiashiyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiashiyuanView> selectListView(Wrapper<JiashiyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiashiyuanView selectView(Wrapper<JiashiyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
