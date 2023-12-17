/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/

package daojpa;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import modelo.Artista;

public class DAOArtista extends DAO<Artista> {

	public Artista read(Object chave) {
		try {
			String cpf = (String) chave;
			TypedQuery<Artista> q = manager.createQuery("select a from Artista ar where ar.cpf=:n", Artista.class);
			q.setParameter("n", cpf);
			Artista p = q.getSingleResult();
			return p;
		} catch (NoResultException e) {
			return null;
		}
	}

	public List<Artista> readAll(){
		TypedQuery<Artista> query = manager.createQuery("select a from Artista ar LEFT JOIN FETCH ar.apresentacoes order by c.cpf",Artista.class);
		return  query.getResultList();
	}
	
	// --------------------------------------------
	// consultas
	// --------------------------------------------

	public List<Artista> ListarMaiorApresentacao() {
		// cliestes com 3 alugueis
		TypedQuery<Artista> q = manager.createQuery("select a from Artista ar where size(ar.apresentacoes) =3", Artista.class);
		return q.getResultList();
	}
	
	public List<Artista> Apresentacaocidade(String n) {
		// cliestes com 3 alugueis
		TypedQuery<Artista> q = manager.createQuery("select a from Artista ar where size(ar.apresentacoes) =3", Artista.class);
		return q.getResultList();
	}
}