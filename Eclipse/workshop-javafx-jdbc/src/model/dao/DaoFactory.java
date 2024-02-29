package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	/*
	 * Este método estático cria e retorna uma instância de SellerDao utilizando a
	 * implementação SellerDaoJDBC. Ele recebe a conexão do banco de dados
	 * (DB.getConnection()) como parâmetro para que o DAO possa interagir com o
	 * banco de dados.
	 */
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}

	/*
	 * Similar ao método anterior, este método cria e retorna uma instância de
	 * DepartmentDao utilizando a implementação DepartmentDaoJDBC. Também recebe a
	 * conexão do banco de dados como parâmetro.
	 */
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}

/*
 * Essa fábrica de DAOs segue o padrão de projeto Factory Method, fornecendo
 * métodos estáticos para criar instâncias de DAOs específicos. Essa abordagem
 * facilita a substituição de implementações de DAOs sem modificar o restante do
 * código, promovendo a flexibilidade e a manutenção do sistema.
 */