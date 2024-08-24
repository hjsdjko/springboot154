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


import com.cl.dao.JiashiyuanquerenxinxiDao;
import com.cl.entity.JiashiyuanquerenxinxiEntity;
import com.cl.service.JiashiyuanquerenxinxiService;
import com.cl.entity.view.JiashiyuanquerenxinxiView;

@Service("jiashiyuanquerenxinxiService")
public class JiashiyuanquerenxinxiServiceImpl extends ServiceImpl<JiashiyuanquerenxinxiDao, JiashiyuanquerenxinxiEntity> implements JiashiyuanquerenxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiashiyuanquerenxinxiEntity> page = this.selectPage(
                new Query<JiashiyuanquerenxinxiEntity>(params).getPage(),
                new EntityWrapper<JiashiyuanquerenxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiashiyuanquerenxinxiEntity> wrapper) {
		  Page<JiashiyuanquerenxinxiView> page =new Query<JiashiyuanquerenxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiashiyuanquerenxinxiView> selectListView(Wrapper<JiashiyuanquerenxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiashiyuanquerenxinxiView selectView(Wrapper<JiashiyuanquerenxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
