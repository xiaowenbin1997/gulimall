package com.ruc.gulimall.gulimallproduct;

import com.aliyun.oss.*;
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.ruc.gulimall.gulimallproduct.entity.BrandEntity;
//import com.ruc.gulimall.gulimallproduct.service.BrandService;
import com.ruc.gulimall.gulimallproduct.service.CategoryService;
import javafx.application.Application;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

@Slf4j
@SpringBootTest()
class GulimallProductApplicationTests {

//    @Autowired
//    BrandService brandService;


//    @Test
//    void contextLoads() {
////        BrandEntity brandEntity = new BrandEntity();
////        brandEntity.setName("华为");
////        brandService.save(brandEntity);
////        BrandEntity brandEntity = new BrandEntity();
////        brandEntity.setBrandId(1L);
////        brandEntity.setDescript("华子");
////        brandService.updateById(brandEntity);
////        System.out.println("保存成功");
////        BrandEntity brand = brandService.getOne(new QueryWrapper<BrandEntity>().eq("brand_id", 1L));
////        System.out.println(brand);
//    }
    @Autowired
    CategoryService categoryService;

    @Test
    public void testFindPath() {
        Long[] path = categoryService.findCatelogPath(225L);
        log.info("path:{}", Arrays.asList(path));
    }

}
