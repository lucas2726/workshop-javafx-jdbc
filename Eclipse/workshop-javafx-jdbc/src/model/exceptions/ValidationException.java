package model.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends RuntimeException {

	/*
	 * Este campo é usado para versionamento do objeto, garantindo consistência ao
	 * serializar e desserializar instâncias da classe.
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Uma variável de instância errors é declarada como um Map<String, String> para
	 * armazenar mensagens de erro específicas do campo. É inicializada como um novo
	 * HashMap.
	 */
	private Map<String, String> errors = new HashMap<>();

	/*
	 * O construtor recebe um parâmetro String msg e chama o construtor da
	 * superclasse (RuntimeException) com esta mensagem.
	 */
	public ValidationException(String msg) {
		super(msg);
	}

	// Um método getter getErrors() é fornecido para recuperar o mapa de errors.
	public Map<String, String> getErrors() {
		return errors;
	}

	/*
	 * Este método (addError()) permite adicionar erros específicos do campo ao mapa
	 * errors. Ele recebe um nome de campo e uma mensagem de erro, e os coloca no
	 * mapa.
	 */
	public void addError(String fieldName, String errorMessage) {
		errors.put(fieldName, errorMessage);
	}

	/*
	 * Em resumo, esta classe é projetada para representar uma exceção personalizada
	 * para erros de validação. Permite armazenar e recuperar mensagens de erro
	 * específicas do campo em um mapa. Instâncias desta classe podem ser lançadas
	 * quando ocorrem problemas de validação, fornecendo detalhes
	 * adicionais sobre os erros.
	 */
}
