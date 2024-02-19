package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // 디자인 패턴 (클래스없이 오브젝트 생성가능)
@NoArgsConstructor // 매개변수가 없는 생성자를 구현함.
@AllArgsConstructor // 클래스의 모든 멤버 변수를 매개변수로 받는 생성자 구현
@Data // Getter / Setter 자동화
public class TodoEntity {
	private String id; // 이 오브젝트의 아이디
	private String userId; // 사용자 아이디
	private String title; // Todo 제목
	private boolean done;
}