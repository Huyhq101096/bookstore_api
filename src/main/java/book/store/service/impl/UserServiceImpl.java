package book.store.service.impl;

import book.store.entity.Role;
import book.store.entity.User;
import book.store.payload.request.UserRq;
import book.store.payload.response.UserRsp;
import book.store.repository.RoleRepository;
import book.store.repository.UserRepository;
import book.store.service.IRoleService;
import book.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public boolean createUser(UserRq userRq) {
        if (getUserByEmail(userRq.getEmail())) {
            User user = new User();
            user.setEmail(userRq.getEmail());
            user.setPassword(passwordEncoder.encode(userRq.getPassword()));
            user.setPhone(userRq.getPhone());
            user.setFirstName(userRq.getFirstName());
            user.setLastName(userRq.getLastName());
            user.setStatus("active");

//            List<Role> roleList = roleRepository.findAll();
//            List<Role> roleList1 = new ArrayList<>();
//            roleList1.add(roleList.get(1));
//            user.setRoles(roleList1);

            List<Role> roleList = new ArrayList<>();
            Role role = roleRepository.findById(2).orElse(null);
            if (role != null) {
                roleList.add(role);
            }
            user.setRoles(roleList);

            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean getUserByEmail(String email) {
        List<User> list = userRepository.findAll();
        if(list.isEmpty()) {
            return true;
        }
        List<UserRsp> userRspList = new ArrayList<>();
        for (User user: list) {
            UserRsp userRsp = new UserRsp();
            userRsp.setEmail(user.getEmail());
            userRsp.setPassword(user.getPassword());
            userRspList.add(userRsp);
        }
        boolean success = true;
        for (UserRsp userRsp: userRspList) {
            if (Objects.equals(email, userRsp.getEmail())) {
                success = false;
                break;
            }
        }
        return success;
    }

    @Override
    public boolean checkSignin(UserRq userRq) {
        Optional<User> user = userRepository.findByEmailAndPassword(userRq.getEmail(), userRq.getPassword());
        if(!user.isEmpty()) {
            return true;
        }
        return false;
    }
}
