package cn.jiyun.shop.product.service;

import java.util.List;

import cn.jiyun.shop.product.pojo.Product;

public interface ProductService {

	//查询热门商品
	List<Product> findAllProduct();

	//查询最新商品
	List<Product> findNewProduct();

	//根据热门商品ID查询商品详情
	Product productByPid(Integer pid);

	//根据cid查询所有的商品
	List<Product> findProductByCid(Integer cid);

	

}
