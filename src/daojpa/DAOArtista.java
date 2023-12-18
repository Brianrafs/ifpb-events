/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/

package daojpa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import modelo.Apresentacao;
import modelo.Artista;

public class DAOArtista extends DAO<Artista> {

	 public Artista read(Object chave) {
	        try {
	            String nome = (String) chave;
	            TypedQuery<Artista> q = manager.createQuery("select ar from Artista ar LEFT JOIN FETCH ar.apresentacoes where ar.nome=:n", Artista.class);
	            q.setParameter("n", nome);
	            Artista p = q.getSingleResult();
	            return p;
	        } catch (NoResultException e) {
	            return null;
	        }
	}

	public List<Artista> readAll(){
		TypedQuery<Artista> query = manager.createQuery("select ar from Artista ar LEFT JOIN FETCH ar.apresentacoes order by ar.nome",Artista.class);
		return  query.getResultList();
	}
	
	// --------------------------------------------
	// consultas
	// --------------------------------------------

	public Artista listarMaiorApresentacao() {
	    TypedQuery<Object[]> query = manager.createQuery(
	        "SELECT a, COUNT(ap) as numApresentacoes " +
	        "FROM Artista a LEFT JOIN a.apresentacoes ap " +
	        "GROUP BY a " +
	        "ORDER BY numApresentacoes DESC, a.nome",
	        Object[].class
	    );

	    query.setMaxResults(1); // Define o número máximo de resultados como 1

	    List<Object[]> resultados = query.getResultList();

	    if (!resultados.isEmpty()) {
	        Object[] resultado = resultados.get(0);
	        Artista artista = (Artista) resultado[0];
	        artista.getApresentacoes().size();
	        return artista;
	    }

	    return null; // Retorna null se não houver resultados
	}






	public List<Artista> artistasNaCidade(String nomeCidade) {
	    try {
	        TypedQuery<Artista> q = manager.createQuery(
	            "SELECT DISTINCT a FROM Apresentacao ap JOIN ap.artista a JOIN FETCH a.apresentacoes WHERE ap.cidade.nome = :nomeCidade",
	            Artista.class
	        );
	        q.setParameter("nomeCidade", nomeCidade);
	        return q.getResultList();
	    } catch (NoResultException e) {
	        return Collections.emptyList();
	    }
	}




}