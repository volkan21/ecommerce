package ecommerce.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ecommerce.demo.entities.concretes.Product;
import ecommerce.demo.entities.dtos.ProductWithCategoryDto;

public interface ProductDao extends JpaRepository<Product, Integer> {
	//select * from products where product_name=abc
	Product getByProductName(String productName);
	
	
	//select * from products where product_name=abc and category_id=1
	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
	
	//select * from products where product_name=abc or category_id=1
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
	
	//select * from products where cateogory_id in(1,2,3,4)
	
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	
	List<Product> getByProductNameStartsWith(String productName);
	//select * from products where product_name="something and categoryId="something
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName,int categoryId);
	
	@Query("Select new ecommerce.demo.entities.dtos.ProductWithCategoryDto(p.id,p.productName,c.categoryName) From Category c Inner Join c.products p ")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	
	//select p.productId,p.productName,c.categoryName from Category c innerjoin on c.categoryId=p.categoryId
	
	
	
	

}
