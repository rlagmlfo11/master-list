package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.QudtlsMasterRepository;
import com.example.demo.entity.QudtlsMaster;

@Service
public class QudtlsMasterService {

	@Autowired
	private QudtlsMasterRepository qudtlsMasterRepository;

	public List<QudtlsMaster> getAllQudtls() {
		return qudtlsMasterRepository.findAll();
	}

	public void updateQudtls(QudtlsMaster qudtlsMaster) {
		qudtlsMasterRepository.save(qudtlsMaster);
	}

	public QudtlsMaster getCustomerById(Long id) {
		QudtlsMaster getCustomerById = qudtlsMasterRepository.findById(id).get();
		return getCustomerById;
	}

}
