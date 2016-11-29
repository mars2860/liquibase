package liquibase.database.core;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import liquibase.CatalogAndSchema;
import liquibase.database.AbstractJdbcDatabase;
import liquibase.database.DatabaseConnection;
import liquibase.exception.DatabaseException;
import liquibase.structure.DatabaseObject;

public class MsAccessDatabase extends AbstractJdbcDatabase {

	public static final String PRODUCT_NAME = "ACCESS";
	private static SimpleDateFormat fmtDateTime = new SimpleDateFormat("#MM/dd/yyyy HH:mm:ss#");
	
	@Override
	public boolean isCorrectDatabaseImplementation(DatabaseConnection conn) throws DatabaseException {
		return PRODUCT_NAME.equalsIgnoreCase(conn.getDatabaseProductName());
	}

	@Override
	public String getDefaultDriver(String url) {
		if (url.startsWith("jdbc:odbc:")) {
            return "sun.jdbc.odbc.JdbcOdbcDriver";
        }
        return null;
	}

	@Override
	public String getShortName() {
		return "access";
	}

	@Override
	public Integer getDefaultPort() {
		return null;
	}

	@Override
	public int getPriority() {
		return PRIORITY_DEFAULT;
	}

	@Override
	protected String getDefaultDatabaseProductName() {
		return PRODUCT_NAME;
	}
	
	@Override
	public int getDatabaseMajorVersion() throws DatabaseException {
		// this method is not supported by jdbc-odbc driver, always return 1
		return 1;
	}
	
	@Override
	public int getDatabaseMinorVersion() throws DatabaseException {
		// this method is not supported by jdbc-odbc driver, always return 1
		return 1;
	}
	
	@Override
	public String getDefaultCatalogName() {
		return null;
	}
	
	@Override
	public String getDefaultSchemaName() {
		return null;
	}
	
	@Override
	public CatalogAndSchema getDefaultSchema() {
		return null;
	}
	
	@Override
	public String getLiquibaseSchemaName() {
		return null;
	}
	
	@Override
	public String getLiquibaseCatalogName() {
		return null;
	}
	
	@Override
	public Integer getFetchSize() {
		return 0;
	}

	@Override
	public boolean supportsSchemas() {
		return false;
	}
	
	@Override
	public boolean supportsCatalogs() {
		return false;
	}
	
	@Override
	public boolean supportsAutoIncrement() {
		return false;
	}
	
	@Override
	public boolean supportsCatalogInObjectName(Class<? extends DatabaseObject> type) {
		return false;
	}
	
	@Override
	public boolean supportsDDLInTransaction() {
		return false;
	}
	
	@Override
	public boolean supportsInitiallyDeferrableColumns() {
		return false;
	}

	@Override
	public boolean supportsTablespaces() {
		return false;
	}

	@Override
	public boolean supportsSequences() {
		return false;
	}
	
	@Override
	public boolean jdbcCallsCatalogsSchemas() {
		return false;
	}
	
	@Override
	public String getDateLiteral(Date date) {
		
		return fmtDateTime.format(date);
	}
	
	@Override
	public String getCurrentDateTimeFunction() {
		return "Now()";
	}
	
	@Override
	public String getDateTimeLiteral(Timestamp date) {
		return fmtDateTime.format(new Date(date.getTime()));
	}
}
