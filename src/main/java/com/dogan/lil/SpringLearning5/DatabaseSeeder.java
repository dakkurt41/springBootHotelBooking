package com.dogan.lil.SpringLearning5;

import com.dogan.lil.SpringLearning5.model.HotelBooking;
import com.dogan.lil.SpringLearning5.repository.HotelBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner{
 private HotelBookingRepository hotelBookingRepository;

    @Autowired
    public DatabaseSeeder(HotelBookingRepository hotelBookingRepository) {
        this.hotelBookingRepository = hotelBookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        List<HotelBooking> booking = new ArrayList<>();

        booking.add(new HotelBooking("Marriot", 200.35, 3));
        booking.add(new HotelBooking("Mirage", 145.67, 5));
        booking.add(new HotelBooking("Bellagio", 45.12, 10));
        hotelBookingRepository.saveAll(booking);


    }
}
