package com.hust.baseweb.applications.salesroutes.service;

import com.hust.baseweb.applications.customer.entity.PartyCustomer;
import com.hust.baseweb.applications.order.repo.PartyCustomerRepo;
import com.hust.baseweb.applications.order.service.PartyCustomerService;
import com.hust.baseweb.applications.salesroutes.entity.SalesmanCheckinHistory;
import com.hust.baseweb.applications.salesroutes.repo.SalesmanCheckinHistoryRepo;
import com.hust.baseweb.entity.UserLogin;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SalesmanCheckinHistoryServiceImpl implements
        SalesmanCheckinHistoryService {

    private SalesmanCheckinHistoryRepo salesmanCheckinHistoryRepo;
    private PartyCustomerService partyCustomerService;
    private PartyCustomerRepo partyCustomerRepo;

    @Override
    public SalesmanCheckinHistory save(UserLogin userLogin, UUID partyCustomerId, String checkinAction, String location) {
        PartyCustomer partyCustomer = partyCustomerRepo.findByPartyId(partyCustomerId);

        SalesmanCheckinHistory sch = new SalesmanCheckinHistory();
        //sch.setUserLogin(userLogin);
        sch.setUserLoginId(userLogin.getUserLoginId());
        sch.setPartyCustomer(partyCustomer);
        sch.setTimePoint(new Date());
        sch.setCheckinAction(checkinAction);
        sch.setLocation(location);
        sch = salesmanCheckinHistoryRepo.save(sch);
        return sch;
    }

    @Override
    public Page<SalesmanCheckinHistory> findAll(Pageable page) {
        return salesmanCheckinHistoryRepo.findAll(page);
    }

}
