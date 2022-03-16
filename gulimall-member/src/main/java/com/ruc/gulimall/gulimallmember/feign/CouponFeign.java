package com.ruc.gulimall.gulimallmember.feign;


import com.ruc.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gulimallcoupon")
public interface CouponFeign {
    @RequestMapping("/gulimallcoupon/coupon/member/list")
    public R memberCoupons();
}
