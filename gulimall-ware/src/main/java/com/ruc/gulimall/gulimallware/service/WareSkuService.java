package com.ruc.gulimall.gulimallware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruc.common.utils.PageUtils;
import com.ruc.gulimall.gulimallware.entity.WareSkuEntity;

import java.util.Map;

/**
 * 商品库存
 *
 * @author xiaowenbin
 * @email 1169215228@qq.com
 * @date 2022-04-29 22:11:39
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void addStock(Long skuId, Long wareId, Integer skuNum);
}

