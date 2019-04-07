/*Fazer um programa para ler os dados (nome, email e sal�rio)
de funcion�rios a partir de um arquivo em formato .csv.
Em seguida mostrar, em ordem alfab�tica, o email dos
funcion�rios cujo sal�rio seja superior a um dado valor
fornecido pelo usu�rio.
Mostrar tamb�m a soma dos sal�rios dos funcion�rios cujo
nome come�a com a letra 'M'.*/

package entidades15;

public class Funcionario {
	
	private String nome;
	private String email;
	private Double salario;
	
	public Funcionario (String nome, String email, Double salario) {
		this.nome = nome;
		this.email = email;
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

}
