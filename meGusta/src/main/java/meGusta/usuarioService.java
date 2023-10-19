package meGusta;
import spark.Request;
import spark.Response;
import java.io.File;
import java.util.Scanner;
import meGusta.DAO;
import meGusta.Usuario;
import java.nio.file.*;
public class usuarioService {
	private UsuarioDAO dao = new UsuarioDAO();
	private String form;
	private final int FORM_INSERT = 1;
	private final int FORM_DETAIL = 2;
	private final int FORM_UPDATE = 3;
	private final int FORM_ORDERBY_ID = 1;
	private final int FORM_ORDERBY_NOME = 2;
	private final int FORM_ORDERBY_PRECO = 3;
	public usuarioService() {
		makeForm();
	}

	
	public void makeForm() {
		makeForm(FORM_INSERT, new Usuario(), FORM_ORDERBY_NOME);
	}
	public void makeForm(int tipo, Usuario produto, int orderBy) {
		Path currentRelativePath = Paths.get("");
		String nomeArquivo = currentRelativePath.toAbsolutePath().toString() +"\\html\\registro.html";
		form = "";
		System.out.println(nomeArquivo);
		try{
			Scanner entrada = new Scanner(new File(nomeArquivo));
		    while(entrada.hasNext()){
		    	form += (entrada.nextLine() + "\n");
		    }
		    entrada.close();
		}  catch (Exception e) { System.out.println(e.getMessage()); }
	}
	//Coletar dados dos formulários e enviar para DAO
	public Object inserirUsuario(Request request, Response response) {
		System.out.println("cheguei");
		int id = Integer.parseInt(request.queryParams("id"));
		String nome = request.queryParams("nome");
		String sobrenome = request.queryParams("sobrenome");
		int  idade = Integer.parseInt(request.queryParams("idade"));
		long telefone = Long.parseLong(request.queryParams("telefone"));
		String condicaoSaude = request.queryParams("condicaoSaude");
		String email = request.queryParams("email");
		String senha = request.queryParams("senha");
		String user = request.queryParams("user");
		char genero = request.queryParams("genero").charAt(0);
		String resp = "";
		Usuario produto = new Usuario( id,  nome, sobrenome,  idade,  genero, telefone, condicaoSaude,  email,  senha, user);
		if(dao.inserirUsuario(produto) == true) {
            resp = "Usuario (" + nome + ") inserido!";
            response.status(201); // 201 Created
		} else {
			resp = "Usuario (" + nome + ") não inserido!";
			response.status(404); // 404 Not found
		}
			
		makeForm();
		return form.replaceFirst("<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\"\">", "<input type=\"hidden\" id=\"msg\" name=\"msg\" value=\""+ resp +"\">");
	}
}
