package com.lab.dao;

import com.lab.entity.ReservationEntity;
import com.lab.entity.RoomEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoomDao
{
    @Transactional
    void addRoom(RoomEntity roomEntity);
    @Transactional
    RoomEntity getRoomById(Integer roomId);
    @Transactional
    List<RoomEntity> getAllRooms();
    @Transactional
    void deleteRoom(Integer roomId);
}