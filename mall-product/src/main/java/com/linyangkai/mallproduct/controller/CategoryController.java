package com.linyangkai.mallproduct.controller;

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

import com.linyangkai.mallproduct.entity.CategoryEntity;
import com.linyangkai.mallproduct.service.CategoryService;
import com.linyangkai.common.utils.PageUtils;
import com.linyangkai.common.utils.R;


/**
 * 商品三级分类
 *
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 15:38:05
 */
@RestController
@RequestMapping("mallproduct/category")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @RequestMapping("/list/tree")
  public R list() {
    List<CategoryEntity> categoryEntities = categoryService.listWithTree();
    return R.ok().put("data", categoryEntities);
  }

  /**
   * 列表
   */
  @RequestMapping("/list")
  @RequiresPermissions("mallproduct:category:list")
  public R list(@RequestParam Map<String, Object> params) {
    PageUtils page = categoryService.queryPage(params);

    return R.ok().put("page", page);
  }


  /**
   * 信息
   */
  @RequestMapping("/info/{catId}")
  @RequiresPermissions("mallproduct:category:info")
  public R info(@PathVariable("catId") Long catId) {
    CategoryEntity category = categoryService.getById(catId);

    return R.ok().put("category", category);
  }

  /**
   * 保存
   */
  @RequestMapping("/save")
  @RequiresPermissions("mallproduct:category:save")
  public R save(@RequestBody CategoryEntity category) {
    categoryService.save(category);

    return R.ok();
  }

  /**
   * 修改
   */
  @RequestMapping("/update")
  @RequiresPermissions("mallproduct:category:update")
  public R update(@RequestBody CategoryEntity category) {
    categoryService.updateById(category);

    return R.ok();
  }

  /**
   * 删除
   */
  @RequestMapping("/delete")
  @RequiresPermissions("mallproduct:category:delete")
  public R delete(@RequestBody Long[] catIds) {
    categoryService.removeByIds(Arrays.asList(catIds));

    return R.ok();
  }

}
