package com.ruc.gulimall.gulimallware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruc.common.utils.PageUtils;
import com.ruc.gulimall.gulimallware.entity.WareOrderTaskDetailEntity;

import java.util.Map;

/**
 * 库存工作单
 *
 * @author xiaowenbin
 * @email 1169215228@qq.com
 * @date 2022-04-29 22:11:39
 */
public interface WareOrderTaskDetailService extends IService<WareOrderTaskDetailEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

