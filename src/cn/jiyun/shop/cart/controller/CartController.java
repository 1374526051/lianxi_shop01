package cn.jiyun.shop.cart.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.jiyun.shop.cart.pojo.Cart;
import cn.jiyun.shop.cart.pojo.CartItem;
import cn.jiyun.shop.product.service.ProductService;

@Controller
@RequestMapping("cart")
public class CartController {
	
	@Autowired
	private ProductService productService;
	
	//添加购物项
	@RequestMapping("addCartItem")
	public String addCartItem(Integer pid,int count,Model model,HttpServletRequest request){
		
		//创建购物项
		CartItem cartItem = new CartItem();
		//数量
		cartItem.setCount(count);
		//商品 product
		cartItem.setProduct(productService.productByPid(pid));
		
		
		//创建购物车
		Cart cart = getCart(request);
		//添加购物项
		cart.addCartItem(cartItem);
		
		return "cart";
	}
	
	//移除购物项
	@RequestMapping("remove")
	public String remove(int pid,HttpServletRequest request){
		//获取购物车
		Cart cart = getCart(request);
		cart.remove(pid);
		return "cart";
	}
	
	//清空购物车
	@RequestMapping("clear")
	public String clear(HttpServletRequest request){
		//获取购物车
				Cart cart = getCart(request);
				cart.clear();
		return "cart";
	}
	

	//以单例模式创建购物车
	private Cart getCart(HttpServletRequest request) {
		//从session域中获取cart
		Cart cart = (Cart)request.getSession().getAttribute("cart");
		//判断购物车cart是否存在
		if(cart==null){
			//不存在   创建购物车  并存入session域中
			cart = new Cart();
			request.getSession().setAttribute("cart",cart);
			
		}
		
		
		
		return cart;
	}

}
