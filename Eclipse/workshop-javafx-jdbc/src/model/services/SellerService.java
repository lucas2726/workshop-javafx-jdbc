package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

//SellerService é uma classe que encapsula lógica de negócios relacionada a operações com vendedores (Seller).
public class SellerService {

	/*
	 * Uma variável de instância dao do tipo SellerDao é inicializada com uma
	 * instância de SellerDao obtida por meio da fábrica (DaoFactory).
	 */
	private SellerDao dao = DaoFactory.createSellerDao();

	/*
	 * Um método público findAll retorna uma lista de todos os vendedores,
	 * utilizando o método correspondente no SellerDao.
	 */
	public List<Seller> findAll() {
		return dao.findAll();
	}

	/*
	 * Um método público saveOrUpdate salva ou atualiza um vendedor, dependendo se o
	 * ID é nulo. Se o ID for nulo, o método utiliza o dao.insert(obj) para inserir
	 * um novo vendedor; caso contrário, usa dao.update(obj) para atualizar um
	 * vendedor existente.
	 */
	public void saveOrUpdate(Seller obj) {
		if (obj.getId() == null) {
			dao.insert(obj);
		} else {
			dao.update(obj);
		}
	}

	// Um método público remove exclui um vendedor com base no seu ID, utilizando o
	// método dao.deleteById.
	public void remove(Seller obj) {
		dao.deleteById(obj.getId());
	}

}
