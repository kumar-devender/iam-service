package info.pragmaticdeveloper.iam.service;

import info.pragmaticdeveloper.iam.domain.user.*;
import info.pragmaticdeveloper.iam.dto.UserRegistrationDTO;
import info.pragmaticdeveloper.iam.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@Component
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CredentialRepository credentialRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    @Transactional
    public UserRegistrationDTO createUser(UserRegistrationDTO registrationDTO) {
        Member member = new Member();
        member.setEmail(registrationDTO.getEmail());
        member.setFirstName(registrationDTO.getFistName());
        member.setLastName(registrationDTO.getLastName());
        member.setUserType(registrationDTO.getUserType());
        userRepository.save(member);

        List<Role> roles = roleRepository.findAll();
        Collection<Permission> permissions = roles.get(0).getPermissions();
        System.out.println(permissions);

        // Role role = roleRepository.findByName(registrationDTO.getUserType().name());

        Credential credential = new Credential();
        credential.setEnabled(true);
        credential.setPassword("Password");
        credential.setUserId(member.getId());
        //credential.setRoles(singletonList(role));
        credentialRepository.save(credential);
        return registrationDTO;
    }

}
