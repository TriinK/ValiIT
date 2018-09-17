package ee.bcs.valiit.trikad.service;

import ee.bcs.valiit.trikad.bean.*;
import ee.bcs.valiit.trikad.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public User get(Long id) {
        return usersRepository.getOne(id);
    }

    public List<User> getAll() {return usersRepository.findAll();}

    public User findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    @Transactional
    public User save(User user) {
        return usersRepository.save(user);
    }

    @Transactional
    public void register(User user) {
        userRoleRepository.save(new UserRole(usersRepository.save(user).getId(), roleRepository.findByName("trikad.user").getId()));
    }

    public List<User> list() {
        return usersRepository.findAll();
    }

}
