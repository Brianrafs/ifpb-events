/**********************************
 * IFPB - SI
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 **********************************/
package daojpa;

import java.util.List;

import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import modelo.Apresentacao;
import modelo.Artista;

public class DAOApresentacao  extends DAO<Apresentacao>{

	public Apresentacao read (Object chave){
		try{
			int id = (int) chave;
			TypedQuery<Apresentacao> q = manager.createQuery("select a from Apresentacao a where a.id = :id ",Apresentacao.class);
			q.setParameter("id", id);

			return q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	public List<Apresentacao> readAll(){
		TypedQuery<Apresentacao> q = manager.createQuery("select a from Apresentacao a LEFT JOIN FETCH a.cidade  JOIN FETCH a.artista order by a.id", Apresentacao.class);
		return  q.getResultList();
	}


	//--------------------------------------------
	//  consultas
	//--------------------------------------------

	public List<Apresentacao> Listarapresentacoes(String data) {
	    TypedQuery<Apresentacao> query = manager.createQuery(
	        "SELECT a FROM Apresentacao a LEFT JOIN FETCH a.artista LEFT JOIN FETCH a.cidade WHERE a.data = :data",
	        Apresentacao.class
	    );
	    query.setParameter("data", data);
	    
	    return query.getResultList();
	}

}
