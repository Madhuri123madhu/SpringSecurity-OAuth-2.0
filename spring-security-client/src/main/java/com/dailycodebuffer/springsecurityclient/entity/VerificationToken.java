package com.dailycodebuffer.springsecurityclient.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Data
@Entity

public class VerificationToken
{
//Expiration Time is 10 minutes
    private  static   final int EXPIRATION_TIME=10;

    @Id
    @GeneratedValue
    private Long id;
    private  String token;
    private Date expirationTime;

@OneToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "user_id",
        nullable = false,
        foreignKey = @ForeignKey(name="FK_USER_VERIFY_TOKEN"))

    private User user;

    public VerificationToken(User user,String token)
    {
        super();
        this.setToken(token);
        this.user = user;
        this.setExpirationTime(caluculateExpirationDate(EXPIRATION_TIME));
    }

    
    
    public VerificationToken() {
		super();
		
	}



	public VerificationToken(String token)
    {
        super();
        this.setToken(token);
        this.setExpirationTime(caluculateExpirationDate(EXPIRATION_TIME));
    }

    private Date caluculateExpirationDate(int expirationTime)
    {
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());

        calendar.add(Calendar.MINUTE,expirationTime);
        return new Date(calendar.getTime().getTime());
    }

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}

	@Override
	public String toString() {
		return "VerificationToken [id=" + id + ", token=" + token + ", expirationTime=" + expirationTime + ", user="
				+ user + "]";
	}

	
	
}
