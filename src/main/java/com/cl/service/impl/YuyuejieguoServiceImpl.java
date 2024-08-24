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


import com.cl.dao.YuyuejieguoDao;
import com.cl.entity.YuyuejieguoEntity;
import com.cl.service.YuyuejieguoService;
import com.cl.entity.view.YuyuejieguoView;

@Service("yuyuejieguoService")
public class YuyuejieguoServiceImpl extends ServiceImpl<YuyuejieguoDao, YuyuejieguoEntity> implements YuyuejieguoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyuejieguoEntity> page = this.selectPage(
                new Query<YuyuejieguoEntity>(params).getPage(),
                new EntityWrapper<YuyuejieguoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyuejieguoEntity> wrapper) {
		  Page<YuyuejieguoView> page =new Query<YuyuejieguoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<YuyuejieguoView> selectListView(Wrapper<YuyuejieguoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YuyuejieguoView selectView(Wrapper<YuyuejieguoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
