package com.linyangkai.mallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linyangkai.common.utils.PageUtils;
import com.linyangkai.mallproduct.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 15:38:05
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

  PageUtils queryPage(Map<String, Object> params, Long catId);
}

