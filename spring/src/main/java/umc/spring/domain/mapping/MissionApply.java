package umc.spring.domain.mapping;

import lombok.*;
import umc.spring.domain.Mission;
import umc.spring.domain.User;
import umc.spring.domain.common.BaseEntity;
import umc.spring.validation.annotation.DuplicatedMissionApply;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MissionApply extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float progress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user){
        if(this.user != null)
            user.getMissionApplyList().remove(this);
        this.user = user;
        user.getMissionApplyList().add(this);
    }

    public void setMission(Mission mission){
        if(this.mission != null)
            mission.getMissionApplyList().remove(this);
        this.mission = mission;
        mission.getMissionApplyList().add(this);
    }
}
