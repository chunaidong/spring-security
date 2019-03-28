package com.wangmike.security.browser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *    @author  : wangchun
 *    @time    : 2019/3/28 16:04
 *    desc    : 自定义获取用户信息
 *    version : v1.0
 * </pre>
 */
@Component
public class MyUserDetailsService implements UserDetailsService {



    private Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("当前登陆用户 {}",username);
        //TODO 根据用户名从数据库查询相应的用户信息，构造成UserDeatils返回 到spring-security中
        String password = passwordEncoder.encode("123456");
        logger.info("用户密码：{}",password);
        User user = new User(username, password, true,
                true, true,
                true,AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        return user;
    }
}
