package modelo;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class Cidade {
	@Id
  private String nome;
	@OneToMany(mappedBy = "cidade", cascade={CascadeType.PERSIST, CascadeType.MERGE}, 
			fetch = FetchType.LAZY)
  ArrayList<Apresentacao> apresentacoes = new ArrayList<>();

public Cidade(String nome) {
	this.nome = nome;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public ArrayList<Apresentacao> getApresentacoes(){
	return apresentacoes;
}
@Override
public String toString() {
	return "Cidade = [" + nome + "]";
}
}