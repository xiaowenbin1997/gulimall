package com.ruc.gulimall.gulimallproduct.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruc.gulimall.gulimallproduct.entity.CategoryEntity;
import com.ruc.gulimall.gulimallproduct.service.CategoryService;
import com.ruc.common.utils.PageUtils;
import com.ruc.common.utils.R;



/**
 * 商品三级分类
 *
 * @author xiaowenbin
 * @email 1169215228@qq.com
 * @date 2022-03-15 17:17:34
 */
@RestController
@RequestMapping("gulimallproduct/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 查出所有分类以及子分类，以树形结构组装起来
     */
    @RequestMapping("/list/tree")
    public R list(){
        List<CategoryEntity> entitied = categoryService.listWithTree();
        return R.ok().put("data", entitied);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{catId}")
    public R info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return R.ok().put("data", category);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //@RequestBody将提交过来的json数据直接转化成CategoryEntity对象
    public R save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update/sort")
    public R updateSort(@RequestBody CategoryEntity[] category){
        categoryService.updateBatchById(Arrays.asList(category));
        return R.ok();
    }
    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CategoryEntity category){
		categoryService.updateCascade(category);

        return R.ok();
    }

    /**
     * 删除
     * @RequestBody:获取请求体，必须发送post请求
     * SpringMVC自动将请求体中的数据（json），转为对应的对象
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] catIds){
        //1.检查当前删除的菜单，是否被别的地方引用
        categoryService.removeMenuByIds(Arrays.asList(catIds));
		categoryService.removeByIds(Arrays.asList(catIds));

        return R.ok();
    }

}
