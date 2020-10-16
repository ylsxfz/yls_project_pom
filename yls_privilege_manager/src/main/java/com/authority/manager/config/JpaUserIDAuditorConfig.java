package com.authority.manager.config;

import com.authority.manager.component.security.utils.SecurityUtils;
import com.yls.common.utils.StringFormatUtils;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author: yls
 * @Date: 2020/10/9 9:16
 * @Description: 利用jpa注入用户名
 * @Versionm 1.0
 */
@Component
public class JpaUserIDAuditorConfig implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        String username = SecurityUtils.getUsername();
        if (!StringFormatUtils.isNull(username)){
            return Optional.of(username);
        }
        return Optional.empty();
    }
}
