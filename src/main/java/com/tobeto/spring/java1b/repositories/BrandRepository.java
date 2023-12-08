package com.tobeto.spring.java1b.repositories;

import com.tobeto.spring.java1b.entities.Brand;
import com.tobeto.spring.java1b.services.dtos.responses.brand.GetBrandListResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//DATA JPA
//Generic bir fonksiyonun kullanıldığı yere göre tipi değişiyro
//Generic türler referance type olmak zorundadır
public interface BrandRepository extends JpaRepository <Brand,Integer> {
    //veri erişim katmanı / objesi

    //Derived Query Methods
    List<Brand> findByNameLikeOrIdEquals(String name, int id);
    List<Brand> findByName(String name);

    boolean existsByName(String name);  //find'ın exists hali varsa true yoksa false dönecek

    //JPA + SQL => JPQL
    // JPQL => SQL'dekinin tersine tablo ismi değil entity ismi kullanır.
    @Query("SELECT b FROM Brand b Where b.name=:name")
    List<Brand> search(String name);

    @Query(value = "Select * from brands Where name LIKE  %:name%", nativeQuery = true)  //nativeQuery : ben burada sql sorgu kullanacağım demek
    List<Brand> search2(String name);

    // b => Brand
    // expected => BetBrandListResponse
    @Query("SELECT new com.tobeto.spring.java1b.services.dtos.responses.brand.GetBrandListResponse(b.name)  FROM Brand b Where b.name LIKE  %:name%")
    List<GetBrandListResponse> search3(String name);
}