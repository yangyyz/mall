package com.linyangkai.mallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linyangkai.common.utils.PageUtils;
import com.linyangkai.mallproduct.entity.AttrEntity;

import com.linyangkai.mallproduct.vo.AttrVo;
import java.util.Map;

/**
 * 商品属性
 *
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 15:38:08
 */
public interface AttrService extends IService<AttrEntity> {

  PageUtils queryPage(Map<String, Object> params);

  void saveAttr(AttrVo attr);

  PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId);
}

