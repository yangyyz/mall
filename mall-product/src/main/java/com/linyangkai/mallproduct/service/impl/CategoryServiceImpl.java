package com.linyangkai.mallproduct.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linyangkai.common.utils.PageUtils;
import com.linyangkai.common.utils.Query;

import com.linyangkai.mallproduct.dao.CategoryDao;
import com.linyangkai.mallproduct.entity.CategoryEntity;
import com.linyangkai.mallproduct.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements
    CategoryService {

  @Override
  public PageUtils queryPage(Map<String, Object> params) {
    IPage<CategoryEntity> page = this.page(
        new Query<CategoryEntity>().getPage(params),
        new QueryWrapper<CategoryEntity>()
    );

    return new PageUtils(page);
  }

  @Override
  public List<CategoryEntity> listWithTree() {
    //查出所有分类
    List<CategoryEntity> categoryEntities = baseMapper.selectList(null);
    //封装成类
    List<CategoryEntity> collect = categoryEntities.stream()
        .filter((categoryEntity -> categoryEntity.getParentCid() == 0)).map((menu) -> {
          menu.setChildren(getChildren(menu, categoryEntities));
          return menu;
        }).sorted((menu1,menu2)->{
          return (menu1.getSort()==null?0:menu1.getSort())-(menu2.getSort()==null?0:menu2.getSort());
        }).collect(
            Collectors.toList());
    return collect;
  }

  public List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
    List<CategoryEntity> children = all.stream().filter(e -> {
      return e.getParentCid().equals(root.getCatId());
    }).map(e -> {
      e.setChildren(getChildren(e, all));
      return e;
    }).sorted((menu1, menu2) -> {
      return (menu1.getSort()==null?0:menu1.getSort())-(menu2.getSort()==null?0:menu2.getSort());
    }).collect(Collectors.toList());
    return children;
  }
}
