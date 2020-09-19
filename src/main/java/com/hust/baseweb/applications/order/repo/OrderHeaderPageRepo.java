package com.hust.baseweb.applications.order.repo;

import com.hust.baseweb.applications.order.entity.OrderHeader;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface OrderHeaderPageRepo extends PagingAndSortingRepository<OrderHeader, UUID> {
    //Page<OrderHeader> findAll(Pageable page);
    Page<OrderHeader> findAllByOrderByOrderDateDesc(Pageable page);
}
