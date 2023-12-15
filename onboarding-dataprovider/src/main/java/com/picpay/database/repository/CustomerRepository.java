package com.picpay.database.repository;

import com.picpay.database.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {

    Optional<CustomerEntity> findCutomerByCpf(String cpf);
}
