package com.lab.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="room")
public class RoomEntity
{
    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "room")
    private Set<ReservationEntity> reservations;

    @Column(name="number")
    private Integer number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservation(Set<ReservationEntity> reservations) {
        this.reservations = reservations;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer roomNumber) {
        this.number = number;
    }

    public void addReservation(ReservationEntity reservation)
    {
        reservation.setRoom(this);
        this.reservations.add(reservation);
    }
}
