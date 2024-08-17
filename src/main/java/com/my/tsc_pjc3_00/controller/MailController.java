package com.my.tsc_pjc3_00.controller;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="mail")
public class MailController {
   
   
   
   String getRandomNumbers() {
      
       Random random = new Random();      //랜덤 함수 선언
       int createNum = 0;           //1자리 난수
       String ranNum = "";          //1자리 난수 형변환 변수
       int letter    = 6;         //난수 자릿수:6
       String resultNum = "";        //결과 난수
   
       for (int i=0; i<letter; i++) { 
              
         createNum = random.nextInt(9);      //0부터 9까지 올 수 있는 1자리 난수 생성
         ranNum =  Integer.toString(createNum);  //1자리 난수를 String으로 형변환
         resultNum += ranNum;         //생성된 난수(문자열)을 원하는 수(letter)만큼 더하며 나열
       }   
       
           System.out.println(resultNum);
           
           return resultNum;
      
   }
   
   
   @GetMapping("sendMailWithNumbers")
   @ResponseBody
   public String sendMailWithNumbers(
            @RequestParam(value="to") String to
         ) {
      
      
      
      String randomNumbers = getRandomNumbers();
      
      String host = "smtps.hiworks.com"; // 네이버일 경우 네이버 계정, gmail경우 gmail 계정
        String user = "jc.park@newtsc.com"; // 패스워드
        String password = "pjc10250503!!";       

        // SMTP 서버 정보를 설정한다.
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");
       
        
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // 메일 제목
            message.setSubject("TSC 자재 관리자 서비스 인증번호 확인");

            // 메일 내용
            message.setText("인증번호는 "+randomNumbers+" 입니다.");

            // send the message
            Transport.send(message);
            System.out.println("Success Message Send");
            return randomNumbers;
        } catch (MessagingException e) {
            e.printStackTrace();
            return "fail";
        }
      
      
   }
}
