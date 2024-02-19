package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TodoDTO;

@RestController // 어노테이션 사용으로 Rest임을 명시 -> 스프링이 http 관련 코드 요청/응답 알아서 해준다.
@RequestMapping("test") // 리소스
public class TestController {

	@GetMapping
	public String testController() {
		return "hello world!";
	}

	@GetMapping("/testGetMapping")
	public String testControllerWithPath() {
		return "GetMapping(/testGetMapping)";
	}

	@GetMapping("/{id}") // 값으로 받음 -> ex) /id=3
	public String testPathVariable(@PathVariable(value = "id") int id) {
		return "@PathVariable" + id;
	}

	@GetMapping("/testRequestParam")
	public String testRequestParam(@RequestParam(value = "id") int id) {
		return "@RequestParam=" + id;
	}
	
	@GetMapping("/testResponseBody")
	public ResponseDTO<String> test1() {
		List<String> list = new ArrayList<String>();
		list.add("Hi Min");
		ResponseDTO<String> res = ResponseDTO.<String>builder().data(list).build();
		
		return res;
	}
	
	@GetMapping("/testResponseEntity")
	public ResponseEntity<?> test2(){
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		
		ResponseDTO<String> res=ResponseDTO.<String>builder().data(list).build();
		return ResponseEntity.badRequest().body(res);
	}

}