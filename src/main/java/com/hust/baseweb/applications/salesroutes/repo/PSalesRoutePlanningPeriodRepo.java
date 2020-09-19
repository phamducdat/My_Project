package com.hust.baseweb.applications.salesroutes.repo;

import com.hust.baseweb.applications.salesroutes.entity.SalesRoutePlanningPeriod;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface PSalesRoutePlanningPeriodRepo extends
        PagingAndSortingRepository<SalesRoutePlanningPeriod, UUID> {
    SalesRoutePlanningPeriod findBySalesRoutePlanningPeriodId(UUID salesRoutePlanningPeriodId);
}
