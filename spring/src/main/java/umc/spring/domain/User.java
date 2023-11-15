package umc.spring.domain;

import lombok.*;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(7) DEFAULT 'UNKNOWN'")
    private Gender gender;

    private LocalDate birth;

    @Column(nullable = false, length = 45)
    private String address;

    private Integer point;

    @Column(nullable = true, length = 45)
    private String email;

    @Column(nullable = true, length = 11)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prefer_id")
    private Prefer prefer;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MyMission> myMissionList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Inquiry> inquiryList = new ArrayList<>();

}
