package com.ruc.gulimall.gulimallware.vo;

import lombok.Data;

import java.util.List;

@Data
public class MergeVo {
    private Long purchaseId;//整单id
    private List<Long> items;//合并项目的集合
}
