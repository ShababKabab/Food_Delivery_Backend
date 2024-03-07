package com.zosh.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
//import lombok.RequiredArgsConstructor;

@Entity
//@Data
//@NoArgsConstructor
//@RequiredArgsConstructor
//@AllArgsConstructor
public class PasswordResetToken {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	private String token;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	private User user;
	
	private Date expiryDate;
	
	public boolean isExpired() {
        return expiryDate.before(new Date());
    }

	public PasswordResetToken( String token, User user, Date expiryDate) {
		super();
		this.token = token;
		this.user = user;
		this.expiryDate = expiryDate;
	}

	public PasswordResetToken(Integer id, String token, User user, Date expiryDate) {
		super();
		this.id = id;
		this.token = token;
		this.user = user;
		this.expiryDate = expiryDate;
	}

	public PasswordResetToken() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
