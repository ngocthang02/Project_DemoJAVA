package com.poly.assignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.assignment.entities.Customer;

@Service
public interface CustomerService {

	<S extends Customer> List<S> findAll(Example<S> example, Sort sort);

	<S extends Customer> List<S> findAll(Example<S> example);

	Customer getById(Integer id);

	void deleteAll();

	void deleteAll(Iterable<? extends Customer> entities);

	Customer getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Customer entity);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteById(Integer id);

	long count();

	void deleteAllInBatch(Iterable<Customer> entities);

	<S extends Customer> boolean exists(Example<S> example);

	<S extends Customer> long count(Example<S> example);

	void deleteInBatch(Iterable<Customer> entities);

	<S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Integer id);

	<S extends Customer> S saveAndFlush(S entity);

	void flush();

	<S extends Customer> List<S> saveAll(Iterable<S> entities);

	Optional<Customer> findById(Integer id);

	List<Customer> findAllById(Iterable<Integer> ids);

	List<Customer> findAll(Sort sort);

	List<Customer> findAll();

	Page<Customer> findAll(Pageable pageable);

	<S extends Customer> Optional<S> findOne(Example<S> example);

	<S extends Customer> S save(S entity);

	List<Customer> findByEmailContaining(String email);

	List<Customer> findByNameContaining(String name);

}
