package mx.org.coneval.util;

import java.sql.Types;

import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StandardBasicTypes;

public class SQLServer2008Dialect extends SQLServerDialect {

  public SQLServer2008Dialect() {
    super();

    this.registerColumnType(Types.CHAR, "nvarchar(1)");
    this.registerColumnType(Types.LONGVARCHAR, "nvarchar(max)");
    this.registerColumnType(Types.VARCHAR, 4000, "nvarchar($l)");
    this.registerColumnType(Types.VARCHAR, "nvarchar(max)");
    this.registerColumnType(Types.CLOB, "nvarchar(max)");
    this.registerColumnType(Types.NCHAR, "nchar(1)");
    this.registerColumnType(Types.LONGNVARCHAR, "nvarchar(max)");
    this.registerColumnType(Types.NVARCHAR, 4000, "nvarchar($l)");
    this.registerColumnType(Types.NVARCHAR, "nvarchar(max)");
    this.registerColumnType(Types.NCLOB, "nvarchar(max)");
    this.registerColumnType(Types.BOOLEAN, "boolean");
    this.registerColumnType(Types.BIT, "smallint");
    this.registerColumnType(Types.TINYINT, "smallint");
    this.registerColumnType(Types.SMALLINT, "smallint");
    this.registerColumnType(Types.INTEGER, "integer");
    this.registerColumnType(Types.BIGINT, "bigint");

    this.registerColumnType(Types.FLOAT, "smallfloat");
    this.registerColumnType(Types.REAL, "smallfloat");
    this.registerColumnType(Types.DOUBLE, "float");
    this.registerColumnType(Types.NUMERIC, "decimal"); // or MONEY
    this.registerColumnType(Types.DECIMAL, "decimal");

    this.registerHibernateType(Types.BOOLEAN, StandardBasicTypes.BOOLEAN.getName());
    this.registerHibernateType(Types.NVARCHAR, StandardBasicTypes.STRING.getName());
    this.registerHibernateType(Types.LONGVARCHAR, StandardBasicTypes.TEXT.getName());
    this.registerHibernateType(Types.DECIMAL, StandardBasicTypes.BIG_DECIMAL.getName());
    this.registerHibernateType(Types.CHAR, StandardBasicTypes.STRING.getName());
    this.registerHibernateType(Types.CHAR, 1, StandardBasicTypes.STRING.getName());
    this.registerHibernateType(Types.DOUBLE, 1, StandardBasicTypes.DOUBLE.getName());
    this.registerHibernateType(Types.FLOAT, 1, StandardBasicTypes.FLOAT.getName());

    registerFunction("cast", new SQLFunctionTemplate(StandardBasicTypes.STRING, "cast(?1 as varchar)"));
    registerFunction("substring", new SQLFunctionTemplate(StandardBasicTypes.STRING, "substring(?1, ?2, ?3)"));
    registerFunction("convert", new SQLFunctionTemplate(StandardBasicTypes.STRING, "convert(?1, ?2, ?3)"));

  }
}