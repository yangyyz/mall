package com.linyangkai.mallproduct.controller;

import com.linyangkai.mallproduct.vo.AttrVo;
import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.linyangkai.mallproduct.entity.AttrEntity;
import com.linyangkai.mallproduct.service.AttrService;
import com.linyangkai.common.utils.PageUtils;
import com.linyangkai.common.utils.R;


/**
 * 商品属性
 *
 * @author linyangkai
 * @email 819450837@qq.com
 * @date 2023-04-23 15:38:08
 */
@RestController
@RequestMapping("mallproduct/attr")
public class AttrController {

  @Autowired
  private AttrService attrService;

  @RequestMapping("/list")
  @RequiresPermissions("mallproduct:attr:list")
  public R baseAttrList(@RequestParam Map<String, Object> params) {
    PageUtils page = attrService.queryPage(params);

    return R.ok().put("page", page);
  }

  /**
   * 列表
   */
  @RequestMapping("/base/list/{catelogId}")
  @RequiresPermissions("mallproduct:attr:list")
  public R list(@RequestParam Map<String, Object> params,
      @PathVariable("catelogId") Long catelogId) {
    PageUtils page = attrService.queryBaseAttrPage(params,catelogId);
    return R.ok().put("page", page);
  }

  /**
   * 信息
   */
  @RequestMapping("/info/{attrId}")
  @RequiresPermissions("mallproduct:attr:info")
  public R info(@PathVariable("attrId") Long attrId) {
    AttrEntity attr = attrService.getById(attrId);

    return R.ok().put("attr", attr);
  }

  /**
   * 保存
   */
  @RequestMapping("/save")
  @RequiresPermissions("mallproduct:attr:save")
  public R save(@RequestBody AttrVo attr) {
    attrService.saveAttr(attr);
    return R.ok();
  }

  /**
   * 修改
   */
  @RequestMapping("/update")
  @RequiresPermissions("mallproduct:attr:update")
  public R update(@RequestBody AttrEntity attr) {
    attrService.updateById(attr);

    return R.ok();
  }

  /**
   * 删除
   */
  @RequestMapping("/delete")
  @RequiresPermissions("mallproduct:attr:delete")
  public R delete(@RequestBody Long[] attrIds) {
    attrService.removeByIds(Arrays.asList(attrIds));

    return R.ok();
  }

}
