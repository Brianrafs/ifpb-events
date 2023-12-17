package modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "cidade")
public class Cidade {
	@Id
  private String nome;
	@OneToMany(mappedBy = "cidade", cascade={CascadeType.PERSIST, CascadeType.MERGE}, 
			fetch = FetchType.LAZY)
	private List<Apresentacao> apresentacoes;
	
	public Cidade() {
	}
	public Cidade(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Apresentacao> getApresentacoes(){
		return apresentacoes;
	}
	@Override
	public String toString() {
		return "Cidade = [" + nome + "]";
	}
}