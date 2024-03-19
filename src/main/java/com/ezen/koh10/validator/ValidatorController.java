package com.ezen.koh10.validator;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ValidatorController {
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(ValidatorController.class);

	@RequestMapping(value = "/input")
	public String input() {
		
		return "input";
	}
	
	@RequestMapping(value = "/inputsave", method = RequestMethod.POST)
	public String inputsave(@ModelAttribute VinfoDTO vinfoDTO, BindingResult br, HttpServletResponse response) throws IOException { // command 방식은 객체명이 맨 앞글자 소문자 말고 클래스명과 같아야 한다. // BindingResult = 에러가 나면 실행되는 객체
		String viewPage = "out"; // 출력 화면을 결정하는 변수
		VinfoDTOValidator vdto = new VinfoDTOValidator();
		vdto.validate(vinfoDTO, br); // vdto = 검증 완료 데이터, br = 검증 에러 데이터
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		if(br.hasErrors())
		{
			if(br.getFieldErrorCount()==3)
			{
				pw.print("<script> alert('이름과 나이를 입력해주세요'); window.location.href='./input'; </script> ");
				pw.close();
			}
			else if(br.getFieldErrorCount()==2)
			{
				pw.print("<script> alert('나이를 입력해주세요'); window.location.href='./input'; </script> ");
				pw.close();
			}
			else if(br.getFieldErrorCount()==1)
			{
				pw.print("<script> alert('이름을 입력해주세요'); window.location.href='./input'; </script> ");
				pw.close();
			}
			viewPage = "input";
			
		}
		return viewPage;
	}
	
}
