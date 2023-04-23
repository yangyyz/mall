package com.linyangkai.mallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linyangkai.common.utils.PageUtils;
import com.linyangkai.mallproduct.entity.ProductAttrValueEntity;

import java.util.Map;

/**
 * spu属性值
 *
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 15:38:08
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

