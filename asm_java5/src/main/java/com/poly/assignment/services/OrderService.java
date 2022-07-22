package com.poly.assignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.assignment.entities.Customer;
import com.poly.assignment.entities.Order;

@Service
public interface OrderService {

	<S extends Order> List<S> findAll(Example<S> example, Sort sort);

	<S extends Order> List<S> findAll(Example<S> example);

	Order getById(Integer id);

	void deleteAll();

	void deleteAll(Iterable<? extends Order> entities);

	Order getOne(Integer id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(Order entity);

	void deleteAllByIdInBatch(Iterable<Integer> ids);

	void deleteById(Integer id);

	long count();

	void deleteAllInBatch(Iterable<Order> entities);

	<S extends Order> boolean exists(Example<S> example);

	<S extends Order> long count(Example<S> example);

	void deleteInBatch(Iterable<Order> entities);

	<S extends Order> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Order> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Integer id);

	<S extends Order> S saveAndFlush(S entity);

	void flush();

	<S extends Order> List<S> saveAll(Iterable<S> entities);

	Optional<Order> findById(Integer id);

	List<Order> findAllById(Iterable<Integer> ids);

	List<Order> findAll(Sort sort);

	List<Order> findAll();

	Page<Order> findAll(Pageable pageable);

	<S extends Order> Optional<S> findOne(Example<S> example);

	<S extends Order> S save(S entity);

	List<Order> findByCutomer(Customer customer);

}
