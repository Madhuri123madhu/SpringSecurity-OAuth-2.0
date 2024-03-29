package com.dailycodebuffer.springsecurityclient.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class PasswordResetToken
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
            foreignKey = @ForeignKey(name="FK_USER_PASSWORD_TOKEN"))

    private User user;

    public PasswordResetToken(User user,String token)
    {
        super();
        this.token=token;
        this.user = user;
        this.expirationTime=caluculateExpirationDate(EXPIRATION_TIME);
    }

    public PasswordResetToken(String token)
    {
        super();
        this.token=token;
        this.expirationTime=caluculateExpirationDate(EXPIRATION_TIME);
    }

    private Date caluculateExpirationDate(int expirationTime)
    {
        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());

        calendar.add(Calendar.MINUTE,expirationTime);
        return new Date(calendar.getTime().getTime());
    }
}
