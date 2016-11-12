package com.lab.dao;

import com.lab.entity.ReservationEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReservationDao
{
    @Transactional
    void addReservation(ReservationEntity reservation);
    @Transactional
    List<ReservationEntity> getAllReservations();
    @Transactional
    void deleteReservation(Integer reservationId);
}