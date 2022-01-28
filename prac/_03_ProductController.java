//package com.sparta.selectshop2.prac;
//
//import com.sparta.selectshop2.model.Product;
//import com.sparta.selectshop2.dto.ProductMypriceRequestDto;
//import com.sparta.selectshop2.dto.ProductRequestDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.sql.SQLException;
//import java.util.List;
//
//@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
//@RestController // JSON으로 데이터를 주고받음을 선언합니다.
//public class _03_ProductController {
//
//    // 신규 상품 등록
//    @PostMapping("/api/products")
//    public Product createProduct(@RequestBody ProductRequestDto requestDto) throws SQLException {
//        _03_ProductService a03ProductService = new _03_ProductService();
//        Product product = a03ProductService.createProduct(requestDto);
//
//// 응답 보내기
//        return product;
//    }
//
//    // 설정 가격 변경
//    @PutMapping("/api/products/{id}")
//    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) throws SQLException {
//        _03_ProductService a03ProductService = new _03_ProductService();
//        Product product = a03ProductService.updateProduct(id, requestDto);
//
//// 응답 보내기 (업데이트된 상품 id)
//        return product.getId();
//    }
//
//    // 등록된 전체 상품 목록 조회
//    @GetMapping("/api/products")
//    public List<Product> getProducts() throws SQLException {
//        _03_ProductService a03ProductService = new _03_ProductService();
//        List<Product> products = a03ProductService.getProducts();
//
//// 응답 보내기
//        return products;
//    }
//}