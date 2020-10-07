@TypeDefs({
        //@TypeDef(name = "PersistentLocalDateTime", typeClass = LocalDateTime.class, defaultForType = LocalDateTime.class),
        @TypeDef(name = "userType", typeClass = PersistentEnumType.class, defaultForType = UserType.class),
})
package info.pragmaticdeveloper.iam;

import info.pragmaticdeveloper.iam.domain.PersistentEnumType;
import info.pragmaticdeveloper.iam.dto.UserType;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
