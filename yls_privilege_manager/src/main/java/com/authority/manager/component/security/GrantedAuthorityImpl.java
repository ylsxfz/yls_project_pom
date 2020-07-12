package com.authority.manager.component.security;
import org.springframework.security.core.GrantedAuthority;

/**
 * @Author yls
 * @Description 权限封装
 * @Date 2020/4/6 9:32
 **/
public class GrantedAuthorityImpl implements GrantedAuthority {
	
	private static final long serialVersionUID = 1L;

	private String authority;

    public GrantedAuthorityImpl(String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}