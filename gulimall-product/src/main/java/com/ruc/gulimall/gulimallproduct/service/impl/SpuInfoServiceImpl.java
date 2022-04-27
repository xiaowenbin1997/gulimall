package com.ruc.gulimall.gulimallproduct.service.impl;

import com.ruc.gulimall.gulimallproduct.vo.SpuSaveVo;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruc.common.utils.PageUtils;
import com.ruc.common.utils.Query;

import com.ruc.gulimall.gulimallproduct.dao.SpuInfoDao;
import com.ruc.gulimall.gulimallproduct.entity.SpuInfoEntity;
import com.ruc.gulimall.gulimallproduct.service.SpuInfoService;
import org.springframework.transaction.annotation.Transactional;


@Service("spuInfoService")
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoDao, SpuInfoEntity> implements SpuInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SpuInfoEntity> page = this.page(
                new Query<SpuInfoEntity>().getPage(params),
                new QueryWrapper<SpuInfoEntity>()
        );

        return new PageUtils(page);
    }
    @Transactional
    @Override
    public void saveSpuInfo(SpuSaveVo vo) {
        //保存spu基本信息

        //保存spu的描述图片

        //保存spu的图片集

        //保存spu的规格参数

        //保存spu的积分信息

        //保存当前spu对应的sku信息

        //sku之：sku的基本信息

        //sku之：sku的图片信息

        //sku之：sku的销售属性

        //sku之：sku的优惠满减信息
    }

}