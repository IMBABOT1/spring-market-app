package com.geekbrains.spring.web.converters;

import com.geekbrains.spring.web.dto.ProductDto;
import com.geekbrains.spring.web.entities.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public Product dtoToEntity(ProductDto productDto) {
        return new Product(productDto.getId(), productDto.getTitle(), productDto.getPrice());
    }

    public ProductDto entityToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getPrice(), product.getCategory().getTitle());
    }

    public com.geekbrains.spring.web.soap.Product productToSoapDto(Product product) {
        com.geekbrains.spring.web.soap.Product p = new com.geekbrains.spring.web.soap.Product();
        p.setCategory(product.getCategory().getTitle());
        p.setPrice(product.getPrice());
        p.setId(product.getId());
        p.setTitle(product.getTitle());
        return p;
    }
}
