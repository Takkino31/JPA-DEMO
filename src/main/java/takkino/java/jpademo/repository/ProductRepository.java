package takkino.java.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import takkino.java.jpademo.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainsIgnoreCase(String name);

//    @Query("SELECT p FROM  Product p WHERE p.name like %:kw% and p.price>:p")
//    List<Product> search(@Param("kw") String name, @Param("price") double price);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:kw% AND p.price > :price")
    List<Product> search(@Param("kw") String name, @Param("price") double price);


}
