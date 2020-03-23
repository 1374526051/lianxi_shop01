package cn.jiyun.shop.category.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jiyun.shop.category.mapper.CategoryMapper;
import cn.jiyun.shop.category.pojo.Category;
import cn.jiyun.shop.category.pojo.CategoryExample;
import cn.jiyun.shop.category.service.CategoryService;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;

	//查询一级分类
//	@Override
//	public List<Category> findAllCategory() {
//
//		CategoryExample example = new CategoryExample();
//		List<Category> ulist = categoryMapper.selectByExample(example);
//		
//		return ulist;
//	}

	//查询一级分类及其二级分类
	@Override
	public List<Category> findAllCategoryAndSecond() {
		List<Category> clist = categoryMapper.findAllCategoryAndSecond();
		return clist;
	}

}
