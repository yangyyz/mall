package com.linyangkai.mallorder.dao;

import com.linyangkai.mallorder.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 16:17:26
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
