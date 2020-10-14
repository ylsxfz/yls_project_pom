package com.authority.manager.component.security.utils;

import com.authority.manager.component.security.JwtAuthenticatioToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @Author yls
 * @Description Security相关操作
 * @Date 2020/4/6 9:38
 **/
public class SecurityUtils {

	/**
	 * @Description 系统登录认证
	 * @param request 请求
	 * @param username 用户名
	 * @param password 密码
	 * @param authenticationManager 认证管理器
	 * @return
	 */
	public static JwtAuthenticatioToken login(HttpServletRequest request, String username, String password, AuthenticationManager authenticationManager) {

		JwtAuthenticatioToken token = new JwtAuthenticatioToken(username, password);
		token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		// 执行登录认证过程
	    Authentication authentication = authenticationManager.authenticate(token);
	    // 认证成功存储认证信息到上下文
	    SecurityContextHolder.getContext().setAuthentication(authentication);
		/**
		 * 判断token是否已经存在
		 */
		if (!TokenStore.checkTokenExp(username)) {
			token.setToken(TokenStore.getToken(username));
		}else{
			// 生成令牌并返回给客户端
			token.setToken(JwtTokenUtils.generateToken(authentication));
		}
		return token;
	}


	/**
	 * 功能描述:
	 * 〈登出操作：手动退出的时候将清理token，下次登录要重新认证，同时删除token信息〉
	 *
	 * @author : yls
	 * @date : 2020/10/14 9:07
	 * @param request 请求
	 * @param response 响应
	 * @param authentication 认证信息
	 * @return : void 不返回信息
	 */
	public static void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication){
		String username = getUsername(authentication);
		Objects.requireNonNull(username);
		// 清理后台的token数据
		TokenStore.removeToken(username);
		// 清除上下文认证信息
		removeContext();
	}



	/**
	 * 清除当前用户上下文
	 */
	public static void removeContext() {
		SecurityContextHolder.clearContext();
	}


	/**
	 * @Description 获取令牌进行认证
	 * @param request
	 */
	public static void checkAuthentication(HttpServletRequest request) {
		// 获取令牌并根据令牌获取登录认证信息
		Authentication authentication = JwtTokenUtils.getAuthenticationeFromToken(request);
		// 设置登录认证信息到上下文
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	/**
	 * @Description 获取当前用户名
	 * @return
	 */
	public static String getUsername() {
		String username = null;
		Authentication authentication = getAuthentication();
		if(authentication != null) {
			Object principal = authentication.getPrincipal();
			if(principal != null && principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			}
		}
		return username;
	}
	
	/**
	 * @Description 获取用户名
	 * @return
	 */
	public static String getUsername(Authentication authentication) {
		String username = null;
		if(authentication != null) {
			Object principal = authentication.getPrincipal();
			if(principal != null && principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			}
		}
		return username;
	}
	
	/**
	 * @Description 获取当前登录信息
	 * @return
	 */
	public static Authentication getAuthentication() {
		if(SecurityContextHolder.getContext() == null) {
			return null;
		}
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication;
	}
	
}
