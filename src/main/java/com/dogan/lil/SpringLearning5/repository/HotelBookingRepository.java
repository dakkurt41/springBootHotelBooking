package com.dogan.lil.SpringLearning5.repository;

import com.dogan.lil.SpringLearning5.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelBookingRepository extends CrudRepository<HotelBooking, Long> {

    List<HotelBooking> findByPricePerNightLessThan(double price);
}

