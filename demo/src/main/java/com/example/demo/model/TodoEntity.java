package com.example.demo.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder // 디자인 패턴 (클래스없이 오브젝트 생성가능)
@NoArgsConstructor // 매개변수가 없는 생성자를 구현함.
@AllArgsConstructor // 클래스의 모든 멤버 변수를 매개변수로 받는 생성자 구현
@Data // Getter_Setter 자동화
@Entity
@Table(name = "Todo") // Todo 테이블 매핑
public class TodoEntity {
	@Id
	@GeneratedValue(generator = "system-uuid")   // Id 자동생성 (생성 방식)
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id; // 이 오브젝트의 아이디
	private String userId; // 사용자 아이디
	private String title; // Todo 제목
	private boolean done;
}