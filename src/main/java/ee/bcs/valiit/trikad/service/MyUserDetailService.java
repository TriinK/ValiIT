package ee.bcs.valiit.trikad.service;

import ee.bcs.valiit.trikad.bean.MyUserPrincipal;
import ee.bcs.valiit.trikad.bean.User;
import ee.bcs.valiit.trikad.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

        @Autowired
        private UsersRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String username) {
            User user = userRepository.findByEmail(username);
            if (user == null) {
                throw new UsernameNotFoundException(username);
            }
            return new MyUserPrincipal(user);
        }
    }
