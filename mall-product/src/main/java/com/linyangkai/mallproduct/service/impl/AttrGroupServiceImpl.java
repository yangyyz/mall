package com.linyangkai.mallproduct.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linyangkai.common.utils.PageUtils;
import com.linyangkai.common.utils.Query;

import com.linyangkai.mallproduct.dao.AttrGroupDao;
import com.linyangkai.mallproduct.entity.AttrGroupEntity;
import com.linyangkai.mallproduct.service.AttrGroupService;
import org.springframework.util.StringUtils;


@Service("attrGroupService")
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupDao, AttrGroupEntity> implements
    AttrGroupService {

  @Override
  public PageUtils queryPage(Map<String, Object> params) {
    IPage<AttrGroupEntity> page = this.page(
        new Query<AttrGroupEntity>().getPage(params),
        new QueryWrapper<AttrGroupEntity>()
    );

    return new PageUtils(page);
  }

  @Override
  public PageUtils queryPage(Map<String, Object> params, Long catelogId) {
    if (catelogId.equals(0)) {
      IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
          new QueryWrapper<AttrGroupEntity>());
      return new PageUtils(page);
    } else {
      String key = (String) params.get("key");
      QueryWrapper<AttrGroupEntity> wrapper = new QueryWrapper<AttrGroupEntity>().eq("catelog_id",
          catelogId);
      if (!StringUtils.isEmpty(key)) {
        wrapper.and(obj -> {
          obj.like("attr_group_id", key).or().like("attr_group_name", key);
        });
      }
      IPage<AttrGroupEntity> page = this.page(new Query<AttrGroupEntity>().getPage(params),
          wrapper);
      return new PageUtils(page);
    }
  }

}
