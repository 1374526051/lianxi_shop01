package cn.jiyun.shop.category.service;

import java.util.List;

import cn.jiyun.shop.category.pojo.Category;

public interface CategoryService {

	//查询一级分类
	//List<Category> findAllCategory();

	//查询一级分类以及关联的二级分类
	List<Category> findAllCategoryAndSecond();

}
