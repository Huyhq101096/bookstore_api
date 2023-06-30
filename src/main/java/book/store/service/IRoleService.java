package book.store.service;


import book.store.payload.response.RoleRsp;

import java.util.List;

public interface IRoleService {

    List<RoleRsp> getAllRole();
}
