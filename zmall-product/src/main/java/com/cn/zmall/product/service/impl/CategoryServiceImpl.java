package com.cn.zmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.zmall.common.utils.PageUtils;
import com.cn.zmall.common.utils.Query;
import com.cn.zmall.product.dao.CategoryDao;
import com.cn.zmall.product.entity.CategoryEntity;
import com.cn.zmall.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(new Query<CategoryEntity>().getPage(params), new QueryWrapper<CategoryEntity>());

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1、查出所有分类
        List<CategoryEntity> categoryList = baseMapper.selectList(null);
        //2、组装父子结构
        List<CategoryEntity> leve1 = categoryList.stream().filter((categoryEntity -> categoryEntity.getCatLevel() == 1)
        ).map((menu) -> {
            //1)去递归查询子菜单
            menu.setChildren(getChildren(menu, categoryList));
            return menu;
        }).sorted(Comparator.comparing(CategoryEntity::getSort, Comparator.nullsLast(Integer::compareTo))
        ).collect(Collectors.toList());
        return leve1;
    }

    /**
     * 递归查询子菜单
     *
     * @param root
     * @param all
     * @return
     */
    private List<CategoryEntity> getChildren(CategoryEntity root, List<CategoryEntity> all) {
        List<CategoryEntity> children = all.stream().filter((categoryEntity) -> categoryEntity.getParentCid().equals(root.getCatId())
        ).map((menu) -> {
            menu.setChildren(getChildren(menu, all));
            return menu;
        }).sorted(Comparator.comparing(CategoryEntity::getSort, Comparator.nullsLast((Integer::compareTo)))
        ).collect(Collectors.toList());
        return children;
    }

}