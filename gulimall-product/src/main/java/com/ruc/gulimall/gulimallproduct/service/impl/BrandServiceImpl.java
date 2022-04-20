package com.ruc.gulimall.gulimallproduct.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruc.common.utils.PageUtils;
import com.ruc.common.utils.Query;

import com.ruc.gulimall.gulimallproduct.dao.BrandDao;
import com.ruc.gulimall.gulimallproduct.entity.BrandEntity;
import com.ruc.gulimall.gulimallproduct.service.BrandService;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");

        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                new QueryWrapper<BrandEntity>().eq("brand_id",key).or().like("name",key)
        );

        return new PageUtils(page);
    }

}