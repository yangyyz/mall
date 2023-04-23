package com.linyangkai.mallorder.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linyangkai.common.utils.PageUtils;
import com.linyangkai.mallorder.entity.RefundInfoEntity;

import java.util.Map;

/**
 * 退款信息
 *
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 16:17:26
 */
public interface RefundInfoService extends IService<RefundInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

