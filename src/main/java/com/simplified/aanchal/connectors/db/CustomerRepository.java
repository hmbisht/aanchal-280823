package com.simplified.aanchal.connectors.db;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * JpaRepository – which extends PagingAndSortingRepository and, in turn, the CrudRepository.
 */
@Component
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  Customer findById(int id);

  @Override
  List<Customer> findAll();

  @Override
  Customer save(Customer customer);

  void deleteById(int id);

}
