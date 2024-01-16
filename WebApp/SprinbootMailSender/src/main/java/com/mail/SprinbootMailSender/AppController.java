package com.mail.SprinbootMailSender;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class AppController {
 
    @Autowired
    JavaMailSender javaMailSender;
    @RequestMapping(value = "/SpringTest", method = RequestMethod.POST)
    @ResponseBody
    public String helloSpringBoot(@RequestBody Map<String, String> requestMap) {
        String mailTo = requestMap.get("mailTo");
        String txtSubject = requestMap.get("txtSubject");
        String issueRegarding = requestMap.get("issueRegarding");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("skaneskebabtekniker@gmail.com");
        message.setTo(mailTo);
        message.setSubject(issueRegarding);
        message.setText("Dear Customer, \n\nThank you for contacting our support team regarding your issue. This email is to confirm that we have received your ticket regarding : '"+ issueRegarding +"' and that we are working to resolve the issue as soon as possible.\n\n"
                + "Please note that our support team operates Monday to Friday from 9:00 AM to 5:00 PM EST. We will make every effort to respond to your ticket within 24 hours during these times. If you require immediate assistance, please call our support hotline at Kebabteknikers website.\n\n"
                + "Thank you for your patience and understanding.\n\n"
                + "Best regards,\n"
                + "Skånes Kebabtekniker Support Team \n \n \n \n"
                + "Your submition Text: "+ txtSubject+ "");

        javaMailSender.send(message);

        System.out.println("Mail successfully sent..");

        return "Mail successfully sent..";
    }
    
}