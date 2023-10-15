package br.com.sitelucasxavier.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
// Coloca get e set para todos os parametros, @Getter faz de todos os gets e @Setter todos os sets, colocar em cima
// do atributo define ele apenas para o atributo
@Data
 // Métodos de getters e setters
    /* Equivalente a:
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    */
@Entity(name="tb_users")
//Cria uma tabela(entidade) com uma chave primaria(ID), chave unica para representar a informacao, o dado
public class UserModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    //Fzer a geracao do ID
    private UUID id;

    //@Column(name="usuario")
    //para trocar o nome da coluna no db
    @Column(unique = true)
    // Faz com que cada username tenha a condição de ser unico
    private String username;
    private String name;
    private String password;

    @CreationTimestamp
    //mostra quando foi criado
    private LocalDateTime createdAt;
}
