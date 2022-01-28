//package com.sparta.selectshop2.prac;
//
//import com.sparta.selectshop2.model.Product;
//import com.sparta.selectshop2.dto.ProductMypriceRequestDto;
//import com.sparta.selectshop2.dto.ProductRequestDto;
//import com.sparta.selectshop2.prac._03_ProductRepository;
//
//import java.sql.SQLException;
//import java.util.List;
//
//public class _04_ProductService {
//
//    private final _03_ProductRepository a03ProductRepository;
//
//    public _04_ProductService() {
//        _03_ProductRepository a03ProductRepository = new _03_ProductRepository();
//        this.a03ProductRepository = a03ProductRepository;
//    }
//
//    public Product createProduct(ProductRequestDto requestDto) throws SQLException {
//// 요청받은 DTO 로 DB에 저장할 객체 만들기
//        Product product = new Product(requestDto);
//
//        a03ProductRepository.createProduct(product);
//
//        return product;
//    }
//
//    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto) throws SQLException {
//        Product product = a03ProductRepository.getProduct(id);
//        if (product == null) {
//            throw new NullPointerException("해당 아이디가 존재하지 않습니다.");
//        }
//
//        int myprice = requestDto.getMyprice();
//        a03ProductRepository.updateMyprice(id, myprice);
//
//        return product;
//    }
//
//    public List<Product> getProducts() throws SQLException {
//        List<Product> products = a03ProductRepository.getProducts();
//
//        return products;
//    }
//}