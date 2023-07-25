package com.scytalys.mytechnikon.repository;

import com.scytalys.mytechnikon.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {

    Property findByPin(Long pin);

    @Query("""
                select p from Property p
                join fetch User u
                where u.tin = :tin
            """)
    List<Property> findByTin(Long tin);

    @Query("""
                select p from Property p
                join fetch User u
                where u.id = :userId
            """)
    List<Property> findPropertyByUser(Long userId);

    List<Property> findByPropertyType(String propertyType);

//    @Query("""
//                select p from Property p
//                where p.constructionYear >= :yearFrom and p.constructionYear <= :yearTo
//            """)
    List<Property> findByConstructionYearBetween(int yearFrom, int yearTo);
}
