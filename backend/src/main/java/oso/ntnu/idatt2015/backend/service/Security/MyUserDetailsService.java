package oso.ntnu.idatt2015.backend.service.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import oso.ntnu.idatt2015.backend.model.User.MyUserDetails;
import oso.ntnu.idatt2015.backend.model.User.QUser;
import oso.ntnu.idatt2015.backend.repository.User.UserRepository;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<QUser> user = userRepository.findByUsername(username);

        if (user.isEmpty()) {
            System.out.println("could not find user");
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user.get());
    }

}