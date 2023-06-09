package za.ac.cput.service.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Address;
import za.ac.cput.repository.AddressRepository;
import za.ac.cput.service.AddressService;

import java.util.Set;

/*
AddressServiceImpl.java
Author: Tamryn Lisa Lewin (219211981)
Date: 09 June 2023
Last updated: 10 June 2023
 */

@Service
public class AddressServiceImpl implements AddressService {
    private static AddressServiceImpl service = null;
    private static AddressRepository repository = null;
    private AddressServiceImpl() {
        repository = AddressRepository.getRepository();
    }

    public static AddressServiceImpl getService() {
        if (service == null) {
            service = new AddressServiceImpl();
        }
        return service;
    }

    @Override
    public Address create(Address address) {
        Address createdAddress = repository.create(address);
        return createdAddress;
    }

    @Override
    public Address read(String addressId) {
        Address readAddress = repository.read(addressId);
        return readAddress;
    }

    @Override
    public Address update(Address address) {
        Address updatedAddress = repository.update(address);
        return updatedAddress;
    }

    @Override
    public Set<Address> getAll() {
        return repository.getAll();
    }
}
