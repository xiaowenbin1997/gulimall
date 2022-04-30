package com.ruc.gulimall.gulimallproduct.feign;

import com.ruc.common.to.SkuReductionTo;
import com.ruc.common.to.SpuBoundTo;
import com.ruc.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("gulimall-coupon")
public interface CouponFeignService {
    /**CouponFeignService.saveSpuBounds(spuBoundTo)
     * 1)@RequestBody将这个对象转为json
     * 2)找到gulimall-coupon服务，给/coupon/spubounds/save发送请求
     * 将上一步转的json放在请求体位置，发送请求
     * 3)对方服务接收请求，请求体中有json数据
     * 其实两个json形参如果内部变量一样的话也是可以转换的
     *
     * 只要json数据模型是兼容的，双方服务无需使用一个to
     *
     * @param spuBoundTo
     * @return
     */
    @PostMapping("/gulimallcoupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("/gulimallcoupon/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}
