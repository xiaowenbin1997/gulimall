package com.ruc.gulimall.gulimallorder.dao;

import com.ruc.gulimall.gulimallorder.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author xiaowenbin
 * @email 1169215228@qq.com
 * @date 2022-03-15 19:00:04
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
