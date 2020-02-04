package com.formation.service.common;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<T> implements IServiceActions<T> {
	
public abstract JpaRepository<T, Long> getRepo();
	
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return getRepo().findAll();
	}

	@Override
	public T findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T save(T t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
