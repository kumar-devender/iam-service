package info.pragmaticdeveloper.iam

import info.pragmaticdeveloper.iam.annotation.ControllerIntegrationTest
import info.pragmaticdeveloper.iam.domain.user.Credential
import info.pragmaticdeveloper.iam.domain.user.Member
import info.pragmaticdeveloper.iam.dto.UserRegistrationDTO
import info.pragmaticdeveloper.iam.dto.UserType
import info.pragmaticdeveloper.iam.repository.CredentialRepository
import info.pragmaticdeveloper.iam.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.jdbc.Sql

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD

@ControllerIntegrationTest
@Sql(executionPhase = BEFORE_TEST_METHOD, value = "/sql/truncate-all-data.sql")
class UserControllerIntegrationTest extends IntegrationTestSpecification {

    @Autowired
    private UserRepository userRepository

    @Autowired
    private CredentialRepository credentialRepository

    private static final String RESOURCE_BASE_PATH = 'api/v1/users'

    def 'register user should successful'() {
        //@formatter:off
        given:
        def registrationDTO = buildRegistrationDTO()
        when:
        def response = this.getEndpoint()
            .headers(buildHeaders())
            .body(registrationDTO)
            .post(RESOURCE_BASE_PATH)
            .prettyPeek()
        then:
        response.then()
            .statusCode(CREATED.value())
        //@formatter:on

        List<Member> users = userRepository.findAll()
        users.size() == 1
        users.get(0).getEmail() == registrationDTO.getEmail()

        Credential credential = credentialRepository.findByUserId(users.get(0).getId())
        credential != null
    }

    private static UserRegistrationDTO buildRegistrationDTO() {
        UserRegistrationDTO dto = new UserRegistrationDTO()
        dto.setEmail("anyemail@gmail.com")
        dto.setLastName("last")
        dto.setFistName("fist")
        dto.setPassword("anypass")
        dto.setUserType(UserType.CUSTOMER)
        return dto
    }
}
