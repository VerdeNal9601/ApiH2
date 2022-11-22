package com.test.h2db.h2testbd.controller;

import com.test.h2db.h2testbd.model.BookingDto;
import com.test.h2db.h2testbd.model.UserDto;
import com.test.h2db.h2testbd.service.BookingService;
import com.test.h2db.h2testbd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }

    @GetMapping
    public ResponseEntity<List<BookingDto>> getAllBooking(){
        return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> findBookingById(@PathVariable("id") Long Booking){
        return new ResponseEntity<>(bookingService.findBookingById(Booking), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto){
        return new ResponseEntity<>(bookingService.createBooking(bookingDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBooking(@PathVariable("id") Long idBooking, @RequestBody BookingDto bookingDto){
        boolean isUpdated = bookingService.updateBooking(idBooking, bookingDto);
        if (isUpdated){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBooking(@PathVariable("id") Long idBooking){
        boolean isDelete = bookingService.deleteBooking(idBooking);
        if (isDelete){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
