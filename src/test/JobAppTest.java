import entity.JobApp;
import entity.Candidat;
import entity.CandidatJobApp; // Assuming CandidatJobApp is the entity representing the application link
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.impl.JobAppRepositoryImpl;
import service.impl.JobAppServiceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JobAppTest {

    @Mock
    private JobAppRepositoryImpl jobAppRepository;

    @InjectMocks
    private JobAppServiceImpl jobAppService;

    private JobApp jobApp;
    private Candidat candidat;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        jobApp = new JobApp();
        jobApp.setId(UUID.randomUUID());
        jobApp.setSkills("java");

        candidat = new Candidat();
        candidat.setId(UUID.randomUUID());
        candidat.setName("John Doe");
        // Set other fields as necessary
    }

    @Test
    void testCreate() {
        jobAppService.create(jobApp);
        verify(jobAppRepository, times(1)).save(jobApp);
    }

    @Test
    void testUpdate() {
        jobAppService.update(jobApp);
        verify(jobAppRepository, times(1)).update(jobApp);
    }

    @Test
    void testFindAll() {
        List<JobApp> jobApps = Arrays.asList(jobApp);
        when(jobAppRepository.findAll()).thenReturn(jobApps);

        List<JobApp> result = jobAppService.findAll();
        assertEquals(1, result.size());
        assertEquals(jobApp, result.get(0));
    }

    @Test
    void testFindById() {
        when(jobAppRepository.findById(jobApp.getId())).thenReturn(Optional.of(jobApp));

        JobApp result = jobAppService.findById(jobApp.getId());
        assertNotNull(result);
        assertEquals(jobApp.getId(), result.getId());
    }

    @Test
    void testDelete() {
        when(jobAppRepository.findById(jobApp.getId())).thenReturn(Optional.of(jobApp));

        jobAppService.delete(jobApp.getId());
        verify(jobAppRepository, times(1)).delete(jobApp);
    }

    @Test
    void testFilterJobAppBySkills() {
        List<JobApp> jobApps = Arrays.asList(jobApp);
        when(jobAppRepository.filterJobAppBySkills("java")).thenReturn(jobApps);

        List<JobApp> result = jobAppService.filterJobAppBySkills("java");
        assertEquals(1, result.size());
        assertEquals("java", result.get(0).getSkills());
    }

}
