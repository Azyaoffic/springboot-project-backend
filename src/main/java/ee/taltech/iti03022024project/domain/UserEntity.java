package ee.taltech.iti03022024project.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;
import java.util.List;

@Schema(hidden = true)
@ToString
@Getter @Setter
@Entity(name = "users")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String location;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @SuppressWarnings("java:S1948")
    private RoleEntity role;

    @ManyToOne
    @JoinColumn(name = "unfinished_order", referencedColumnName = "order_id")
    @SuppressWarnings("java:S1948")
    private OrderEntity unfinishedOrder;

    @CreationTimestamp
    private Instant createdAt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
    }

    @Override
    public String getUsername() {
        return email;
    }
}
