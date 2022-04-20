package com.ruc.gulimall.gulimallproduct.service.impl;

import com.ruc.gulimall.gulimallproduct.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.util.StringUtils;


@Service("brandService")
public class BrandServiceImpl extends ServiceImpl<BrandDao, BrandEntity> implements BrandService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String key = (String) params.get("key");

        IPage<BrandEntity> page = this.page(
                new Query<BrandEntity>().getPage(params),
                new QueryWrapper<BrandEntity>().eq("brand_id",key).or().like("name",key)
        );

        return new PageUtils(page);
    }

    //本函数是为了同时更新其他表关联本表的字段和本表有的字段
    @Override
    public void updateDetail(BrandEntity brand) {
        this.updateById(brand);
        if (!StringUtils.isEmpty(brand.getName())) {
            categoryBrandRelationService.updateBrand(brand.getBrandId(),brand.getName());
        }
        //todo 更新其他关联上品牌表的信息
    }

}