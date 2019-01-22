package com.training.warehouse.shipping.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.warehouse.shipping.domain.Shipping;

public interface ShippingRepository extends JpaRepository<Shipping, Long>{

}
