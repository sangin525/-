package kr.co.project.room.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.nurigo.sdk.message.model.Message;



@WebServlet("/ReserveMessage.do")
public class ReserveMessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	final DefaultMessageService messageService;
	
    public ReserveMessageController() {
    	 // 반드시 계정 내 등록된 유효한 API 키, API Secret Key를 입력해주셔야 합니다!
//    	 this.messageService = NurigoApp.INSTANCE.initialize("api-key", "api-secret-key", "https://api.coolsms.co.kr");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("phoneNumber");
		Message message = new Message();
		
		Random random = new Random(); // 랜덤 함수 선언
		int createNum = 0; // 1자리 난수
		String ranNum = ""; // 1자리 난수 형변환 변수
		int letter = 4; // 난수 자릿수:4
		String resultNum = ""; // 결과 난수

		for (int i = 0; i < letter; i++) {

			createNum = random.nextInt(9); // 0부터 9까지 올 수 있는 1자리 난수 생성
			ranNum = Integer.toString(createNum); // 1자리 난수를 String으로 형변환
			resultNum += ranNum; // 생성된 난수(문자열)을 원하는 수(letter)만큼 더하며 나열
		}
		
		
		System.out.println("랜덤숫자는 : "+resultNum);
		
		PrintWriter out = response.getWriter();
		out.print(resultNum);
		out.close();
		
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
//        message.setFrom("01093406483");
//        message.setTo(number);
//        message.setText("인증번호 : "+resultNum);
//
//        SingleMessageSentResponse response1 = this.messageService.sendOne(new SingleMessageSendingRequest(message));
//        System.out.println("결과값은 : "+response1);

		
		
		
		
	}

}
