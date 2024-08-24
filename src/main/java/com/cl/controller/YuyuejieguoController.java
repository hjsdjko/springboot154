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

import com.cl.entity.YuyuejieguoEntity;
import com.cl.entity.view.YuyuejieguoView;

import com.cl.service.YuyuejieguoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 预约结果
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-18 10:01:16
 */
@RestController
@RequestMapping("/yuyuejieguo")
public class YuyuejieguoController {
    @Autowired
    private YuyuejieguoService yuyuejieguoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YuyuejieguoEntity yuyuejieguo,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("xuesheng")) {
			yuyuejieguo.setXueshengzhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("jiashiyuan")) {
			yuyuejieguo.setJiashiyuanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YuyuejieguoEntity> ew = new EntityWrapper<YuyuejieguoEntity>();

		PageUtils page = yuyuejieguoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuejieguo), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YuyuejieguoEntity yuyuejieguo, 
		HttpServletRequest request){
        EntityWrapper<YuyuejieguoEntity> ew = new EntityWrapper<YuyuejieguoEntity>();

		PageUtils page = yuyuejieguoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yuyuejieguo), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YuyuejieguoEntity yuyuejieguo){
       	EntityWrapper<YuyuejieguoEntity> ew = new EntityWrapper<YuyuejieguoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yuyuejieguo, "yuyuejieguo")); 
        return R.ok().put("data", yuyuejieguoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YuyuejieguoEntity yuyuejieguo){
        EntityWrapper< YuyuejieguoEntity> ew = new EntityWrapper< YuyuejieguoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yuyuejieguo, "yuyuejieguo")); 
		YuyuejieguoView yuyuejieguoView =  yuyuejieguoService.selectView(ew);
		return R.ok("查询预约结果成功").put("data", yuyuejieguoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YuyuejieguoEntity yuyuejieguo = yuyuejieguoService.selectById(id);
		yuyuejieguo = yuyuejieguoService.selectView(new EntityWrapper<YuyuejieguoEntity>().eq("id", id));
        return R.ok().put("data", yuyuejieguo);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YuyuejieguoEntity yuyuejieguo = yuyuejieguoService.selectById(id);
		yuyuejieguo = yuyuejieguoService.selectView(new EntityWrapper<YuyuejieguoEntity>().eq("id", id));
        return R.ok().put("data", yuyuejieguo);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YuyuejieguoEntity yuyuejieguo, HttpServletRequest request){
    	yuyuejieguo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuejieguo);
        yuyuejieguoService.insert(yuyuejieguo);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YuyuejieguoEntity yuyuejieguo, HttpServletRequest request){
    	yuyuejieguo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(yuyuejieguo);
        yuyuejieguoService.insert(yuyuejieguo);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YuyuejieguoEntity yuyuejieguo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yuyuejieguo);
        yuyuejieguoService.updateById(yuyuejieguo);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yuyuejieguoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
