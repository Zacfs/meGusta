package meGusta;
import static spark.Spark.port;
import static spark.Spark.post;
public class Aplicacao {
		
		private static usuarioService usuarioService = new usuarioService();
		
	    public static void main(String[] args) {
	        port(6789);
	        //Requisição para registrar usuário
	        post("/usuario/insert", (request, response) -> usuarioService.inserirUsuario(request, response));
}
}
