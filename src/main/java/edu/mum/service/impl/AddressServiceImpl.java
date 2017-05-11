package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.GenericDao;
import edu.mum.aspect.annotation.Logging;
import edu.mum.dao.AddressDao;
import edu.mum.domain.Address;

@Service
@Transactional 
public class AddressServiceImpl implements edu.mum.service.AddressService {
	
	
 	@Autowired
	private AddressDao addressDao;

 	@Logging
    public void save( Address address) {  		
		addressDao.save(address);
	}
	
	@Logging
    public void update( Address address) {  		
		addressDao.update(address);
	}
	
	
	public List<Address> findAll() {
		return (List<Address>)addressDao.findAll();
	}

 	public Address findOne(Long id) {
		return addressDao.findOne(id);
	}	
 
}
