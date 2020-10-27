package com.authority.manager.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author yls
 * @Description 登录接口封装对象
 * @Date 2020/4/12 12:03
 **/
@ApiModel(description = "登录对象")
public class LoginBeanBO implements Serializable {

	/**
	 * 账号
	 */
	@ApiModelProperty(value = "用户名")
	private String account;
	/**
	 * 密码
	 */
	@ApiModelProperty(value = "密码")
	private String password;
	/**
	 * 验证码
	 */
	@ApiModelProperty(value = "验证码")
	private String captcha;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCaptcha() {
		return captcha;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	@Override
	public String toString() {
		return "LoginBean{" +
				"account='" + account + '\'' +
				", password='" + password + '\'' +
				", captcha='" + captcha + '\'' +
				'}';
	}
}
