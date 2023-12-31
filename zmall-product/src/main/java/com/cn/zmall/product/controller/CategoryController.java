package com.cn.zmall.product.controller;

import com.alibaba.nacos.shaded.com.google.j2objc.annotations.Weak;
import com.cn.zmall.common.utils.PageUtils;
import com.cn.zmall.common.utils.R;
import com.cn.zmall.product.entity.CategoryEntity;
import com.cn.zmall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;


/**
 * 商品三级分类
 *
 * @author chennan
 * @email 905394587@qq.com
 * @date 2023-08-14 09:48:20
 */
@RestController
@RequestMapping("product/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = categoryService.queryPage(params);

        return R.ok().put("page", page);
    }

    /**
     * 列出所有分类及子分类 以树形结构组装
     */
    @RequestMapping("/list/tree")
    public R listTree() {
        return R.ok().put("data", categoryService.listWithTree());
    }

    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId) {
        CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("category", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CategoryEntity category) {
        categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryEntity category) {
        categoryService.updateById(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update/drag")
    public R updateDragChanges(@RequestBody CategoryEntity[] categoryList) {
        categoryService.updateBatchById(Arrays.asList(categoryList));

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds) {
//        categoryService.removeByIds(Arrays.asList(catIds));

        categoryService.removeMenuByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
