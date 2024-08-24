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


import com.cl.dao.XianluyuyueDao;
import com.cl.entity.XianluyuyueEntity;
import com.cl.service.XianluyuyueService;
import com.cl.entity.view.XianluyuyueView;

@Service("xianluyuyueService")
public class XianluyuyueServiceImpl extends ServiceImpl<XianluyuyueDao, XianluyuyueEntity> implements XianluyuyueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XianluyuyueEntity> page = this.selectPage(
                new Query<XianluyuyueEntity>(params).getPage(),
                new EntityWrapper<XianluyuyueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XianluyuyueEntity> wrapper) {
		  Page<XianluyuyueView> page =new Query<XianluyuyueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XianluyuyueView> selectListView(Wrapper<XianluyuyueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XianluyuyueView selectView(Wrapper<XianluyuyueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
