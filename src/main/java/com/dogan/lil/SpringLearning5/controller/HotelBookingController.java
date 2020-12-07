package com.dogan.lil.SpringLearning5.controller;

import com.dogan.lil.SpringLearning5.model.HotelBooking;
import com.dogan.lil.SpringLearning5.repository.HotelBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bookings")
public class HotelBookingController {


private HotelBookingRepository hotelBookingRepository;

@Autowired
    public HotelBookingController(HotelBookingRepository hotelBookingRepository){
        this.hotelBookingRepository =hotelBookingRepository;
    }


    @RequestMapping(value = "/all" , method = RequestMethod.GET)
    public List<HotelBooking> getAll(){
        return (List<HotelBooking>) hotelBookingRepository.findAll();
    }


    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price){
       return hotelBookingRepository.findByPricePerNightLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking){
       hotelBookingRepository.save(hotelBooking);
       return (List<HotelBooking>) hotelBookingRepository.findAll();

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<HotelBooking> remove(@PathVariable long id){
    hotelBookingRepository.deleteById(id);
    return (List<HotelBooking>) hotelBookingRepository.findAll();

    }


}
