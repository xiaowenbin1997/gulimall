package com.ruc.gulimall.gulimallproduct.vo;

import lombok.Data;

@Data
public class AttrRespVo extends AttrVo {
    /** 这一步加上分类名字和分组名字,用来传数据
     * "catelogName": "手机/数码/手机", //所属分类名字
     * 			"groupName": "主体", //所属分组名字
     */
    private String catelogName;
    private String groupName;
    private Long[] catelogPath;
}
