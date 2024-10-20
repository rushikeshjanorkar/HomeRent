package com.HomeRent.rentApplication.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(int roomNo) {
        return roomRepository.findById(roomNo).orElse(null);
    }

    public void deleteRoom(int roomNo) {
        roomRepository.deleteById(roomNo);
    }
}
