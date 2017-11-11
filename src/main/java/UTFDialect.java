import org.hibernate.dialect.MySQL5Dialect;

public class UTFDialect extends MySQL5Dialect {
    @Override
    public String getTableTypeString() {
        return " DEFAULT CHARSET=utf8";
    }
}
