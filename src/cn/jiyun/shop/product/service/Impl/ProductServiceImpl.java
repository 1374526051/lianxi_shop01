package cn.jiyun.shop.product.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jiyun.shop.product.mapper.ProductMapper;
import cn.jiyun.shop.product.pojo.Product;
import cn.jiyun.shop.product.service.ProductService;
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;

	//查询热门商品
	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return productMapper.findAllProduct();
	}
	
	//查询最新商品
	@Override
	public List<Product> findNewProduct() {
		// TODO Auto-generated method stub
		return productMapper.findNewProduct();
	}

	//根据热门商品ID查询商品详情
	@Override
	public Product productByPid(Integer pid) {
		// TODO Auto-generated method stub
		return productMapper.selectByPrimaryKey(pid);
	}

	//根据cid查询所有的商品
	@Override
	public List<Product> findProductByCid(Integer cid) {
		// TODO Auto-generated method stub
		return productMapper.findProductByCid(cid);
	}

	
	

}
