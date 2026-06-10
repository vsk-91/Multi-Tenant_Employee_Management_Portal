package com.vsk.mtep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vsk.mtep.entity.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
