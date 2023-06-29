package book.store.service.impl;

import book.store.entity.User;
import book.store.payload.request.UserRq;
import book.store.repository.UserRepository;
import book.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean createUser(UserRq userRq) {
        User user = new User();
        user.setEmail(userRq.getEmail());
        user.setPassword(userRq.getPassword());
        user.setPhone(userRq.getPhone());
        user.setFirstName(userRq.getFirstName());
        user.setLastName(userRq.getLastName());
        User success = userRepository.save(user);

        return success != null;
    }
}
