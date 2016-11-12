package com.lab.dao;

import java.util.List;

import com.lab.entity.ReservationEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ReservationDaoImpl implements ReservationDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addReservation(ReservationEntity reservation) {
        this.sessionFactory.getCurrentSession().save(reservation);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<ReservationEntity> getAllReservations() {
        return this.sessionFactory.getCurrentSession().createQuery("from ReservationEntity").list();
    }

    @Transactional
    public void deleteReservation(Integer reservationId) {
        ReservationEntity reservation = (ReservationEntity) sessionFactory.getCurrentSession().load(
                ReservationEntity.class, reservationId);
        if (null != reservation) {
            this.sessionFactory.getCurrentSession().delete(reservation);
        }
    }
}