package com.UmiUni.shop.userauthservice.service;

import com.UmiUni.shop.userauthservice.entity.Supplier;

import java.util.List;

public interface SupplierService {

    Supplier createSupplier(Supplier supplier);

    Supplier getSupplier(Long id);

    List<Supplier> getAllSuppliers();

    Supplier updateSupplier(Long id, Supplier supplierDetails);

    void deleteSupplier(Long id);

    Supplier getSupplierByName(String username);
}
