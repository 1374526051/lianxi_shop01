package cn.jiyun.shop.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.jiyun.shop.product.pojo.Product;
import cn.jiyun.shop.product.service.ProductService;

@Controller
@RequestMapping("product")
public class ProductConreoller {
	
	@Autowired
	private ProductService productService;
	
	//根据热门商品ID查询商品详情
	@RequestMapping("productByPid")
	public String productByPid(Integer pid,Model model){
		
		Product product = productService.productByPid(pid);
		model.addAttribute("product", product);
		
		return "product";
	}
	
	//根据cid查询所属的所有商品
		@RequestMapping("findProductByCid")
		public String findProductByCid(@RequestParam(required=true,defaultValue="1")Integer pageNum,Integer cid,Model model){
			//封装pagehepler
			PageHelper.startPage(pageNum,12);
			List<Product> plist = productService.findProductByCid(cid);
			//封装pageINfo
			PageInfo<Product> page = new PageInfo<>(plist);
			model.addAttribute("page",page);
			model.addAttribute("cid",cid);
			
			
			return "plist";
		}

}
