package com.ruc.gulimall.gulimallproduct.dao;

import com.ruc.gulimall.gulimallproduct.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author xiaowenbin
 * @email 1169215228@qq.com
 * @date 2022-03-15 15:53:17
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
