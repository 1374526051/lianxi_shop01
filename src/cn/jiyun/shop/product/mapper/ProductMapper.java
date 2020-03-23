package cn.jiyun.shop.product.mapper;

import cn.jiyun.shop.product.pojo.Product;
import cn.jiyun.shop.product.pojo.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    //查询热门商品
	List<Product> findAllProduct();

	//查询最新商品
	List<Product> findNewProduct();

	//根据cid查询所有的商品
	List<Product> findProductByCid(Integer cid);
}