package info.pragmaticdeveloper.iam.service;

import info.pragmaticdeveloper.iam.domain.user.Credential;
import info.pragmaticdeveloper.iam.domain.user.Member;
import info.pragmaticdeveloper.iam.dto.UserRegistrationDTO;
import info.pragmaticdeveloper.iam.repository.CredentialRepository;
import info.pragmaticdeveloper.iam.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CredentialRepository credentialRepository;

    @Transactional
    public UserRegistrationDTO createUser(UserRegistrationDTO registrationDTO) {
        Member member = new Member();
        member.setEmail(registrationDTO.getEmail());
        member.setFirstName(registrationDTO.getFistName());
        member.setLastName(registrationDTO.getLastName());
        member.setUserType(registrationDTO.getUserType());
        userRepository.save(member);

        Credential credential = new Credential();
        credential.setEnabled(true);
        credential.setPassword("Password");
        credential.setUserId(member.getId());
        credentialRepository.save(credential);
        return registrationDTO;
    }

}
