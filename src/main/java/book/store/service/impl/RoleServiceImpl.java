package book.store.service.impl;

import book.store.entity.Role;
import book.store.payload.response.RoleRsp;
import book.store.repository.RoleRepository;
import book.store.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleRsp> getAllRole() {
        List<Role> roleList = roleRepository.findAll();
        List<RoleRsp> roleRspList = new ArrayList<>();

        for (Role role: roleList) {
            RoleRsp roleRsp = new RoleRsp();
            roleRsp.setId(role.getId());
            roleRsp.setName(role.getName());
            roleRspList.add(roleRsp);
        }

        return roleRspList;
    }
}
