package com.sparta.selectshop2.service;

import com.sparta.selectshop2.model.Product;
import com.sparta.selectshop2.dto.ProductMypriceRequestDto;
import com.sparta.selectshop2.repository.ProductRepository;
import com.sparta.selectshop2.dto.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component // 해당 클래스의 객체 생성 -> IOC(제어의 역전) container에 저장
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository ProductRepository) {
        this.productRepository = ProductRepository;
    }

//    @Autowired
//    public ProductService(ApplicationContext context) {
//        // 1.'빈' 이름으로 가져오기
//        ProductRepository productRepository = (ProductRepository) context.getBean("productRepository");
//        // 2.'빈' 클래스 형식으로 가져오기
//        // ProductRepository productRepository = context.getBean(ProductRepository.class);
//        this.productRepository = productRepository;
//    }

    public Product createProduct(ProductRequestDto requestDto, Long userId ) {
        // 요청받은 DTO 로 DB에 저장할 객체 만들기
        Product product = new Product(requestDto, userId);

        productRepository.save(product);

        return product;
    }

    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) {
        Product product = productRepository.findById(id).orElseThrow(() -> new NullPointerException("해당 아이디가 존재하지 않습니다."));


        int myprice = requestDto.getMyprice();
        product.setMyprice(myprice);
        productRepository.save(product);

        return product;
    }

    // 회원 ID 로 등록된 상품 조회
    public List<Product> getProducts(Long userId) {
        return productRepository.findAllByUserId(userId);
    }

    // 관리자용 상품 전체 조회
    public List<Product> getAllProducts() {
        return  productRepository.findAll();
    }
}