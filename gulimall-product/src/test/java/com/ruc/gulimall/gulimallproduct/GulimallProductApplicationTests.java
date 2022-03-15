package com.ruc.gulimall.gulimallproduct;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruc.gulimall.gulimallproduct.entity.BrandEntity;
import com.ruc.gulimall.gulimallproduct.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GulimallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setName("华为");
//        brandService.save(brandEntity);
//        BrandEntity brandEntity = new BrandEntity();
//        brandEntity.setBrandId(1L);
//        brandEntity.setDescript("华子");
//        brandService.updateById(brandEntity);
//        System.out.println("保存成功");
        BrandEntity brand = brandService.getOne(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
        System.out.println(brand);
    }

}
