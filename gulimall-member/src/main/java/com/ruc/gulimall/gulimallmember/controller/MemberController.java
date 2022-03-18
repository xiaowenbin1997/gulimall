package com.ruc.gulimall.gulimallmember.controller;

import java.util.Arrays;
import java.util.Map;


import com.ruc.gulimall.gulimallmember.feign.CouponFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruc.gulimall.gulimallmember.entity.MemberEntity;
import com.ruc.gulimall.gulimallmember.service.MemberService;
import com.ruc.common.utils.PageUtils;
import com.ruc.common.utils.R;



/**
 * 会员
 *
 * @author xiaowenbin
 * @email 1169215228@qq.com
 * @date 2022-03-15 18:43:29
 */
@RestController
@RequestMapping("gulimallmember/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    @Autowired
    private CouponFeign couponFeign;

    @RequestMapping("/test")
    public R test(){
        MemberEntity entity = new MemberEntity();
        entity.setNickname("lisi");
        R coupons = couponFeign.memberCoupons();
        return R.ok().put("member",entity).put("coupons", coupons.get("coupons"));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = memberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		MemberEntity member = memberService.getById(id);

        return R.ok().put("member", member);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MemberEntity member){
		memberService.save(member);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MemberEntity member){
		memberService.updateById(member);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		memberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}