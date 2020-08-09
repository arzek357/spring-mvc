package com.vtb.zolotarev.spring.mvc.services;

import com.vtb.zolotarev.spring.mvc.model.Product;
import com.vtb.zolotarev.spring.mvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product findProductById(long id) {
        return productRepository.findProductById(id);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAllProducts();
    }

    public void deleteProductById(long id){
        productRepository.deleteProductById(id);
    }
}
