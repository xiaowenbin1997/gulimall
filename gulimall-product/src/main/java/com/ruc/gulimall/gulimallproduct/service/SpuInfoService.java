package com.ruc.gulimall.gulimallproduct.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruc.common.utils.PageUtils;
import com.ruc.gulimall.gulimallproduct.entity.SpuInfoEntity;
import com.ruc.gulimall.gulimallproduct.vo.SpuSaveVo;

import java.util.Map;

/**
 * spu信息
 *
 * @author xiaowenbin
 * @email 1169215228@qq.com
 * @date 2022-03-15 15:53:17
 */
public interface SpuInfoService extends IService<SpuInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSpuInfo(SpuSaveVo vo);
}

