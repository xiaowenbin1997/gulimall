package com.ruc.gulimall.gulimallmember.dao;

import com.ruc.gulimall.gulimallmember.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author xiaowenbin
 * @email 1169215228@qq.com
 * @date 2022-03-15 18:43:29
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
