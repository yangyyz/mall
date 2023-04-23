package com.linyangkai.mallcoupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linyangkai.common.utils.PageUtils;
import com.linyangkai.mallcoupon.entity.CouponHistoryEntity;

import java.util.Map;

/**
 * 优惠券领取历史记录
 *
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 16:33:40
 */
public interface CouponHistoryService extends IService<CouponHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

