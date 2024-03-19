package com.ezen.koh10.validator;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class VinfoDTOValidator implements Validator { // 스프링 Validator를 사용해야함(tomcat 아님) 

	@Override
	public boolean supports(Class<?> clazz) {
		// 어디서 왔는지 알아봐주는 메소드
		return VinfoDTO.class.isAssignableFrom(clazz); //isAssignableFrom = 어떤 form에서 왔는지 알려줌
	}

	@Override
	public void validate(Object target, Errors errors) { //target = 검증 통과 데이터, errors = 에러 데이터 / 여기서 검증이 이루어진다.
		VinfoDTO dto = (VinfoDTO) target;
		String name = dto.getName(); // 이름
		int age = dto.getAge(); // 나이
		// 이름 검사
		if(name==null || name.trim().isEmpty()) // trim = 빈 여백을 없애줌
		{
			errors.rejectValue("name", "이름은 공백 안됨");
			
		}
		if(age<1 || age>150)
		{
			errors.rejectValue("age", "나이는 1~150 사이로 입력해야함");
			
		}
		
	}

	
	
	
}
