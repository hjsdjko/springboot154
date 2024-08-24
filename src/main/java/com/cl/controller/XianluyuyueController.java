package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.XianluyuyueEntity;
import com.cl.entity.view.XianluyuyueView;

import com.cl.service.XianluyuyueService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 线路预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-18 10:01:16
 */
@RestController
@RequestMapping("/xianluyuyue")
public class XianluyuyueController {
    @Autowired
    private XianluyuyueService xianluyuyueService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XianluyuyueEntity xianluyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			xianluyuyue.setXueshengzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XianluyuyueEntity> ew = new EntityWrapper<XianluyuyueEntity>();

		PageUtils page = xianluyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianluyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XianluyuyueEntity xianluyuyue, 
		HttpServletRequest request){
        EntityWrapper<XianluyuyueEntity> ew = new EntityWrapper<XianluyuyueEntity>();

		PageUtils page = xianluyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xianluyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XianluyuyueEntity xianluyuyue){
       	EntityWrapper<XianluyuyueEntity> ew = new EntityWrapper<XianluyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xianluyuyue, "xianluyuyue")); 
        return R.ok().put("data", xianluyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XianluyuyueEntity xianluyuyue){
        EntityWrapper< XianluyuyueEntity> ew = new EntityWrapper< XianluyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xianluyuyue, "xianluyuyue")); 
		XianluyuyueView xianluyuyueView =  xianluyuyueService.selectView(ew);
		return R.ok("查询线路预约成功").put("data", xianluyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XianluyuyueEntity xianluyuyue = xianluyuyueService.selectById(id);
		xianluyuyue = xianluyuyueService.selectView(new EntityWrapper<XianluyuyueEntity>().eq("id", id));
        return R.ok().put("data", xianluyuyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XianluyuyueEntity xianluyuyue = xianluyuyueService.selectById(id);
		xianluyuyue = xianluyuyueService.selectView(new EntityWrapper<XianluyuyueEntity>().eq("id", id));
        return R.ok().put("data", xianluyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XianluyuyueEntity xianluyuyue, HttpServletRequest request){
    	xianluyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xianluyuyue);
        xianluyuyueService.insert(xianluyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XianluyuyueEntity xianluyuyue, HttpServletRequest request){
    	xianluyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xianluyuyue);
        xianluyuyueService.insert(xianluyuyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XianluyuyueEntity xianluyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xianluyuyue);
        xianluyuyueService.updateById(xianluyuyue);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<XianluyuyueEntity> list = new ArrayList<XianluyuyueEntity>();
        for(Long id : ids) {
            XianluyuyueEntity xianluyuyue = xianluyuyueService.selectById(id);
            xianluyuyue.setSfsh(sfsh);
            xianluyuyue.setShhf(shhf);
            list.add(xianluyuyue);
        }
        xianluyuyueService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xianluyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
