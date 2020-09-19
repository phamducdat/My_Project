package com.hust.baseweb.applications.salesroutes.service;

import com.hust.baseweb.applications.salesroutes.entity.SalesRouteConfig;
import com.hust.baseweb.applications.salesroutes.repo.PSalesRouteConfigRepo;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SalesRouteConfigServiceImpl implements SalesRouteConfigService {
    private PSalesRouteConfigRepo pSalesRouteConfigRepo;

    @Override
    public SalesRouteConfig save(String days, int repeatWeek) {
        SalesRouteConfig salesRouteConfig = new SalesRouteConfig();
        salesRouteConfig.setDays(days);
        salesRouteConfig.setRepeatWeek(repeatWeek);

        salesRouteConfig = pSalesRouteConfigRepo.save(salesRouteConfig);

        return salesRouteConfig;
    }

}
