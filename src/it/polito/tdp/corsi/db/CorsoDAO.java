package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.gestorecorsi.model.Corso;

public class CorsoDAO {

	public List<Corso> listCorsiByPD(int periodo) {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM corso WHERE pd= ?";
		List<Corso> result = new LinkedList<Corso>();
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				Corso c = new Corso(rs.getString("codins"),rs.getInt("crediti"),rs.getString("nome"),rs.getInt("pd"));
				result.add(c);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}