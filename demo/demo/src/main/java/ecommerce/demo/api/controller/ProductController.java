package ecommerce.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.demo.business.abstracts.ProductService;
import ecommerce.demo.core.DataResult;
import ecommerce.demo.core.Result;
import ecommerce.demo.entities.concretes.Product;
import ecommerce.demo.entities.dtos.ProductWithCategoryDto;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService productservice;
	
	
	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productservice.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody Product product){
		return this.productservice.add(product);
	}
	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName){
		return this.productservice.getByProductName(productName);
	}
	@GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> getByProductNameAndCategory(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
		return this.productservice.getByProductNameAndCategory(productName, categoryId);
	}
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
		return this.productservice.getByProductNameContains(productName);
	}
	
	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getPage(int pageNo,int pageSize){
		return this.productservice.getPage(pageNo, pageSize);
	}
	@GetMapping("/getAllSort")
	
	public DataResult<List<Product>> getAllSort(){
		return this.productservice.getAllSort();
	}
	@GetMapping("getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		return this.productservice.getProductWithCategoryDetails();
	}
	

}
