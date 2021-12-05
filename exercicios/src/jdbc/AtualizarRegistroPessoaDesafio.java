package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtualizarRegistroPessoaDesafio {

	public static void main(String[] args) throws SQLException {

		System.out.println("Informe o código da pessoa: ");
		
		Scanner entrada = new Scanner(System.in);
		Integer valor = entrada.nextInt();

		Connection conexao = FabricaConexao.getConexao();
		String sql = "SELECT * FROM pessoas where codigo like ?";

		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, valor);
		ResultSet rs = stmt.executeQuery();

		List<Pessoa> pessoas = new ArrayList<>();
		while (rs.next()) {
			int codigo = rs.getInt("codigo");
			String nome = rs.getString("nome");
			pessoas.add(new Pessoa(codigo, nome));

		}
		for (Pessoa p : pessoas) {
			String n1 = p.getNome();
			int c1 = p.getCodigo();
			System.out.println("Nome a ser atualizado: " + n1);
			System.out.println("Informe o novo nome: ");
			String novoNome = entrada.next();
			System.out.println(novoNome);
			
			String update = "UPDATE pessoas SET nome = ? where codigo = ? ";
			PreparedStatement stmt1 = conexao.prepareStatement(update);
			stmt1.setString(1, novoNome);
			stmt1.setInt(2, c1);
			stmt1.executeUpdate();
		}
			entrada.close();
			stmt.close();
			conexao.close();
	}
}
