package com.ruc.gulimall.gulimallware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruc.common.utils.PageUtils;
import com.ruc.gulimall.gulimallware.entity.PurchaseEntity;
import com.ruc.gulimall.gulimallware.vo.MergeVo;
import com.ruc.gulimall.gulimallware.vo.PurchaseDoneVo;

import java.util.List;
import java.util.Map;

/**
 * 采购信息
 *
 * @author xiaowenbin
 * @email 1169215228@qq.com
 * @date 2022-04-29 22:11:39
 */
public interface PurchaseService extends IService<PurchaseEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPageUnreceivePurchase(Map<String, Object> params);

    void mergePurchase(MergeVo mergeVo);

    void received(List<Long> ids);

    void done(PurchaseDoneVo doneVo);
}

