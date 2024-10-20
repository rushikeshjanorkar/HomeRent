package com.HomeRent.rentApplication.monthalyBill;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class MonthalyBill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;

    private  int roomId;

    private  Date billDate;

    private  long previousReading;

    private  long currentReading;

    private  long totalReading;

    private long totalBill;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public long getPreviousReading() {
        return previousReading;
    }

    public void setPreviousReading(long previousReading) {
        this.previousReading = previousReading;
    }

    public long getCurrentReading() {
        return currentReading;
    }

    public void setCurrentReading(long currentReading) {
        this.currentReading = currentReading;
    }

    public long getTotalReading() {
        return totalReading;
    }

    public void setTotalReading(long totalReading) {
        this.totalReading = totalReading;
    }

    public long getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(long totalBill) {
        this.totalBill = totalBill;
    }
}
