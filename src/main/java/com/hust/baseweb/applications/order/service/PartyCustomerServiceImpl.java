package com.hust.baseweb.applications.order.service;

import com.hust.baseweb.applications.customer.entity.PartyCustomer;
import com.hust.baseweb.applications.order.repo.PartyCustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PartyCustomerServiceImpl implements PartyCustomerService {
    private PartyCustomerRepo partyCustomerRepo;

    @Override
    public List<PartyCustomer> getListPartyCustomers() {

        return partyCustomerRepo.findAll();
    }

}
