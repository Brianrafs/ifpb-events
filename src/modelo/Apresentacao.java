package modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Apresentacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String data;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE},
			fetch=FetchType.LAZY)
	private Artista artista;
	private Cidade cidade;
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE},
			fetch=FetchType.LAZY)
	private int precoIngresso;
	
	public Apresentacao(int id, String data , Artista artista, Cidade cidade, int precoIngresso) {
		this.id = id;
		this.data = data;
		this.artista = artista;
		this.cidade = cidade;
		this.precoIngresso = precoIngresso;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public int getPrecoIngresso() {
		return precoIngresso;
	}
	public void setPrecoIngresso(int precoIngresso) {
		this.precoIngresso = precoIngresso;
	}
	@Override
	public String toString() {
		return "Apresentacao [id = " + id + ", data = " + data + ", artista=" + artista + ", " + cidade
				+ ", precoIngresso = " + precoIngresso + "]";
	}
}