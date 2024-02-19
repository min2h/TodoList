package com.example.demo.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
// 제네릭 사용
public class ResponseDTO<T>{ 
	private String error;
	private List<T> data; // List : Todo 하나만 반환 x -> 여러 개 반환하는 일이 많기 때문
}