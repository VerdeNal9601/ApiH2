package com.test.h2db.h2testbd.repository;

import com.test.h2db.h2testbd.model.BookingDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingRepositoryImpl implements BookingRepositoryDao {

    @Autowired
    private BookingCrudRepository bookingCrudRepository;

    @Override
    public List<BookingDto> getAllBookings() {
        List<BookingDto> bookingsFound = new ArrayList<>();
        bookingCrudRepository.findAll().forEach(booking -> bookingsFound.add(booking));
        return bookingsFound;
    }

    @Override
    public BookingDto findBookingById(Long idBooking) {
        return bookingCrudRepository.findById(idBooking).get();
    }

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        return bookingCrudRepository.save(bookingDto);
    }

    @Override
    public boolean updateBooking(Long idBooking, BookingDto bookingDto) {
        BookingDto bookingFound = findBookingById(idBooking);
        if (bookingFound != null){
            bookingFound.setDisponible(bookingDto.getDisponible());
            bookingFound.setNoDisponible(bookingDto.getNoDisponible());
            bookingCrudRepository.save(bookingFound);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteBooking(Long idBooking) {
        BookingDto bookingFound = findBookingById(idBooking);
        if (bookingFound != null){
            bookingCrudRepository.delete(bookingFound);
            return true;
        }else{
            return false;
        }
    }
}
