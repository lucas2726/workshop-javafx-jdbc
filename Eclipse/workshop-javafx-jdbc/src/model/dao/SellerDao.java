package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {

	void insert(Seller obj);//Define a assinatura para inserir um objeto Department no banco de dados
	void update(Seller obj);//Define a assinatura para atualizar um objeto Department no banco de dados.
	void deleteById(Integer id);// Define a assinatura para excluir um seller do banco de dados com base no ID.
	Seller findById(Integer id);//Define a assinatura para encontrar um seller no banco de dados com base no ID. 
	List<Seller> findAll();//Define a assinatura para encontrar todos os seller no banco de dados.
	List<Seller> findByDepartment(Department department);/*Define a assinatura para encontrar todos os vendedores 
	associadosa um departamento específico.*/

}
