package RGR.photogallery.service;

import RGR.photogallery.domain.User;
import RGR.photogallery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceDomain implements UserService {

    @Autowired
    UserRepository userService;

    @Override
    public List<User> getList() {
        List<User> users = new ArrayList<>();
        userService.findAll().forEach(users::add);

        return users;
    }

    @Override
    public boolean isUserWithEmailExist(String email) {
        return userService.countByEmail(email) != 0 ? true : false;
    }

}
