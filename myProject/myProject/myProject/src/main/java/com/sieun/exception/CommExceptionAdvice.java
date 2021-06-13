package com.sieun.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

import lombok.extern.log4j.Log4j;

@ControllerAdvice //�ش� ��ü�� �������� ��Ʈ�ѷ����� �߻��ϴ� ���ܸ� ó���ϴ� �������� ���
@Log4j
public class CommExceptionAdvice {
	
			/*
			 *500�޼����� Internal Sever Error�̹Ƿ� @ExceptionHandler�� �̿��ؼ� ó���� ���� ������ 
			 *404�޼����� �߸��� URL�� ȣ���� �� ���̹Ƿ� �ٸ��� ó�����־�� �Ѵ�.
			 */
	
							//Exception:��� ����
		@ExceptionHandler(Exception.class)//� ���ܰ� �߻������� �޼ҵ带  �ڵ����� �������� �����ִ� �� 
		public String except(Exception e, Model model) {
			//���ܰ� �߻��ϰ� �Ǹ� �ش� ���� �ʵ尡 �޸𸮿� �Ҵ�ȴ�.
			//�Ҵ�� �����ʵ��� �ּҰ��� ���� ��ü�� �ʿ��ϹǷ� �Ű����� ExceptionŸ���� 
			//e ��ü�� �����س��´�.
			e.printStackTrace();
			log.error("Exception......."+e.getMessage());
			model.addAttribute("exception",e);
			log.error(model);
			return "error_page";
		}
		
		//404�� exception�� �ȶ߱� ������ xml���� �������༭ 404�� �߸� exception�� �ߵ��� ���� �Ѵ�
		//NoHandlerFoundException : �ڵ鷯�� ã�� ���ߴٴ� ��
		@ExceptionHandler(NoHandlerFoundException.class)
		//������ ������ httpstatus�� ��ã�ڴٰ� ������ �Ѵ�
		@ResponseStatus(HttpStatus.NOT_FOUND)
		public String handle404() {
			return "error_page";
			
		}
}
