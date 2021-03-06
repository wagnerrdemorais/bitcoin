package br.com.wagnerrdemorais.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private BigDecimal preco;

    private String tipo;

    private Date data;

    private String status;

    @Column(name = "user_id")
    private int userId;

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @JsonbTransient
    public int getUserId() {
        return userId;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getData() {
        return data;
    }

    public String getStatus() {
        return status;
    }
}
