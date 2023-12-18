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
import modelo.Cidade;

public class DAOCidade extends DAO<Cidade>{

	public Cidade read (Object chave){
		try {
            String nome = (String) chave;
            TypedQuery<Cidade> q = manager.createQuery("select c from Cidade c LEFT JOIN FETCH c.apresentacoes where c.nome=:nome", Cidade.class);
            q.setParameter("nome", nome);
            Cidade c = q.getSingleResult();
            return c;
        } catch (NoResultException e) {
            return null;
        }
    }

	public List<Cidade> readAll(){
	    TypedQuery<Cidade> query = manager.createQuery("select c from Cidade c LEFT JOIN FETCH c.apresentacoes order by c.nome",Cidade.class);
	    return  query.getResultList();
	}
	
}
