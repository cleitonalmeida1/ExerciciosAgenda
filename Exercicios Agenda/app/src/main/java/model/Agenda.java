package model;

import java.io.Serializable;

/**
 * Created by Cleiton Gonçalves on 21/01/2016.
 */
public class Agenda implements Serializable {
    private String nome;
    private String telefone;
    private int imagem;
    private int _id;

    public Agenda(){

    }

    public Agenda(String nome, String telefone, int imagem) {
        this.nome = nome;
        this.telefone = telefone;
        this.imagem = imagem;

    }

    public Agenda(int _id, String nome, String telefone, int imagem) {
        this.nome = nome;
        this.telefone = telefone;
        this.imagem = imagem;
        this._id = _id;
    }

    public int getId(){
        return _id;
    }

    public void setId(int _id) {
        this._id = _id;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getImagem() {
       return  imagem = imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }
}