package com.HomeRent.rentApplication.monthalyBill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monthly-bills")
public class MonthlyBillController {

    @Autowired
    private MonthlyBillService service;

    @GetMapping
    public List<MonthalyBill> getAllBills() {
        return service.getAllBills();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MonthalyBill> getBillById(@PathVariable int id) {
        return service.getBillById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MonthalyBill createBill(@RequestBody MonthalyBill bill) {
        return service.createBill(bill);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MonthalyBill> updateBill(@PathVariable int id, @RequestBody MonthalyBill bill) {
        return ResponseEntity.ok(service.updateBill(id, bill));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBill(@PathVariable int id) {
        service.deleteBill(id);
        return ResponseEntity.noContent().build();
    }
}
