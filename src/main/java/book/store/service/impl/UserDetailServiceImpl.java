package book.store.service.impl;

import book.store.entity.User;
import book.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("User không tồn tại");
        } else {
            org.springframework.security.core.userdetails.User user1 =
                    new org.springframework.security.core.userdetails
                            .User(user.getEmail(), user.getPassword(), new ArrayList<>());
            return user1;
        }

    }
}
