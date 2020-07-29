package jp.te4a.spring.boot.myapp13;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import jp.te4a.spring.boot.myapp13.UserBean;
import jp.te4a.spring.boot.myapp13.LoginUserDetails;
import jp.te4a.spring.boot.myapp13.UserRepository;

@Service
public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserBean> opt = userRepository.findById(username);
        UserBean user = opt.orElseThrow(() -> new UsernameNotFoundException("The requested user is not found."));
        return new LoginUserDetails(user);
    }
}
