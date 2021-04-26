package com.fulfillmentBridge.FbCustomerService.dao;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.fulfillmentBridge.FbCustomerService.entity.Customer;


@RepositoryRestResource
public interface CustomerRepo extends JpaRepositoryImplementation<Customer, Long> {

}
