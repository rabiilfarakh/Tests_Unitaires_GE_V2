
import entity.Candidat;
import entity.JobApp;
import entity.CandidatJobApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.CandidatJobAppRepository;
import service.impl.CandidatServiceImpl;
import org.mockito.ArgumentCaptor;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CandidatJobApplyTest {

    @InjectMocks
    private CandidatServiceImpl candidatService;

    @Mock
    private CandidatJobAppRepository candidatJobAppRepository;

    private Candidat candidat;
    private JobApp jobApp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        candidat = new Candidat();
        candidat.setId(UUID.randomUUID());
        candidat.setName("John Doe");

        jobApp = new JobApp();
        jobApp.setId(UUID.randomUUID());
        jobApp.setName("Software Engineer");
        jobApp.setSkills("Java, Spring Boot");
    }

    @Test
    void testApplyForJob() {

        CandidatJobApp expectedCandidatJobApp = new CandidatJobApp(candidat, jobApp);

        candidatService.applyForJob(candidat, jobApp);

        ArgumentCaptor<CandidatJobApp> captor = ArgumentCaptor.forClass(CandidatJobApp.class);
        verify(candidatJobAppRepository, times(1)).applyForJob(captor.capture());

        assertEquals(expectedCandidatJobApp.getCandidat().getId(), captor.getValue().getCandidat().getId());
        assertEquals(expectedCandidatJobApp.getJobApp().getId(), captor.getValue().getJobApp().getId());
    }
}
