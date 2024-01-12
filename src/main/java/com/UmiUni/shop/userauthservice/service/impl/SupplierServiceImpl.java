package com.UmiUni.shop.userauthservice.service.impl;

import com.UmiUni.shop.userauthservice.entity.Supplier;
import com.UmiUni.shop.userauthservice.repository.SupplierRepository;
import com.UmiUni.shop.userauthservice.service.SupplierService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@Log4j2
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public Supplier createSupplier(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    public Supplier getSupplier(Long id) {
        return supplierRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Supplier not found with id: " + id));
    }

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier updateSupplier(Long id, Supplier supplierDetails) {
        Supplier supplier = getSupplier(id);
        supplier.setSupplierName(supplierDetails.getSupplierName());
        supplier.setContactInfo(supplierDetails.getContactInfo());
        supplier.setPaypalEmail(supplier.getPaypalEmail());
//        supplier.setPaypalAccessToken(supplier.getPaypalAccessToken());
        // other updates as needed
        return supplierRepository.save(supplier);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public Supplier getSupplierByName(String username) {
        return supplierRepository.findBySupplierName(username)
                .orElseThrow();
    }

}
