package com.example.demo.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.model.TodoEntity;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String>{
	
	/*
	 * SELECT * FROM TodoRepository WHERE userId = '{userId}'
	 */
	@Query("select t from TodoEntity t where t.userId = ?1")
	List<TodoEntity> findByUserId(String userId);
}
