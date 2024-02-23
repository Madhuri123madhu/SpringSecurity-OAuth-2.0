package com.dailycodebuffer.springsecurityclient.event;

import com.dailycodebuffer.springsecurityclient.entity.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;


@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent
{

    private User user;
    private  String applicationUrl;
    
    public RegistrationCompleteEvent(User user,String applicationUrl) {
        super(user);
        this.setUser(user);
        this.setApplicationUrl(applicationUrl);

    }
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getApplicationUrl() {
		return applicationUrl;
	}
	public void setApplicationUrl(String applicationUrl) {
		this.applicationUrl = applicationUrl;
	}
}
