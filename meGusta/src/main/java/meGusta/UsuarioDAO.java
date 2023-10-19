package meGusta;

import java.sql.*;

import spark.Request;
import spark.Response;

public class UsuarioDAO extends DAO {
	public UsuarioDAO() {
		super();
		conectar();
	}
	//Criação do usuário no BD
    public boolean inserirUsuario(Usuario usuario) {
        boolean status = false;
        try {
            PreparedStatement ps = conexao.prepareStatement("INSERT INTO \"public\".\"Usuario\" (id, nome, sobrenome, usuario, email, idade, genero, cs, senha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, usuario.getId());
            ps.setString(2, usuario.getNome() != null ? usuario.getNome() : "");
            ps.setString(3, usuario.getSobrenome() != null ? usuario.getSobrenome() : "");
            ps.setString(4, usuario.getUsuario() != null ? usuario.getUsuario() : "");
            ps.setString(5, usuario.getEmail() != null ? usuario.getEmail() : "");
            //ps.setBytes(6, usuario.getProfilePic() != null ? usuario.getProfilePic() : new byte[0]);
            ps.setInt(6, usuario.getIdade() > 0 ? usuario.getIdade() : 0);
            ps.setString(7, String.valueOf(usuario.getGenero()));
            // Converte array de String para ARRAY do PostgreSQL
            // Array condicaoSaudeArray = conexao.createArrayOf("character varying", usuario.getCondicaoSaude());
            ps.setString(8, usuario.getCondicaoSaude());
            ps.setString(9, usuario.getSenha() != null ? toMD5(usuario.getSenha()) : "");
            ps.executeUpdate();
            ps.close();
            status = true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return status;
    }
}
