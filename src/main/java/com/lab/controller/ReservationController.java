package com.lab.controller;

import com.lab.dao.ReservationDao;
import com.lab.dao.RoomDao;
import com.lab.entity.ReservationEntity;
import com.lab.entity.RoomEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController
{
    @Autowired
    private ReservationDao reservationDao;

    @Autowired
    private RoomDao roomDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listReservations(ModelMap map)
    {
        map.addAttribute("reservation", new ReservationEntity());
        map.addAttribute("reservationList", reservationDao.getAllReservations());
        map.addAttribute("roomList", roomDao.getAllRooms());

        return "reservationList";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addReservation(
            @ModelAttribute(value="reservation") ReservationEntity reservation,
            BindingResult result,
            @RequestParam("room") Integer roomId
    ) {
        RoomEntity room = roomDao.getRoomById(roomId);
        reservation.setRoom(room);
        reservationDao.addReservation(reservation);
        return "redirect:/";
    }

    @RequestMapping("/delete/{reservationId}")
    public String deleteReservation(@PathVariable("reservationId") Integer reservationId)
    {
        reservationDao.deleteReservation(reservationId);
        return "redirect:/";
    }

    public void setReservationDao(ReservationDao reservationDao)
    {
        this.reservationDao = reservationDao;
    }

    public void setRoomDao(RoomDao roomDao)
    {
        this.roomDao= roomDao;
    }
}