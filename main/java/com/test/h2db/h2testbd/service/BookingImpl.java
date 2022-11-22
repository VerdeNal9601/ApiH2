package com.test.h2db.h2testbd.service;

import com.test.h2db.h2testbd.model.BookingDto;
import com.test.h2db.h2testbd.model.UserDto;
import com.test.h2db.h2testbd.repository.BookingRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookingImpl implements BookingService{

    @Autowired
    private BookingRepositoryDao bookingRepositoryDao;

    @Override
    public List<BookingDto> getAllBookings() {
        return bookingRepositoryDao.getAllBookings();
    }

    @Override
    public BookingDto findBookingById(Long idBooking) {
        return bookingRepositoryDao.findBookingById(idBooking);
    }

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {
        return bookingRepositoryDao.createBooking(bookingDto);
    }

    @Override
    public boolean updateBooking(Long idBooking, BookingDto bookingDto) {
        return bookingRepositoryDao.updateBooking(idBooking, bookingDto);
    }

    @Override
    public boolean deleteBooking(Long idBooking) {
        return bookingRepositoryDao.deleteBooking(idBooking);
    }
}
