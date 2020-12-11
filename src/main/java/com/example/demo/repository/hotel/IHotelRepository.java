package com.example.demo.repository.hotel;

import com.example.demo.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IHotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findHotelsByNameContaining(String name);
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE hotel b set  status=1 where b.bookId = :id", nativeQuery = true)
//    void remove(@Param("id") Long id);
    Hotel findHotelById(Long id);
}
