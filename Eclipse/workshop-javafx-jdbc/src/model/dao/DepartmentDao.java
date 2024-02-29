package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	void insert(Department obj);//Define a assinatura para inserir um objeto Department no banco de dados
	void update(Department obj);//Define a assinatura para atualizar um objeto Department no banco de dados.
	void deleteById(Integer id);// Define a assinatura para excluir um departamento do banco de dados com base no ID.
	Department findById(Integer id);//Define a assinatura para encontrar um departamento no banco de dados com base no ID. 
	List<Department> findAll();//Define a assinatura para encontrar todos os departamentos no banco de dados.

}
