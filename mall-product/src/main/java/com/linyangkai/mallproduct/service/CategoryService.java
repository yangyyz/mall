package com.linyangkai.mallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.linyangkai.common.utils.PageUtils;
import com.linyangkai.mallproduct.entity.CategoryEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品三级分类
 *
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 15:38:05
 */
public interface CategoryService extends IService<CategoryEntity> {

  PageUtils queryPage(Map<String, Object> params);

  List<CategoryEntity> listWithTree();
}

