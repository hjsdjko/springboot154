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


import com.cl.dao.XianluxinxiDao;
import com.cl.entity.XianluxinxiEntity;
import com.cl.service.XianluxinxiService;
import com.cl.entity.view.XianluxinxiView;

@Service("xianluxinxiService")
public class XianluxinxiServiceImpl extends ServiceImpl<XianluxinxiDao, XianluxinxiEntity> implements XianluxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XianluxinxiEntity> page = this.selectPage(
                new Query<XianluxinxiEntity>(params).getPage(),
                new EntityWrapper<XianluxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XianluxinxiEntity> wrapper) {
		  Page<XianluxinxiView> page =new Query<XianluxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XianluxinxiView> selectListView(Wrapper<XianluxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XianluxinxiView selectView(Wrapper<XianluxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
