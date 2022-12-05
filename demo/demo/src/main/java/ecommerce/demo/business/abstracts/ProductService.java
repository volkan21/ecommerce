package ecommerce.demo.business.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ecommerce.demo.core.DataResult;
import ecommerce.demo.core.Result;
import ecommerce.demo.entities.concretes.Product;
import ecommerce.demo.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	DataResult<List<Product>> getAll();
	
	DataResult<List<Product>> getPage(int pageNo,int pageSize);
	DataResult<List<Product>> getAllSort();
	Result add(Product product);
	
	
		
	DataResult<Product> getByProductName(String productName);
	
	DataResult<Product> getByProductNameAndCategory(String productName,int categoryId);
		
	DataResult<List<Product>> getByProductNameOrCategory(String productName,int categoryId);
		
	DataResult<List<Product>> getByCategoryIn(List<Integer> categories);
	
	DataResult<List<Product>> getByProductNameContains(String productName);
	
	DataResult<List<Product>> getByProductNameStartsWith(String productName);
	
	DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);
	
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
	
	
	

}
