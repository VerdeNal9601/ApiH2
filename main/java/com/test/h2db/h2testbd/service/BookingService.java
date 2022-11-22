package com.test.h2db.h2testbd.service;

import com.test.h2db.h2testbd.model.BookingDto;

import java.util.List;

public interface BookingService {
    List<BookingDto> getAllBookings();
    BookingDto findBookingById(Long idBooking);
    BookingDto createBooking(BookingDto bookingDto);
    boolean updateBooking(Long idBooking, BookingDto bookingDto);
    boolean deleteBooking(Long idBooking);

}
