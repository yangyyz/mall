package com.linyangkai.mallproduct.dao;

import com.linyangkai.mallproduct.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 15:38:05
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
