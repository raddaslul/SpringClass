//package com.sparta.selectshop2.prac;
//
//import com.sparta.selectshop2.prac._04_ProductRepository;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class _04_BeanConfiguration {
//
//    @Bean
//    public _04_ProductRepository productRepository() {
//        String dbUrl = "jdbc:h2:mem:springcoredb";
//        String dbId = "sa";
//        String dbPassword = "";
//
//        return new _04_ProductRepository(dbUrl, dbId, dbPassword);
//    }
//}


// JpaRepository가 다 대신 해준다