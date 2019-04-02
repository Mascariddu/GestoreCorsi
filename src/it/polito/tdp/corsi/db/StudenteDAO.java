package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.gestorecorsi.model.Studente;

public class StudenteDAO {

	public List<Studente> elencaStudenti(String codins) {
		// TODO Auto-generated method stub
		String sql = "SELECT s.matricola, s.nome, s.cognome, s.CDS FROM studente as s, iscrizione as i WHERE i.matricola=s.matricola AND codins = ?";
		
		List<Studente> studenti = new ArrayList<Studente>();
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			st.setString(1, codins);
			
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				studenti.add(new Studente(rs.getInt("matricola"),rs.getString("nome"),rs.getString("cognome"),rs.getString("CDS")));
			}
			
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return studenti;
	}

	
}
