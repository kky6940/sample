package com.ezen.koh10.store;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.ezen.koh10.store.PageDTO;
import com.ezen.koh10.store.Service;

@Controller
public class StoreController {
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

	@RequestMapping(value = "/storeinput")
	public String storeinput() {
		
		return "storeinput";
	}
	
	@RequestMapping(value = "/storesave")
	public String storesave(HttpServletRequest request) {
		String place = request.getParameter("place");
		String carname = request.getParameter("carname");
		int su = Integer.parseInt(request.getParameter("su"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		Service ss = sqlSession.getMapper(Service.class);
		ss.insert(place, carname, su, price);
		return "redirect:/main";
	}
	
	@RequestMapping(value = "/storepage")
	public String storepage(HttpServletRequest request, PageDTO dto, Model mo) {
	   String nowPage=request.getParameter("nowPage");
       String cntPerPage=request.getParameter("cntPerPage");
       Service ss = sqlSession.getMapper(Service.class);
       //전체레코드수구하기
       int total=ss.total();
       System.out.println("총 레코드 개수 : "+total);
       if(nowPage==null && cntPerPage == null) { // 처음 실행하면 현재 페이지와 전체 페이지 수는 null이다.
          nowPage="1";
          cntPerPage="5";
       }
       else if(nowPage==null) {
          nowPage="1";
       }
       else if(cntPerPage==null) {
          cntPerPage="5";
       }      
       dto=new PageDTO(total,Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
       mo.addAttribute("paging",dto);
       mo.addAttribute("list",ss.page(dto));
		
       return "storepage";
	}
	
	@RequestMapping(value = "/placesell")
	public String placesell(HttpServletRequest request, PageDTO dto, Model mo) {
	   String nowPage=request.getParameter("nowPage");
       String cntPerPage=request.getParameter("cntPerPage");
     
       Service ss = sqlSession.getMapper(Service.class);
       //전체레코드수구하기
       int total=ss.total();
       System.out.println("총 레코드 개수 : "+total);
       if(nowPage==null && cntPerPage == null) { // 처음 실행하면 현재 페이지와 전체 페이지 수는 null이다.
          nowPage="1";
          cntPerPage="5";
          
       }
       else if(nowPage==null) {
          nowPage="1";
       }
       else if(cntPerPage==null) {
          cntPerPage="5";
       }

       dto=new PageDTO(total,Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
       
       mo.addAttribute("paging",dto);
       mo.addAttribute("list",ss.placesell(dto));
		
       return "placesellout";
	}
	
	@RequestMapping(value = "/carsell")
	public String carsell(HttpServletRequest request, PageDTO dto, Model mo) {
	   String nowPage=request.getParameter("nowPage");
       String cntPerPage=request.getParameter("cntPerPage");
       String carname = request.getParameter("cname");
       System.out.println(carname);
       if(carname==null)
       {
    	   carname = "세단";
    	   Service ss = sqlSession.getMapper(Service.class);
           //전체레코드수구하기
           int total=ss.total();
           System.out.println("총 레코드 개수 : "+total);
           if(nowPage==null && cntPerPage == null) { // 처음 실행하면 현재 페이지와 전체 페이지 수는 null이다.
              nowPage="1";
              cntPerPage="5";
              
           }
           else if(nowPage==null) {
              nowPage="1";
           }
           else if(cntPerPage==null) {
              cntPerPage="5";
           }

           dto=new PageDTO(total,Integer.parseInt(nowPage),Integer.parseInt(cntPerPage),carname);
           System.out.println(carname);
           mo.addAttribute("paging",dto);
           mo.addAttribute("list",ss.carsell(dto));
       }
       else {
    	   
       
       Service ss = sqlSession.getMapper(Service.class);
       //전체레코드수구하기
       int total=ss.total();
       System.out.println("총 레코드 개수 : "+total);
       if(nowPage==null && cntPerPage == null) { // 처음 실행하면 현재 페이지와 전체 페이지 수는 null이다.
          nowPage="1";
          cntPerPage="5";
          
       }
       else if(nowPage==null) {
          nowPage="1";
       }
       else if(cntPerPage==null) {
          cntPerPage="5";
       }

       dto=new PageDTO(total,Integer.parseInt(nowPage),Integer.parseInt(cntPerPage),carname);
       System.out.println(carname);
       mo.addAttribute("paging",dto);
       mo.addAttribute("list",ss.carsell(dto));
       }
       return "carsell";
       
	}
	
	@RequestMapping(value = "/maxsell")
	public String maxsell(HttpServletRequest request, PageDTO dto, Model mo) {
	   String nowPage=request.getParameter("nowPage");
       String cntPerPage=request.getParameter("cntPerPage");
     
       Service ss = sqlSession.getMapper(Service.class);
       //전체레코드수구하기
       int total=ss.total();
       System.out.println("총 레코드 개수 : "+total);
       if(nowPage==null && cntPerPage == null) { // 처음 실행하면 현재 페이지와 전체 페이지 수는 null이다.
          nowPage="1";
          cntPerPage="5";
          
       }
       else if(nowPage==null) {
          nowPage="1";
       }
       else if(cntPerPage==null) {
          cntPerPage="5";
       }

       dto=new PageDTO(total,Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
       
       mo.addAttribute("paging",dto);
       mo.addAttribute("list",ss.maxsell(dto));
		
       return "maxsell";
	}
	
	@RequestMapping(value = "/storepageasc")
	public String storepageasc(HttpServletRequest request, PageDTO dto, Model mo) {
	   String nowPage=request.getParameter("nowPage");
       String cntPerPage=request.getParameter("cntPerPage");
       Service ss = sqlSession.getMapper(Service.class);
       //전체레코드수구하기
       int total=ss.total();
       System.out.println("총 레코드 개수 : "+total);
       if(nowPage==null && cntPerPage == null) { // 처음 실행하면 현재 페이지와 전체 페이지 수는 null이다.
          nowPage="1";
          cntPerPage="5";
       }
       else if(nowPage==null) {
          nowPage="1";
       }
       else if(cntPerPage==null) {
          cntPerPage="5";
       }      
       dto=new PageDTO(total,Integer.parseInt(nowPage),Integer.parseInt(cntPerPage));
       mo.addAttribute("paging",dto);
       mo.addAttribute("list",ss.storepageasc(dto));
		
       return "storepage";
	}
	
	
	
}
