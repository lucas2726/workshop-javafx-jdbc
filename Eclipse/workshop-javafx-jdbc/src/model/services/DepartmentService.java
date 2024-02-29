package model.services;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

//DepartmentService é uma classe responsável por fornecer serviços relacionados a entidades do tipo Department.
public class DepartmentService {

	/*
	 * Uma variável de instância dao do tipo DepartmentDao é inicializada com uma
	 * instância de DepartmentDao obtida por meio da fábrica (DaoFactory).
	 */
	private DepartmentDao dao = DaoFactory.createDepartmentDao();

	/*
	 * Um método público findAll retorna uma lista de todos os departamentos,
	 * utilizando o método correspondente no DepartmentDao.
	 */
	public List<Department> findAll() {
		return dao.findAll();
	}

	/*
	 * Um método público saveOrUpdate salva ou atualiza um departamento, dependendo
	 * se o ID é nulo. Se o ID for nulo, o método utiliza o dao.insert(obj) para
	 * inserir um novo departamento; caso contrário, usa dao.update(obj) para
	 * atualizar um departamento existente.
	 */
	public void saveOrUpdate(Department obj) {
		if (obj.getId() == null) {
			dao.insert(obj);
		} else {
			dao.update(obj);
		}
	}

	/*
	 * Um método público remove exclui um departamento com base no seu ID,
	 * utilizando o método dao.deleteById.
	 */
	public void remove(Department obj) {
		dao.deleteById(obj.getId());
	}

	/*
	 * Um método público remove exclui um departamento com base no seu ID,
	 * utilizando o método dao.deleteById.
	 */
}
