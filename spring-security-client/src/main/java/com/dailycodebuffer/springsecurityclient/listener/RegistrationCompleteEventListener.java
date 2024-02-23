package com.dailycodebuffer.springsecurityclient.listener;

import com.dailycodebuffer.springsecurityclient.entity.User;
import com.dailycodebuffer.springsecurityclient.event.RegistrationCompleteEvent;
import com.dailycodebuffer.springsecurityclient.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent>
{
	

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event)
    {
        //crete verification token for the User with Link

        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token,user);

        //send mail to user
        String url=event.getApplicationUrl()+"/verifyRegistration?token="+token;
        //send verification Email()
        log.info("click the link to verify your account:{}",url);

   }
}
