package com.linyangkai.mallproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linyangkai.mallproduct.entity.CategoryBrandRelationEntity;
import com.linyangkai.mallproduct.service.CategoryBrandRelationService;
import com.linyangkai.common.utils.PageUtils;
import com.linyangkai.common.utils.R;


/**
 * 品牌分类关联
 *
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 15:38:05
 */
@RestController
@RequestMapping("mallproduct/categorybrandrelation")
public class CategoryBrandRelationController {

  @Autowired
  private CategoryBrandRelationService categoryBrandRelationService;

  @RequestMapping("/catelog/list")
  @RequiresPermissions("mallproduct:categorybrandrelation:list")
  public R list(@RequestParam("brandId") Long brandId) {
    List<CategoryBrandRelationEntity> data = categoryBrandRelationService.list(
        new QueryWrapper<CategoryBrandRelationEntity>().eq("brandId", brandId));
    return R.ok().put("data", data);
  }



  /**
   * 列表
   */
  @RequestMapping("/list")
  @RequiresPermissions("mallproduct:categorybrandrelation:list")
  public R list(@RequestParam Map<String, Object> params) {
    PageUtils page = categoryBrandRelationService.queryPage(params);

    return R.ok().put("page", page);
  }


  /**
   * 信息
   */
  @RequestMapping("/info/{id}")
  @RequiresPermissions("mallproduct:categorybrandrelation:info")
  public R info(@PathVariable("id") Long id) {
    CategoryBrandRelationEntity categoryBrandRelation = categoryBrandRelationService.getById(id);

    return R.ok().put("categoryBrandRelation", categoryBrandRelation);
  }

  /**
   * 保存
   */
  @RequestMapping("/save")
  @RequiresPermissions("mallproduct:categorybrandrelation:save")
  public R save(@RequestBody CategoryBrandRelationEntity categoryBrandRelation) {

    categoryBrandRelationService.saveDetails(categoryBrandRelation);

    return R.ok();
  }

  /**
   * 修改
   */
  @RequestMapping("/update")
  @RequiresPermissions("mallproduct:categorybrandrelation:update")
  public R update(@RequestBody CategoryBrandRelationEntity categoryBrandRelation) {
    categoryBrandRelationService.updateById(categoryBrandRelation);

    return R.ok();
  }

  /**
   * 删除
   */
  @RequestMapping("/delete")
  @RequiresPermissions("mallproduct:categorybrandrelation:delete")
  public R delete(@RequestBody Long[] ids) {
    categoryBrandRelationService.removeByIds(Arrays.asList(ids));

    return R.ok();
  }

}
