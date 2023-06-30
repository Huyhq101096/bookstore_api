package book.store.service;

import book.store.payload.request.UserRq;

public interface IUserService {


    public boolean createUser(UserRq userRq);

    public boolean getUserByEmail(String email);

}
