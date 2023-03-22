package nl.topicus.topiconfbackend.persistence;

import nl.topicus.topiconfbackend.domain.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findById(long id){
        return userRepository.findById(id).get();
    }

    public User findByUsername(String name){
        return userRepository.findByUsername(name);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }
}
