package com.poly.assignment.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.poly.assignment.entities.Vegetable;
import com.poly.assignment.repositories.VegetableRepository;
import com.poly.assignment.services.VegetableService;

@Service
public class VegetableServiecImpl implements VegetableService {
	@Autowired
	VegetableRepository productsRepository;

	public VegetableServiecImpl(VegetableRepository productsRepository) {
		super();
		this.productsRepository = productsRepository;
	}
	//final private List<Vegetable> vegetables = VegetableUt
	
	@Override
	public Vegetable updateQuantity(Long productId, int quantity) {
		Optional<Vegetable> jOptional = productsRepository.findById(productId);
		Vegetable junkFood = jOptional.get();
		if (jOptional.isPresent()) {
			junkFood.setQuantity(quantity);
			junkFood.setQuantity(quantity);
			return productsRepository.save(junkFood);
		}
		return null;
	}
	public Vegetable getOneVegetable(Long productId) {
		return productsRepository.getById(productId);
	}
	
	@Override
	public List<Vegetable> findByNameContaining(String name) {
		return productsRepository.findByNameContaining(name);
	}

	
	@Override
	public Page<Vegetable> findPage(int pageNumber){
		Pageable pageable = PageRequest.of(pageNumber, 6);
		return productsRepository.findAll(pageable);
	}
	@Override
	public Page<Vegetable> findAll(Pageable pageable) {
		return productsRepository.findAll(pageable);
	}

	@Override
	public Page<Vegetable> findByNameContaining(String name, Pageable pageable) {
		return productsRepository.findByNameContaining(name, pageable);
	}
	@Override
	public <S extends Vegetable> S save(S entity) {
		entity.setEnteredDate(new Date());
		return productsRepository.save(entity);
	}

	
	@Override
	public <S extends Vegetable> Optional<S> findOne(Example<S> example) {
		return productsRepository.findOne(example);
	}

	
	
	
	
	 
	@Override
	public List<Vegetable> findAll() {
		return productsRepository.findAll();
	}

	
	@Override
	public List<Vegetable> findAll(Sort sort) {
		return productsRepository.findAll(sort);
	}

	
	@Override
	public List<Vegetable> findAllById(Iterable<Long> ids) {
		return productsRepository.findAllById(ids);
	}

	
	
	@Override
	public Vegetable findByIda(Long id) {
		Optional<Vegetable> idP = productsRepository.findById(id);
		Vegetable vegetable = idP.get();
		
		return vegetable;
	}

	
	@Override
	public <S extends Vegetable> List<S> saveAll(Iterable<S> entities) {
		return productsRepository.saveAll(entities);
	}

	
	@Override
	public void flush() {
		productsRepository.flush();
	}

	
	@Override
	public <S extends Vegetable> S saveAndFlush(S entity) {
		return productsRepository.saveAndFlush(entity);
	}


	@Override
	public boolean existsById(Long id) {
		return productsRepository.existsById(id);
	}


	@Override
	public <S extends Vegetable> List<S> saveAllAndFlush(Iterable<S> entities) {
		return productsRepository.saveAllAndFlush(entities);
	}

	
	@Override
	public <S extends Vegetable> Page<S> findAll(Example<S> example, Pageable pageable) {
		return productsRepository.findAll(example, pageable);
	}

	
	@Override
	public void deleteInBatch(Iterable<Vegetable> entities) {
		productsRepository.deleteInBatch(entities);
	}


	@Override
	public <S extends Vegetable> long count(Example<S> example) {
		return productsRepository.count(example);
	}

	
	@Override
	public <S extends Vegetable> boolean exists(Example<S> example) {
		return productsRepository.exists(example);
	}

	
	@Override
	public void deleteAllInBatch(Iterable<Vegetable> entities) {
		productsRepository.deleteAllInBatch(entities);
	}

	
	@Override
	public long count() {
		return productsRepository.count();
	}

	
	@Override
	public void deleteById(Long id) {
		productsRepository.deleteById(id);
	}

	
	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		productsRepository.deleteAllByIdInBatch(ids);
	}

	
	@Override
	public void delete(Vegetable entity) {
		productsRepository.delete(entity);
	}


	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		productsRepository.deleteAllById(ids);
	}


	@Override
	public void deleteAllInBatch() {
		productsRepository.deleteAllInBatch();
	}

	
	@Override
	public Vegetable getOne(Long id) {
		return productsRepository.getOne(id);
	}

	
	@Override
	public void deleteAll(Iterable<? extends Vegetable> entities) {
		productsRepository.deleteAll(entities);
	}


	@Override
	public void deleteAll() {
		productsRepository.deleteAll();
	}

	@Override
	public Vegetable getById(Long id) {
		return productsRepository.getById(id);
	}

	
	@Override
	public <S extends Vegetable> List<S> findAll(Example<S> example) {
		return productsRepository.findAll(example);
	}

	
	@Override
	public <S extends Vegetable> List<S> findAll(Example<S> example, Sort sort) {
		return productsRepository.findAll(example, sort);
	}

	
	@Override
	public Optional<Vegetable> findById(Long id) {
		// TODO Auto-generated method stub
		return productsRepository.findById(id);
	}

}
