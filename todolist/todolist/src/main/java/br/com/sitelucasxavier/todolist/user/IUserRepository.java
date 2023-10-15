package br.com.sitelucasxavier.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


// Interface = Modelo, contrato
//<> -> generator, atributos mais dinamicos
public interface IUserRepository  extends JpaRepository<UserModel, UUID>{
    UserModel findByUsername(String username);
}
