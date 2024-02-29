package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import gui.listeners.DataChangeListener;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.exceptions.ValidationException;
import model.services.DepartmentService;

public class DepartmentFormController implements Initializable {
	
	private Department entity;
	
	private DepartmentService service;
	
	private List<DataChangeListener> dataChangeListeners = new ArrayList<>();
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	public void setDepartment(Department entity) {
		this.entity = entity;
	}
	
	public void setDepartmentService(DepartmentService service) {
		this.service = service;
	}
	
	/*Esse método é chamado quando o botão "Salvar" é pressionado. Ele coleta os dados do formulário,
	 *  tenta salvar ou atualizar a entidade e notifica os ouvintes sobre mudanças de dados.*/
	@FXML
	public void onBtSaveAction(ActionEvent event) {
		if(entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		
		if (service == null) {
			throw new IllegalStateException("Service was null");
		}
		try {
			entity = getFormData();
			service.saveOrUpdate(entity);
			notifyDataChangeListeners();
			Utils.currentStage(event).close();
		} 
		catch (ValidationException e) {
			setErrorMessages(e.getErrors());
		}
		catch (Exception e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
	private void notifyDataChangeListeners() {
		for (DataChangeListener listener : dataChangeListeners) {
			listener.onDataChanged();
		}
		
	}

	//Esse método recupera os dados do formulário e os valida. Ele também lida com exceções de validação.
	private Department getFormData() {
		Department obj = new Department();
		
		ValidationException exception = new ValidationException("Validation error");
        
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		
		if(txtName.getText() == null || txtName.getText().trim().equals("")) {
			exception.addError("name", "Field cant't be empty"); 
			}
		obj.setName(txtName.getText());
		
		if(exception.getErrors().size() > 0) {
			throw exception;
		}
		
		return obj;
		}
	
	/* Este método permite que outros componentes se inscrevam para receber notificações sobre mudanças 
	 de dados. Ele adiciona um ouvinte à lista dataChangeListeners.*/
	public void subscribeDataChangeListener(DataChangeListener listener) {
		dataChangeListeners.add(listener);
	}

    /*Esse método é chamado quando o botão "Cancelar" é pressionado. Ele fecha a janela atual obtendo a 
     * referência da janela usando a classe Utils.*/
	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {	
		initializeNodes();
	}
	
	/* Este método configura algumas restrições nos nós da interface gráfica. Em particular, ele define que
	 *  txtId deve aceitar apenas números inteiros e que txtName deve ter no máximo 30 caracteres.*/
	public void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtName, 30);
	}
	
	/* Este método atualiza os campos do formulário com os dados da entidade Department. Ele verifica se a entidade
     *não é nula antes de realizar a atualização.*/
	public void updateFormDate() {
		if (entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	}
	
	/* Este método exibe mensagens de erro no formulário com base em um mapa de erros. No caso, se houver um erro
	 *  no campo "name", ele exibirá a mensagem correspondente no rótulo labelErrorName.*/
	private void setErrorMessages(Map<String, String> errors) {
		Set<String> fields = errors.keySet();
		
		if(fields.contains("name")) {
			labelErrorName.setText(errors.get("name"));
		}
	}

}
