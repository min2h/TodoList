package com.example.demo.service;

import java.lang.StackWalker.Option;
import java.util.List;

import org.glassfish.jaxb.core.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRepository;
import com.google.common.base.Optional;

import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그 어노테이션 (info, debug, warn, error)
@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;

	/*
	public String testService() {
		//TodoEntity 생성
		TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
		
		//TodoEntity 저장
		repository.save(entity);
		
		//TodoEntity 검색
		TodoEntity savedEntity = repository.findById(entity.getId()).get();
		
		return savedEntity.getTitle();
	}
	*/
	
	// 생성 service
	public List<TodoEntity> create(final TodoEntity entity){
		//Validations 검증
		validate(entity);
		
		repository.save(entity);
		
		log.info("Entity ID : {} is saved.", entity.getId());
		
		return repository.findByUserId(entity.getUserId());

	}
	
	public List<TodoEntity> retrieve(final String userId){
		return repository.findByUserId(userId);
	}
	
	private void validate(final TodoEntity entity) {
		if(entity == null) {
			log.warn("Entity cannot be null.");
			throw new RuntimeException("Entity cannot be null.");
		}
		
		
		
		
		if(entity.getUserId() == null) {
			log.warn("Unknown user.");
			throw new RuntimeException("Unknown user.");
		}
	}
	
	public List<TodoEntity> update(final TodoEntity entity){
		//1. 검증
		validate(entity);
		
		//2. 넘겨받은 엔티티 가져옴.
		final Optional<TodoEntity> original = repository.findById(entity.getId());
		
		//3. 변환된 TodoEntity 존재하면 값을 새 entity  값으로 덮음.
		original(todo -> {
			
		})
	}
}