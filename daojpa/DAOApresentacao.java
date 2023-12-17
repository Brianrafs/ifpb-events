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

public class DAOApresentacao  extends DAO<Apresentacao>{

	public Apresentacao read (Object chave){
		try{
			int id = (int) chave;
			TypedQuery<Apresentacao> q = manager.createQuery("select a from Apresentacao a where a.id = :n ",Apresentacao.class);
			q.setParameter("n", id);

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

	public List<Apresentacao> Listarapresentacoes(String modelo){
		TypedQuery<Apresentacao> q = manager.createQuery("select a from Apresentacao a where a.cidade.modelo = :x", Apresentacao.class);
		q.setParameter("x", modelo);
		
		return  q.getResultList();
	}

	
	public List<Apresentacao> ListarMaiorApresentacao(){
		TypedQuery<Apresentacao> q = manager.createQuery("select a from Apresentacao a where a.finalizado = true", Apresentacao.class);
		
		return  q.getResultList();
	}
}