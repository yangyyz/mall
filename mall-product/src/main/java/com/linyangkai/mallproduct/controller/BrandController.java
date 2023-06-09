package com.linyangkai.mallproduct.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linyangkai.mallproduct.entity.BrandEntity;
import com.linyangkai.mallproduct.service.BrandService;
import com.linyangkai.common.utils.PageUtils;
import com.linyangkai.common.utils.R;


/**
 * 品牌
 *
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 15:38:05
 */
@RestController
@RequestMapping("mallproduct/brand")
public class BrandController {

  @Autowired
  private BrandService brandService;

  /**
   * 列表
   */
  @RequestMapping("/list")
  @RequiresPermissions("mallproduct:brand:list")
  public R list(@RequestParam Map<String, Object> params) {
    PageUtils page = brandService.queryPage(params);
    return R.ok().put("page", page);
  }


  /**
   * 信息
   */
  @RequestMapping("/info/{brandId}")
  @RequiresPermissions("mallproduct:brand:info")
  public R info(@PathVariable("brandId") Long brandId) {
    BrandEntity brand = brandService.getById(brandId);

    return R.ok().put("brand", brand);
  }

  /**
   * 保存
   */
  @RequestMapping("/save")
  @RequiresPermissions("mallproduct:brand:save")
  public R save(@RequestBody BrandEntity brand) {
    brandService.save(brand);
    return R.ok();
  }

  /**
   * 修改
   */
  @RequestMapping("/update")
  @RequiresPermissions("mallproduct:brand:update")
  public R update(@RequestBody BrandEntity brand) {
    brandService.updateById(brand);
    return R.ok();
  }

  /**
   * 删除
   */
  @RequestMapping("/delete")
  @RequiresPermissions("mallproduct:brand:delete")
  public R delete(@RequestBody Long[] brandIds) {
    brandService.removeByIds(Arrays.asList(brandIds));

    return R.ok();
  }

}
