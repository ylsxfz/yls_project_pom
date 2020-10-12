package com.authority.manager.component.security.utils;

import com.authority.manager.component.security.GrantedAuthorityImpl;
import com.authority.manager.component.security.JwtAuthenticatioToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.*;

/**
 * @Author yls
 * @Description JWT工具类
 * @Date 2020/4/6 9:36
 **/
public class JwtTokenUtils implements Serializable {

	private static final long serialVersionUID = 1L;
	
	//用户名称
	private static final String USERNAME = Claims.SUBJECT;
	//创建时间
	private static final String CREATED = "created";
	//权限列表
	private static final String AUTHORITIES = "authorities";
	//密钥
    private static final String SECRET = "abcdefgh";
    //有效期12小时
    private static final long EXPIRE_TIME = 12 * 60 * 60 * 1000;

    /**
	 * @Description 生成令牌
	 * @param authentication 用户
	 * @return 令牌
	 */
	public static String generateToken(Authentication authentication) {
	    Map<String, Object> claims = new HashMap<>(3);
	    claims.put(USERNAME, SecurityUtils.getUsername(authentication));
	    claims.put(CREATED, new Date());
	    claims.put(AUTHORITIES, authentication.getAuthorities());
	    return generateToken(claims);
	}

	/**
     * @Description 从数据声明生成令牌
     * @param claims 数据声明
     * @return 令牌
     */
    private static String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
		String token = Jwts.builder().setClaims(claims).setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, SECRET).compact();
		TokenStore.addToken(String.valueOf(claims.get(USERNAME)), token, expirationDate.getTime());
		return token;
	}

    /**
	 * @Description 从令牌中获取用户名
	 * @param token 令牌
	 * @return 用户名
	 */
	public static String getUsernameFromToken(String token) {
	    String username;
	    try {
	        Claims claims = getClaimsFromToken(token);
	        username = claims.getSubject();
	    } catch (Exception e) {
	        username = null;
	    }
	    return username;
	}


	/**
	 * 功能描述:
	 * 〈删除token〉
	 *
	 * @author : yls
	 * @date : 2020/10/12 13:01
	 * @param token
	 * @return : void
	 */
	public static void removeToken(String token){
		if (!isTokenExpired(token)){
			String username = getUsernameFromToken(token);
			TokenStore.removeToken(username);
		}
	}
	
	/**
	 * @Description 根据请求令牌获取登录认证信息
	 * @param request 令牌
	 * @return 用户名
	 */
	public static Authentication getAuthenticationeFromToken(HttpServletRequest request) {
		Authentication authentication = null;
		// 获取请求携带的令牌
		String token = JwtTokenUtils.getToken(request);
		if(token != null) {
			// 请求令牌不能为空
			if(SecurityUtils.getAuthentication() == null) {
				// 上下文中Authentication为空
				Claims claims = getClaimsFromToken(token);
				if(claims == null) {
					return null;
				}
				String username = claims.getSubject();
				if(username == null) {
					return null;
				}
				if(isTokenExpired(token)) {
					return null;
				}
				Object authors = claims.get(AUTHORITIES);
				List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
				if (authors != null && authors instanceof List) {
					for (Object object : (List) authors) {
						authorities.add(new GrantedAuthorityImpl((String) ((Map) object).get("authority")));
					}
				}
				authentication = new JwtAuthenticatioToken(username, null, authorities, token);
			} else {
				if(validateToken(token, SecurityUtils.getUsername())) {
					// 如果上下文中Authentication非空，且请求令牌合法，直接返回当前登录认证信息
					authentication = SecurityUtils.getAuthentication();
				}
			}
		}
		return authentication;
	}

	/**
     * @Description 从令牌中获取数据声明
     * @param token 令牌
     * @return 数据声明
     */
    public static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
	 * @Description 验证令牌
	 * @param token
	 * @param username
	 * @return
	 */
	public static Boolean validateToken(String token, String username) {
	    String userName = getUsernameFromToken(token);
	    return (userName.equals(username) && !isTokenExpired(token));
	}

	/**
	 * @Description 刷新令牌
	 * @param token
	 * @return
	 */
	public static String refreshToken(String token) {
	    String refreshedToken;
	    try {
	        Claims claims = getClaimsFromToken(token);
	        claims.put(CREATED, new Date());
	        refreshedToken = generateToken(claims);
	    } catch (Exception e) {
	        refreshedToken = null;
	    }
	    return refreshedToken;
	}

	/**
     * @Description 判断令牌是否过期
     * @param token 令牌
     * @return 是否过期
     */
    public static Boolean isTokenExpired(String token) {
        try {
//            Claims claims = getClaimsFromToken(token);
//            System.err.println("test:"+claims.get("test"));
//            Date expiration = claims.getExpiration();
//            return expiration.before(new Date());
			String username = getUsernameFromToken(token);
			boolean tokenExp = TokenStore.checkTokenExp(username);
			System.err.println("tokenExp:"+tokenExp);
			return tokenExp;
		} catch (Exception e) {
            return false;
        }
    }

    /**
     * @Description 获取请求token
     * @param request
     * @return
     */
    public static String getToken(HttpServletRequest request) {
    	String token = request.getHeader("Authorization");
        String tokenHead = "Bearer ";
        if(token == null) {
        	token = request.getHeader("token");
        } else if(token.contains(tokenHead)){
        	token = token.substring(tokenHead.length());
        } 
        if("".equals(token)) {
        	token = null;
        }
        return token;
    }

}