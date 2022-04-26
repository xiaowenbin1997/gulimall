package com.ruc.gulimall.gulimallproduct.controller;

import java.util.Arrays;
import java.util.Map;


import com.ruc.gulimall.gulimallproduct.vo.AttrGroupRelationVo;
import com.ruc.gulimall.gulimallproduct.vo.AttrRespVo;
import com.ruc.gulimall.gulimallproduct.vo.AttrVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ruc.gulimall.gulimallproduct.entity.AttrEntity;
import com.ruc.gulimall.gulimallproduct.service.AttrService;
import com.ruc.common.utils.PageUtils;
import com.ruc.common.utils.R;



/**
 * 商品属性
 *
 * @author xiaowenbin
 * @email 1169215228@qq.com
 * @date 2022-03-15 17:17:34
 */
@RestController
@RequestMapping("gulimallproduct/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    ///product/attr/base/list/{catelogId}
    //product/attr/sale/list/0?
    //基本属性和销售属性其实是通过同一个方法处理的
    @GetMapping("/{attrType}/list/{catelogId}")
    public R baseAttrList(@RequestParam Map<String,Object> params,
                          @PathVariable Long catelogId,
                          @PathVariable("attrType") String type) {

        PageUtils page = attrService.queryBaseAttrPage(params,catelogId,type);
        return R.ok().put("page",page);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = attrService.queryPage(params);

        return R.ok().put("data", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{attrId}")
    public R info(@PathVariable("attrId") Long attrId){
//		AttrEntity attr = attrService.getById(attrId);
        AttrRespVo attr = attrService.getAttrInfo(attrId);
        return R.ok().put("attr", attr);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AttrVo attr){
		attrService.saveAttr(attr);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody AttrVo attr){
//		attrService.updateById(attr);
        attrService.updateAttr(attr);
        return R.ok();
    }



    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return R.ok();
    }

}
