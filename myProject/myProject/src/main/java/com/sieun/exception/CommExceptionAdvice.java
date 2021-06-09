package com.sieun.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice //해당 객체가 스프링의 컨트롤러에서 발생하는 예외를 처리하는 존재임을 명시
@Log4j
public class CommExceptionAdvice {
	
			/*
			 *500메서지는 Internal Sever Error이므로 @ExceptionHandler를 이용해서 처리가 가능 하지만 
			 *404메세지는 잘못된 URL을 호출할 떄 보이므로 다르게 처리해주어야 한다.
			 */
	
							//Exception:모든 예외
		@ExceptionHandler(Exception.class)//어떤 예외가 발생했을떄 메소드를  자동으로 실행할지 정해주는 것 
		public String except(Exception e, Model model) {
			//예외가 발생하게 되면 해당 예외 필드가 메모리에 할당된다.
			//할당된 예외필드의 주소값을 받을 객체가 필요하므로 매개변수 Exception타입의 
			//e 객체를 선언해놓는다.
			e.printStackTrace();
			log.error("Exception......."+e.getMessage());
			model.addAttribute("exception",e);
			log.error(model);
			return "error_page";
		}
		
		//404는 exception이 안뜨기 때문에 xml에서 설정해줘서 404가 뜨면 exception이 뜨도록 설정 한다
		//NoHandlerFoundException : 핸들러를 찾지 못했다는 뜻
		@ExceptionHandler(NoHandlerFoundException.class)
		//서버에 응답을 httpstatus를 못찾겠다고 응답을 한다
		@ResponseStatus(HttpStatus.NOT_FOUND)
		public String handle404() {
			return "error_page";
			
		}
}
