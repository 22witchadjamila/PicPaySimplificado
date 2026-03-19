package com.picpaysimplificado.services;


import com.picpaysimplificado.domain.transaction.Transaction;
import com.picpaysimplificado.domain.user.UserType;
import com.picpaysimplificado.dtos.UserDTO;
import com.picpaysimplificado.repositories.TransactionRepository;
import com.picpaysimplificado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.picpaysimplificado.domain.user.User;
import java.math.BigDecimal;
import java.util.List;

@Service
public class UserServices {
    @Autowired
    private UserRepository repository;

    public void validateTransaction(User sender, BigDecimal amount) throws Exception {
        if(sender.getUserType() == UserType.COMMON){
            throw new Exception("Usuario do tipo logista nao esta autorizado a realizar transação!");

        }
        if (sender.getBalance().compareTo(amount) < 0) {
            throw new Exception("Saldo suficiente!");

        }

    }
    public User findUserById(Long id) throws Exception {
        return this.repository.findById(id).orElseThrow(()-> new Exception("Usuario não encontrado!"));

    }

    public User createUser(UserDTO data) throws Exception {
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;

    }
    public List<User> getAllUsers() {
      return   this.repository.findAll();

    }
    public void saveUser(User user) throws Exception {
         this.repository.save(user);
    }
}
