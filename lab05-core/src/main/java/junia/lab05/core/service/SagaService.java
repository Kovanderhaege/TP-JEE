package junia.lab05.core.service;

import jakarta.transaction.Transactional;
import junia.lab05.core.dao.SagaDAO;
import junia.lab05.core.entity.Saga;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class SagaService extends GenericService<Saga> {

    private final SagaDAO sagaDAO;

    protected SagaService(SagaDAO sagaDAO) {
        super(sagaDAO);
        this.sagaDAO = sagaDAO;
    }

    public List<Saga> findAllWithPhasesAndMovies() {
        return sagaDAO.findAllWithPhasesAndMovies();
    }
}
