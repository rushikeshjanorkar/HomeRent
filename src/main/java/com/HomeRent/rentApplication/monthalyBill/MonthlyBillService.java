package com.HomeRent.rentApplication.monthalyBill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonthlyBillService {

    @Autowired
    private MonthlyBillRepository repository;

    public List<MonthalyBill> getAllBills() {
        return repository.findAll();
    }

    public Optional<MonthalyBill> getBillById(int id) {
        return repository.findById(id);
    }

    public MonthalyBill createBill(MonthalyBill bill) {
        return repository.save(bill);
    }

    public MonthalyBill updateBill(int id, MonthalyBill updatedBill) {
        updatedBill.setId(id);
        return repository.save(updatedBill);
    }

    public void deleteBill(int id) {
        repository.deleteById(id);
    }
}
