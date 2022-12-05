package ecommerce.demo.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ecommerce.demo.business.abstracts.ProductService;
import ecommerce.demo.core.DataResult;
import ecommerce.demo.core.Result;
import ecommerce.demo.core.SuccessDataResult;
import ecommerce.demo.dataAccess.abstracts.ProductDao;
import ecommerce.demo.entities.concretes.Product;
import ecommerce.demo.entities.dtos.ProductWithCategoryDto;

@Service
public class ProductManager implements ProductService {
	@Autowired
	private ProductDao productdao;

	@Override
	public DataResult<List<Product>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productdao.findAll(),"Product Listelendi");
	}

	@Override
	public Result add(Product product) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Product>(this.productdao.save(product),"Product eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Product>(this.productdao.getByProductName(productName),"getByProductName Listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Product>(this.productdao.getByProductNameAndCategory_CategoryId(productName, categoryId),"getByProductNameandCategoryId Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productdao.getByProductNameOrCategory_CategoryId(productName, categoryId),"getByProductNameorCategory Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productdao.getByCategoryIn(categories),"getByCategoryIdIn Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productdao.getByProductNameContains(productName),"getByProductNameContains Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productdao.getByProductNameStartsWith(productName),"getByProductNameStartsWith Listelendi");
	}
	

	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<Product>>(this.productdao.getByNameAndCategory(productName, categoryId),"getByNameAndCategory Listelendi");
	}

	@Override
	public DataResult<List<Product>> getPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pagable=PageRequest.of(pageNo-1, pageSize);
		return new SuccessDataResult<List<Product>>(this.productdao.findAll(pagable).getContent());
	}

	@Override
	public DataResult<List<Product>> getAllSort() {
		// TODO Auto-generated method stub
		Sort sort=Sort.by(Sort.Direction.ASC,"productName");
		return new SuccessDataResult<List<Product>>(this.productdao.findAll(sort), "Sıralama başarılı");
	}

	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productdao.getProductWithCategoryDetails(),"getProductWithCategoryDetails listelendi");
	}
	}

	


