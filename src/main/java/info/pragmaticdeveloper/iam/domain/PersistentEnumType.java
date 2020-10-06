package info.pragmaticdeveloper.iam.domain;

import com.vladmihalcea.hibernate.type.basic.PostgreSQLEnumType;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class PersistentEnumType extends PostgreSQLEnumType {

    @Override
    public Object nullSafeGet(final ResultSet rs, final String[] names, final SharedSessionContractImplementor session,
                              final Object owner) throws SQLException {
        return Optional
                .ofNullable(rs.getString(names[0]))
                .map(s -> Enum.valueOf(returnedClass(), s))
                .orElse(null);
    }
}
