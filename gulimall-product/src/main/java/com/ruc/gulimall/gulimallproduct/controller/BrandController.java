package com.ruc.gulimall.gulimallproduct.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


import com.ruc.common.valid.AddGroup;
import com.ruc.common.valid.UpdateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruc.gulimall.gulimallproduct.entity.BrandEntity;
import com.ruc.gulimall.gulimallproduct.service.BrandService;
import com.ruc.common.utils.PageUtils;
import com.ruc.common.utils.R;

import javax.validation.Valid;


/**
 * 品牌
 *
 * @author xiaowenbin
 * @email 1169215228@qq.com
 * @date 2022-03-15 17:17:34
 */
@RestController
@RequestMapping("gulimallproduct/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = brandService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{brandId}")
    public R info(@PathVariable("brandId") Long brandId){
		BrandEntity brand = brandService.getById(brandId);

        return R.ok().put("brand", brand);
    }

    /**
     * 保存  atValid 表示提交的时候需要校验BrandEntity的值
     */
    @RequestMapping("/save")
    public R save(@Validated({AddGroup.class}) @RequestBody BrandEntity brand){
//        输入错误不在这个函数中处理，而放在错误处理类中统一处理
//        if (result.hasErrors()) {
//            Map<String,String> map = new HashMap<>();
//            result.getFieldErrors().forEach(item -> {
//                //获取到错误提示
//                String message = item.getDefaultMessage();
//                //获取错误属性的名字
//                String field = item.getField();
//                map.put(field,message);
//            });
//            return R.error(400,"提交的数据不合法").put("data",map);
//        }
 		brandService.save(brand);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@Validated(UpdateGroup.class) @RequestBody BrandEntity brand){
		brandService.updateById(brand);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] brandIds){
		brandService.removeByIds(Arrays.asList(brandIds));

        return R.ok();
    }

}
