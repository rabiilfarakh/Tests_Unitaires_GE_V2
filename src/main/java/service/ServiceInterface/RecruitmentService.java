package service.ServiceInterface;

import entity.Recruitment;

import java.util.List;
import java.util.UUID;

public interface RecruitmentService {

    void createRecruitment(Recruitment recruitment);

    void deleteRecruitment(UUID id);

    void updateRecruitment(Recruitment recruitment);

    List<Recruitment> getAllRecruitments();

    Recruitment getRecruitment(UUID id);

}
