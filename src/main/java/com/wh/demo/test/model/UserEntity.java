package com.wh.demo.test.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * @author wanghuan
 *
 */
public class UserEntity {

	public interface UserEntitySimpleView {
	};

	public interface UserEntityDetailView extends UserEntitySimpleView {
	};

	/**
	 * id
	 */
	@JsonView(UserEntityDetailView.class)
	private Integer id;
	/**
	 * 姓名
	 */
	@JsonView(UserEntitySimpleView.class)
	private String loginName;
	/**
	 * 登录名
	 */
	@JsonView(UserEntitySimpleView.class)
	private String name;
	/**
	 * 密码
	 */
	@JsonView(UserEntityDetailView.class)
	private String password;
	/**
	 * 邮箱
	 */
	private String email;

	private Date birthday;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", loginName=" + loginName + ", name=" + name + ", password=" + password
				+ ", email=" + email + ", birthday=" + birthday + "]";
	}

}
