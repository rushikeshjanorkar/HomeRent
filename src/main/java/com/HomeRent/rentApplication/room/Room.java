package com.HomeRent.rentApplication.room;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roomNo;
    private String roomUserName;
    private String roomAddress;

   @Lob
    private byte[] panCard;  // Store the PDF data of the PAN card

    @Lob
    @Column(name = "aadharCardFile")
    private byte[] aadharCardFile; // Store the PDF data of the Aadhaar card

    private long mobileNo;

    private String email;

    // Getters and Setters (Lombok generates these automatically)
}
