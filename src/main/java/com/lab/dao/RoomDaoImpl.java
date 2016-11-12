package com.lab.dao;

import java.util.List;

import com.lab.entity.ReservationEntity;
import com.lab.entity.RoomEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RoomDaoImpl implements RoomDao
{
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addRoom(RoomEntity roomEntity) {
        this.sessionFactory.getCurrentSession().save(roomEntity);
    }

    @Transactional
    public RoomEntity getRoomById(Integer roomId) {
        return (RoomEntity) this.sessionFactory.getCurrentSession().get(RoomEntity.class, roomId);
    }

    @SuppressWarnings("unchecked")
    @Transactional
    public List<RoomEntity> getAllRooms() {
        return this.sessionFactory.getCurrentSession().createQuery("from RoomEntity").list();
    }

    @Transactional
    public void deleteRoom(Integer roomId) {
        RoomEntity roomEntity = (RoomEntity) sessionFactory.getCurrentSession().load(
                RoomEntity.class, roomId);
        if (null != roomEntity) {
            this.sessionFactory.getCurrentSession().delete(roomEntity);
        }
    }
}