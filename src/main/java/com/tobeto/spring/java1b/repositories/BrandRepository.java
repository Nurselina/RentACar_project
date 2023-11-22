package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

//DATA JPA
//Generic bir fonksiyonun kullanıldığı yere göre tipi değişiyro
//Generic türler referance type olmak zorundadır
public interface BrandRepository extends JpaRepository <Brand,Integer> {
    //veri erişim katmanı / objesi

}