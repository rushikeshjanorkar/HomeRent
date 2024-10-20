package com.HomeRent.rentApplication.monthalyBill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyBillRepository extends JpaRepository<MonthalyBill, Integer> {
}
