package meGusta;

public class Usuario {
	private int id;
	private String nome;
	private String sobrenome;
	private int idade;
	private long telefone;
	private String condicaoSaude;
	private String email;
	private String senha;
	private String user;
	private char genero;
	
	public Usuario() {
		super();
	}
	public Usuario(int id, String nome, String sobrenome, int idade, char genero, long telefone, String condicaoSaude, String email, String senha,
			String user) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.telefone = telefone;
		this.condicaoSaude = condicaoSaude;
		this.email = email;
		this.senha = senha;
		this.user = user;
		this.genero = genero;
	}
	//getters
	public String getCondicaoSaude() {
		return condicaoSaude;
	}
	public int getIdade() {
		return idade;
	}
	public int getId() {
		return id;
	}
	public long getTelefone() {
		return telefone;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public String getUsuario() {
		return user;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public String getNome() {
		return nome;
	}
	public char getGenero() {
		return genero;
	}
	
	//setters
	public void setCodicaoSaude(String condicaoSaude) {
		this.condicaoSaude = condicaoSaude;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}

