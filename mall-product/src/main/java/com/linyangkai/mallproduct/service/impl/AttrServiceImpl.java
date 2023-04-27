package com.linyangkai.mallproduct.service.impl;

import com.linyangkai.mallproduct.dao.AttrAttrgroupRelationDao;
import com.linyangkai.mallproduct.dao.AttrGroupDao;
import com.linyangkai.mallproduct.dao.CategoryDao;
import com.linyangkai.mallproduct.entity.AttrAttrgroupRelationEntity;
import com.linyangkai.mallproduct.entity.AttrGroupEntity;
import com.linyangkai.mallproduct.entity.CategoryEntity;
import com.linyangkai.mallproduct.vo.AttrRespVo;
import com.linyangkai.mallproduct.vo.AttrVo;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.linyangkai.common.utils.PageUtils;
import com.linyangkai.common.utils.Query;

import com.linyangkai.mallproduct.dao.AttrDao;
import com.linyangkai.mallproduct.entity.AttrEntity;
import com.linyangkai.mallproduct.service.AttrService;


@Service("attrService")
public class AttrServiceImpl extends ServiceImpl<AttrDao, AttrEntity> implements AttrService {

  @Autowired
  AttrAttrgroupRelationDao attrAttrgroupRelationDao;
  @Autowired
  AttrGroupDao attrGroupDao;

  @Autowired
  CategoryDao categoryDao;

  @Override
  public PageUtils queryPage(Map<String, Object> params) {
    IPage<AttrEntity> page = this.page(
        new Query<AttrEntity>().getPage(params),
        new QueryWrapper<AttrEntity>()
    );

    return new PageUtils(page);
  }

  @Override
  public void saveAttr(AttrVo attr) {
    AttrEntity attrEntity = new AttrEntity();
    BeanUtils.copyProperties(attr, attrEntity);
    this.save(attrEntity);
    AttrAttrgroupRelationEntity relationEntity = new AttrAttrgroupRelationEntity();
    relationEntity.setAttrGroupId(attr.getAttrGroupId());
    relationEntity.setAttrId(attrEntity.getAttrId());
    attrAttrgroupRelationDao.insert(relationEntity);
  }

  @Override
  public PageUtils queryBaseAttrPage(Map<String, Object> params, Long catelogId) {
    QueryWrapper<AttrEntity> queryWrapper = new QueryWrapper<>();
    if (!catelogId.equals(0)) {
      queryWrapper.eq("catelog_id", catelogId);
    }
    String key = (String) params.get("key");
    if (!StringUtils.isBlank(key)) {
      queryWrapper.and((wrapper) -> {
        wrapper.eq("attr_id", key).or().like("attr_name", key);
      });
    }
    IPage<AttrEntity> page = this.page(
        new Query<AttrEntity>().getPage(params),
        queryWrapper
    );
    List<AttrEntity> records = page.getRecords();
    List<AttrRespVo> respVos = records.stream().map(e -> {
      AttrRespVo attrRespVo = new AttrRespVo();
      BeanUtils.copyProperties(e, attrRespVo);
      AttrAttrgroupRelationEntity attr = attrAttrgroupRelationDao.selectOne(
          new QueryWrapper<AttrAttrgroupRelationEntity>().eq("attr_id", e.getAttrId()));
      if(attr!=null){
        AttrGroupEntity attrGroupEntity = attrGroupDao.selectById(attr.getAttrGroupId());
        attrRespVo.setGroupName(attrGroupEntity.getAttrGroupName());
      }
      CategoryEntity categoryEntity = categoryDao.selectById(e.getCatelogId());
      if(categoryEntity!=null){
        attrRespVo.setCatelogName(categoryEntity.getName());
      }
      return attrRespVo;
    }).collect(Collectors.toList());
    PageUtils pageUtils = new PageUtils(page);
    pageUtils.setList(respVos);
    return pageUtils;
  }

}
