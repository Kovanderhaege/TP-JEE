package junia.lab05.core.dao;

import junia.lab05.core.entity.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;


@NoRepositoryBean
public interface GenericDAO<T extends GenericEntity> extends JpaRepository<T, Long> {

}
