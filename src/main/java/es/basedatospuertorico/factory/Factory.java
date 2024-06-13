package es.basedatospuertorico.factory;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Factory {
	
	private DataSource source;
	
	public Factory(){
		var poolDataSource= new ComboPooledDataSource();
		poolDataSource.setJdbcUrl("jdbc:mysql://localhost/movisun_pr?useTimeZone=true&serverTimeZone=UTC");
		poolDataSource.setUser("root");
		poolDataSource.setPassword("Escorpions6");
		poolDataSource.setMaxPoolSize(6);
		
		this.source= poolDataSource;
	}
	
	public Connection recuperaConexion() {
		
		try {
			
			return this.source.getConnection();
		}catch(SQLException e) {
			throw new RuntimeException(e);
	   }}
}