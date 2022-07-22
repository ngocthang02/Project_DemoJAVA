package com.poly.assignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.assignment.entities.Vegetable;
@Service
public interface VegetableService {

	Optional<Vegetable> findById(Long id);

	<S extends Vegetable> List<S> findAll(Example<S> example, Sort sort);

	<S extends Vegetable> List<S> findAll(Example<S> example);

	Vegetable getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Vegetable> entities);

	Vegetable getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	void delete(Vegetable entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	long count();

	void deleteAllInBatch(Iterable<Vegetable> entities);

	<S extends Vegetable> boolean exists(Example<S> example);

	<S extends Vegetable> long count(Example<S> example);

	void deleteInBatch(Iterable<Vegetable> entities);

	<S extends Vegetable> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Vegetable> List<S> saveAllAndFlush(Iterable<S> entities);

	boolean existsById(Long id);

	<S extends Vegetable> S saveAndFlush(S entity);

	void flush();

	<S extends Vegetable> List<S> saveAll(Iterable<S> entities);

	Vegetable findByIda(Long id);

	List<Vegetable> findAllById(Iterable<Long> ids);

	List<Vegetable> findAll(Sort sort);

	

	<S extends Vegetable> Optional<S> findOne(Example<S> example);

	<S extends Vegetable> S save(S entity);

	List<Vegetable> findByNameContaining(String name);

	Vegetable updateQuantity(Long productId, int quantity);

	List<Vegetable> findAll();

	Page<Vegetable> findByNameContaining(String name, Pageable pageable);

	Page<Vegetable> findAll(Pageable pageable);

	Page<Vegetable> findPage(int pageNumber);



	 

	

}
