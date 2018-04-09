package co.com.nubicall.users.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import co.com.nubicall.users.util.UserStatusEnum;

@Entity(name = "user_nubicall")
public class UserEntity {

	@Id
	@Column(name = "username")
	private String userName;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "phone")
	private String phone;

	@Column(name = "userstatus")
	@Enumerated(EnumType.STRING)
	private UserStatusEnum userStatus;

	public UserEntity() {
		super();

	}

	public UserEntity(String userName) {
		super();
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public UserStatusEnum getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(UserStatusEnum userStatus) {
		this.userStatus = userStatus;
	}

}
