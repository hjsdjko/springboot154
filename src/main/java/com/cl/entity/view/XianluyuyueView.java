package com.cl.entity.view;

import com.cl.entity.XianluyuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 线路预约
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-18 10:01:16
 */
@TableName("xianluyuyue")
public class XianluyuyueView  extends XianluyuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XianluyuyueView(){
	}
 
 	public XianluyuyueView(XianluyuyueEntity xianluyuyueEntity){
 	try {
			BeanUtils.copyProperties(this, xianluyuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}