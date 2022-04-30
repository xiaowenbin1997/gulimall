package com.ruc.gulimall.gulimallcoupon.service.impl;

import com.ruc.common.to.MemberPrice;
import com.ruc.common.to.SkuReductionTo;
import com.ruc.gulimall.gulimallcoupon.entity.MemberPriceEntity;
import com.ruc.gulimall.gulimallcoupon.entity.SkuLadderEntity;
import com.ruc.gulimall.gulimallcoupon.service.MemberPriceService;
import com.ruc.gulimall.gulimallcoupon.service.SkuLadderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruc.common.utils.PageUtils;
import com.ruc.common.utils.Query;

import com.ruc.gulimall.gulimallcoupon.dao.SkuFullReductionDao;
import com.ruc.gulimall.gulimallcoupon.entity.SkuFullReductionEntity;
import com.ruc.gulimall.gulimallcoupon.service.SkuFullReductionService;


@Service("skuFullReductionService")
public class SkuFullReductionServiceImpl extends ServiceImpl<SkuFullReductionDao, SkuFullReductionEntity> implements SkuFullReductionService {
    @Autowired
    SkuLadderService skuLadderService;

    @Autowired
    MemberPriceService memberPriceService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuFullReductionEntity> page = this.page(
                new Query<SkuFullReductionEntity>().getPage(params),
                new QueryWrapper<SkuFullReductionEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public void saveSkuReduction(SkuReductionTo reductionTo) {
        //保存满减打折，会员价
        SkuLadderEntity skuLadderEntity = new SkuLadderEntity();
        skuLadderEntity.setSkuId(reductionTo.getSkuId());
        skuLadderEntity.setFullCount(reductionTo.getFullCount());
        skuLadderEntity.setDiscount(reductionTo.getDiscount());
        skuLadderEntity.setAddOther(reductionTo.getCountStatus());
//        skuLadderEntity.setPrice();
        if (reductionTo.getFullCount() > 0) {
            skuLadderService.save(skuLadderEntity);
        }
        //保存满减信息
        SkuFullReductionEntity reductionEntity = new SkuFullReductionEntity();
        BeanUtils.copyProperties(reductionTo,reductionEntity);
        if (1 == reductionEntity.getFullPrice().compareTo(new BigDecimal("0"))) {
            this.save(reductionEntity);
        }
        //会员价格
        List<MemberPrice> memberPrice = reductionTo.getMemberPrice();
        List<MemberPriceEntity> collect = memberPrice.stream().map(item -> {
            MemberPriceEntity priceEntity = new MemberPriceEntity();
            priceEntity.setSkuId(reductionTo.getSkuId());
            priceEntity.setMemberLevelId(item.getId());
            priceEntity.setMemberLevelName(item.getName());
            priceEntity.setMemberPrice(item.getPrice());
            priceEntity.setAddOther(1);
            return priceEntity;
        }).filter(item -> {
            return item.getMemberPrice().compareTo(new BigDecimal("0")) == 1;
        }).collect(Collectors.toList());
        memberPriceService.saveBatch(collect);
    }

}