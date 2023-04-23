package com.linyangkai.mallcoupon.dao;

import com.linyangkai.mallcoupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 16:33:40
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
