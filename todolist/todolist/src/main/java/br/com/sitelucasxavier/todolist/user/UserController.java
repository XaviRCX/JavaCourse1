package br.com.sitelucasxavier.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * MODIFICADOR
 * public
 * private
 * protected
 */
@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    //Gerencia o ciclo de vida
    private IUserRepository userRepository;
    
    //dentro do body da estrutura
    @PostMapping("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        // ResponseEntity => entidade de resposta que permite a saida de tipos diferentes de saida
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user != null) {
            System.out.println("Usuário já existe");
            // Mensagem de erro
            // Status code(400 -> erro que nao permite ir em frente , ou usar HttpStatus. para ver quais tipos temos)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        //Criptografar a senha
        var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray());
        userModel.setPassword(passwordHashred);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
}
