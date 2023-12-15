package modelo;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


public class Artista {
		@Id
		private String nome;
		@OneToMany(mappedBy = "artista", cascade={CascadeType.PERSIST, CascadeType.MERGE},
				fetch = FetchType.LAZY)
		private ArrayList<Apresentacao> apresentacoes = new ArrayList<>();
		public Artista(String nome, ArrayList<Apresentacao> apresentacoes) {
			this.nome = nome;
			this.apresentacoes = apresentacoes;
		}
		public Artista(String nome) {
			this.nome = nome;
		}

		public void adicionar(Apresentacao a){
			a.setArtista(this);
			this.apresentacoes.add(a);
		}
		public void remover(Apresentacao a){
			a.setArtista(null);
			this.apresentacoes.remove(a);
		}
		public Apresentacao localizar(int id){
			for(Apresentacao a : apresentacoes)
				if (a.getId() == id)
					return a;
			return null;
		}
		
		public ArrayList<Apresentacao> getApresentacoes() {
			return apresentacoes;
		}
		
		public void setApresentacoes(ArrayList<Apresentacao> apresentacoes) {
			this.apresentacoes = apresentacoes;
		}
		public String getNome() {
			return nome;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}

		@Override
		public String toString() {
			return "[" + nome + " - apresentacoes: " + apresentacoes.size() + "]";
		}
		
		
	}