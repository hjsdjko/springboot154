package com.cl.entity.view;

import com.cl.entity.JiashiyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 驾驶员
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-18 10:01:15
 */
@TableName("jiashiyuan")
public class JiashiyuanView  extends JiashiyuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiashiyuanView(){
	}
 
 	public JiashiyuanView(JiashiyuanEntity jiashiyuanEntity){
 	try {
			BeanUtils.copyProperties(this, jiashiyuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
