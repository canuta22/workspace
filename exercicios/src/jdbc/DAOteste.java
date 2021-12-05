package jdbc;

public class DAOteste {
	public static void main(String[] args) {

		DAO dao = new DAO();
		
		String sql = "INSERT INTO pessoas (nome, codigo) VALUES (?, ?)";
		System.out.println(dao.incluir(sql,"João da Silva", 1000));
		System.out.println(dao.incluir(sql,"Ana júlia", 1001));
		System.out.println(dao.incluir(sql,"Djalma Pereira", 1002));
		
		dao.close();
	}
}
