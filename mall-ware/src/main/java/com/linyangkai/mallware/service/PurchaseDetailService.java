package com.linyangkai.mallware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linyangkai.common.utils.PageUtils;
import com.linyangkai.mallware.entity.PurchaseDetailEntity;

import java.util.Map;

/**
 * 
 *
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 16:41:12
 */
public interface PurchaseDetailService extends IService<PurchaseDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

