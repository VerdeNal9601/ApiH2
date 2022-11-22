package com.test.h2db.h2testbd.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Booking")
public class BookingDto implements Serializable {

    private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_Booking")
        private Long idBooking;
        private LocalDate disponible;
        private LocalDate noDisponible;

        @ManyToOne
        @JoinColumn(name = "Id.user",insertable = false,updatable = false)
        private UserDto userDto;

    public BookingDto() {
    }

    public BookingDto(Long idBooking, LocalDate disponible, LocalDate noDisponible) {
        this.idBooking = idBooking;
        this.disponible = disponible;
        this.noDisponible = noDisponible;
    }

    public Long getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Long idBooking) {
        this.idBooking = idBooking;
    }

    public LocalDate getDisponible() {
        return disponible;
    }

    public void setDisponible(LocalDate disponible) {
        this.disponible = disponible;
    }

    public LocalDate getNoDisponible() {
        return noDisponible;
    }

    public void setNoDisponible(LocalDate noDisponible) {
        this.noDisponible = noDisponible;
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "idBooking=" + idBooking +
                ", disponible=" + disponible +
                ", noDisponible=" + noDisponible +
                '}';
    }
}

