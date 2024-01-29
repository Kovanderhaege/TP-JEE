package junia.lab05.core.service;

import jakarta.transaction.Transactional;
import junia.lab05.core.dao.PhaseDAO;
import junia.lab05.core.entity.Phase;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PhaseService extends GenericService<Phase> {

    protected PhaseService(PhaseDAO internalDAO) {
        super(internalDAO);
    }
}
