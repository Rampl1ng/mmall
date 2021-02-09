package com.rampling.mmall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rampling.mmall.entity.ProductCategory;
import com.rampling.mmall.mapper.ProductCategoryMapper;
import com.rampling.mmall.service.ProductCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.rampling.mmall.vo.ProductCategoryVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Rampling
 * @since 2021-02-06
 */
@Service
public class ProductCategoryServiceImpl extends ServiceImpl<ProductCategoryMapper, ProductCategory> implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    /**
     * 根据普通实体类获取vo实体类
     * @return 封装好的商品分类
     */
    @Override
    public List<ProductCategoryVO> getAllProductCategoryVO() {
        // 转化普通实体类为VO实体类
        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<>();
        wrapper.eq("type", 1);
        List<ProductCategory> levelOneList = productCategoryMapper.selectList(wrapper);
        // 通过遍历集合进行赋值vo
//        List<ProductCategoryVO> levelOneVO = new ArrayList<>();
//        for (ProductCategory productCategory : levelOne) {
//            ProductCategoryVO productCategoryVO = new ProductCategoryVO();
//            BeanUtils.copyProperties(productCategory, productCategoryVO);
//            levelOneVO.add(productCategoryVO);
//        }
        List<ProductCategoryVO> levelOneVOList = levelOneList.stream()
                .map(e -> new ProductCategoryVO(e.getId(), e.getName())).collect(Collectors.toList());

        // 获取分类的图像
        // bug：需要图片的数量支持，且图片与文本内容也不对应。
        for (int i = 0; i < levelOneVOList.size(); i++) {
            levelOneVOList.get(i).setBannerImg("/images/banner" + i + ".png");
            levelOneVOList.get(i).setTopImg("/images/top" + i + ".png");
        }

        for (ProductCategoryVO levelOneVO : levelOneVOList) {
            wrapper = new QueryWrapper<>();
            wrapper.eq("type", 2);
            wrapper.eq("parent_id", levelOneVO.getId());
            List<ProductCategory> levelTwoList = productCategoryMapper.selectList(wrapper);
            List<ProductCategoryVO> levelTwoVOList = levelTwoList.stream()
                    .map(e -> new ProductCategoryVO(e.getId(), e.getName())).collect(Collectors.toList());
            levelOneVO.setChildren(levelTwoVOList);

            for (ProductCategoryVO levelTwoVO : levelTwoVOList) {
                wrapper = new QueryWrapper<>();
                wrapper.eq("type", 3);
                wrapper.eq("parent_id", levelTwoVO.getId());
                List<ProductCategory> levelThreeList = productCategoryMapper.selectList(wrapper);
                List<ProductCategoryVO> levelThreeVOList = levelThreeList.stream()
                        .map(e -> new ProductCategoryVO(e.getId(), e.getName())).collect(Collectors.toList());
                levelTwoVO.setChildren(levelThreeVOList);
            }
        }

        return levelOneVOList;
    }
}
