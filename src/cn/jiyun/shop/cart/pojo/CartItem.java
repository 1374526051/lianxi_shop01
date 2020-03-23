package cn.jiyun.shop.cart.pojo;

import cn.jiyun.shop.product.pojo.Product;

public class CartItem {
	
	//商品 product   图片   名称   价格
	private Product product;
	//数量
	private int count;
	//小计
	private double subTotal;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubTotal() {
		//小计=商品的价格*数量
		return product.getShopPrice()*count;
	}
	
	
	
	
	
	

}
