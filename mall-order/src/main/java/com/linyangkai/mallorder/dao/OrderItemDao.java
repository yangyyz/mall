package com.linyangkai.mallorder.dao;

import com.linyangkai.mallorder.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 16:17:25
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
