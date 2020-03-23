package cn.jiyun.shop.cart.pojo;

import java.util.Collection;
import java.util.LinkedHashMap;

public class Cart {
	//为了购物车的操作  使用map集合存储购物项  购物车的增删比较频繁  使用linkedHashMap<Integer,CartItem>
//	使用商品的主键pid作为键  把购物项作为值
	
	//购物项
	private LinkedHashMap<Integer,CartItem> map = new LinkedHashMap<Integer,CartItem>();

	//总金额
	private double total;
	
	
	/**
	 * 购物车功能：
	 *    1.添加购物项
	 *    2.移除购物项
	 *    3.清空购物车
	 *    4.获取总金额
	 *    5.获取所有的购物项  目的用于页面遍历
	 * 
	 */
//	 1.添加购物项
	
	public void addCartItem(CartItem cartItem){
		
		//获取新添加商品的pid
		Integer pid = cartItem.getProduct().getPid();
		
		//判断购物车中 是否有新添加的商品
		if(map.containsKey(pid)){
			//  有  数量累加即可
			//获取已存在的数量
//			int oldCount = map.get(pid).getCount();
			//获取新添加的数量
//			int newCount  = cartItem.getCount();
			
			map.get(pid).setCount(map.get(pid).getCount()+cartItem.getCount());
			
		}else{
			
			//  没有直接存入
			map.put(pid, cartItem);
			
		}
		
		//总金额发生变化
//		total = total+cartItem.getSubTotal();
		//改进
		total+=cartItem.getSubTotal();
		
		
	}
	
	
	//移除购物项
	public void remove(int pid){
		
		//map集合根据键移除值返回的就是移除的值
		CartItem cartItem = map.remove(pid);
		
		//总金额发生变化
		total-=cartItem.getSubTotal();
	}
	
	//清空购物车
	public void clear(){
		
		map.clear();
	
	
		//总金额归0
		total=0.0;
		
		
	}
	//获取总金额
	public double getTotal(){
		
		return total;
	}
	
	//获取所有购物项
	public Collection<CartItem> getCartItems(){
		//获取map中所有的值
		return map.values();
		
	}
	
	
	
}
