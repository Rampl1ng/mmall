package com.rampling.mmall.vo;

import lombok.Data;

import java.util.List;

/**
 * @Description : 商品类型的视图实体类
 * @Author : Rampling
 * @Date : Created in 10:04 2021/02/07
 **/
@Data
public class ProductCategoryVO {
    private Integer id;
    private String name;
    private List<ProductCategoryVO> children;
    private String bannerImg;
    private String topImg;

    public ProductCategoryVO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }


}
