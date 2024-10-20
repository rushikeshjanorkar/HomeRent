package com.HomeRent.rentApplication.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<Room> createRoom(
            @RequestParam String roomUserName,
            @RequestParam String roomAddress,
            @RequestParam long mobileNo,
            @RequestParam MultipartFile panCardFile,
            @RequestParam String email,
            @RequestParam MultipartFile aadharCardFile) throws IOException {

        Room room = new Room();
        room.setRoomUserName(roomUserName);
        room.setRoomAddress(roomAddress);
        room.setMobileNo(mobileNo);
        room.setEmail(email);

        // Convert files to byte array
        room.setPanCard(panCardFile.getBytes());
        room.setAadharCardFile(aadharCardFile.getBytes());

        Room createdRoom = roomService.createRoom(room);
        return ResponseEntity.ok(createdRoom);
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{roomNo}")
    public ResponseEntity<Room> getRoomById(@PathVariable int roomNo) {
        Room room = roomService.getRoomById(roomNo);
        return room != null ? ResponseEntity.ok(room) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{roomNo}")
    public ResponseEntity<Void> deleteRoom(@PathVariable int roomNo) {
        roomService.deleteRoom(roomNo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pdf/{roomNo}/{type}")
    public ResponseEntity<byte[]> getPdf(@PathVariable int roomNo, @PathVariable String type) {
        Room room = roomService.getRoomById(roomNo);
        if (room == null) {
            return ResponseEntity.notFound().build();
        }

        byte[] pdfData;
        if ("pan".equals(type)) {
            pdfData = room.getPanCard();
        } else if ("aadhar".equals(type)) {
            pdfData = room.getAadharCardFile();
        } else {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"" + type + ".pdf\"")
                .body(pdfData);
    }

}
