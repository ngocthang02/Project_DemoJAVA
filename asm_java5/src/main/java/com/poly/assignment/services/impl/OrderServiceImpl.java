package com.poly.assignment.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.poly.assignment.entities.Customer;
import com.poly.assignment.entities.Order;
import com.poly.assignment.repositories.OrdersRepository;
import com.poly.assignment.services.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
private OrdersRepository ordersRepository;
@Autowired
public OrderServiceImpl(OrdersRepository ordersRepository) {

	this.ordersRepository = ordersRepository;
}

@Override
public List<Order> findByCutomer(Customer customer) {
	return ordersRepository.findByCutomer(customer);
}

@Override
public <S extends Order> S save(S entity) {
	entity.setOrderDate(new Date());
	return ordersRepository.save(entity);
}

@Override
public <S extends Order> Optional<S> findOne(Example<S> example) {
	return ordersRepository.findOne(example);
}

@Override
public Page<Order> findAll(Pageable pageable) {
	return ordersRepository.findAll(pageable);
}

@Override
public List<Order> findAll() {
	return ordersRepository.findAll();
}

@Override
public List<Order> findAll(Sort sort) {
	return ordersRepository.findAll(sort);
}

@Override
public List<Order> findAllById(Iterable<Integer> ids) {
	return ordersRepository.findAllById(ids);
}

@Override
public Optional<Order> findById(Integer id) {
	return ordersRepository.findById(id);
}

@Override
public <S extends Order> List<S> saveAll(Iterable<S> entities) {
	return ordersRepository.saveAll(entities);
}

@Override
public void flush() {
	ordersRepository.flush();
}

@Override
public <S extends Order> S saveAndFlush(S entity) {
	return ordersRepository.saveAndFlush(entity);
}

@Override
public boolean existsById(Integer id) {
	return ordersRepository.existsById(id);
}

@Override
public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
	return ordersRepository.saveAllAndFlush(entities);
}

@Override
public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
	return ordersRepository.findAll(example, pageable);
}

@Override
public void deleteInBatch(Iterable<Order> entities) {
	ordersRepository.deleteInBatch(entities);
}

@Override
public <S extends Order> long count(Example<S> example) {
	return ordersRepository.count(example);
}

@Override
public <S extends Order> boolean exists(Example<S> example) {
	return ordersRepository.exists(example);
}

@Override
public void deleteAllInBatch(Iterable<Order> entities) {
	ordersRepository.deleteAllInBatch(entities);
}

@Override
public long count() {
	return ordersRepository.count();
}

@Override
public void deleteById(Integer id) {
	ordersRepository.deleteById(id);
}

@Override
public void deleteAllByIdInBatch(Iterable<Integer> ids) {
	ordersRepository.deleteAllByIdInBatch(ids);
}

@Override
public void delete(Order entity) {
	ordersRepository.delete(entity);
}

@Override
public void deleteAllById(Iterable<? extends Integer> ids) {
	ordersRepository.deleteAllById(ids);
}

@Override
public void deleteAllInBatch() {
	ordersRepository.deleteAllInBatch();
}

@Override
public Order getOne(Integer id) {
	return ordersRepository.getOne(id);
}

@Override
public void deleteAll(Iterable<? extends Order> entities) {
	ordersRepository.deleteAll(entities);
}

@Override
public void deleteAll() {
	ordersRepository.deleteAll();
}

@Override
public Order getById(Integer id) {
	return ordersRepository.getById(id);
}

@Override
public <S extends Order> List<S> findAll(Example<S> example) {
	return ordersRepository.findAll(example);
}

@Override
public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
	return ordersRepository.findAll(example, sort);
}

}
