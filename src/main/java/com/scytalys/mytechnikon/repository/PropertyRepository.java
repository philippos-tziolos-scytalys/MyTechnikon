package com.scytalys.mytechnikon.repository;

import com.scytalys.mytechnikon.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    @Query("""
                select p from Property p
                where p.pin = :pin
            """)
    Property findByPin(Long pin);

    @Query("""
                select p from Property p
                join fetch User u
                where u.tin = :tin
            """)
    Optional<List<Property>> findByTin(Long tin);

    @Query("""
                select p from Property p
                join fetch User u
                where u.id = :userId
            """)
    Optional<List<Property>> findPropertyByUser(Long userId);


    @Query("""
                select p from Property p
                where p.propertyType = :propertyType
            """)
    Optional<List<Property>> findByPropertyType(String propertyType);

    @Query("""
                select p from Property p
                where p.constructionYear >= :yearFrom and p.constructionYear <= :yearTo
            """)
    Optional<List<Property>> findByConstructionYearRange(int yearFrom, int yearTo);
}
