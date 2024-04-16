package com.example.demo.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.QudtlsMaster;

@Repository
public interface QudtlsMasterRepository extends JpaRepository<QudtlsMaster, Long> {

}
