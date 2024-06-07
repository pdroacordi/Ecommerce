package br.com.pedroacordi.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Integer id;

    @Column(name="nome", length = 100, nullable = false)
    private String nome;

    @Column(name="email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name="telefone_cliente", length = 20, nullable = false, unique = true)
    private String telefone;

    @Column(name="cep", length = 10)
    private String cep;

    @Column(name = "logradouro", length = 100)
    private String logradouro;

    @Column(name="numero", length = 10)
    private String numero;

    @Column(name = "complemento", length = 20)
    private String complemento;

    @Column(name = "bairro", length = 45)
    private String bairro;

    @Column(name = "cidade", length = 45)
    private String cidade;

    @Column(name = "estado", length = 2)
    private String estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
