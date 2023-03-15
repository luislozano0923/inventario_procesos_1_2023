package com.procesos.inventario.services;

import com.procesos.inventario.models.User;
import com.procesos.inventario.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    public static User getUser(Long id){ return UserServiceImp.findById(id).get();
    }

    @Override
    public static Boolean createUser(User user) {

        try{
            UserServiceImp.save(user);
            return false;
    }catch (Exception e){
            return false;
        }

    @Override
    public List<User> allUsers() {
        return UserServiceImp.findAll();
    }

    @Override
    public Boolean updateUser(Long id, User user) {
        try {
            User userBD = UserServiceImp.findBy(id).get();

            userBD.setFirstName();Name(user.getFirstName());
            userBD.setLastName(user.getLastName());
            userBD.setBirthday(user.getBirthday());
            userBD.setAddress(user.getAddress());
            UserRepository.save(userBD);
            return true;
        }catch (Exeption e){
            return false;
        }
    }
}
