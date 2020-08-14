package org.duckdns.owly.quarkus_11368;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Transactional
@ApplicationScoped
public class SomethingRepo implements PanacheRepository<Something> {
    @Inject
    EntityManager entityManager;

    public Something getDelRevisionOf(long id) {
        return (Something) AuditReaderFactory.get(entityManager)
                .createQuery()
                .forRevisionsOfEntity(Something.class, true, true)
                .add(AuditEntity.id().eq(id))
                .add(AuditEntity.revisionType().eq(RevisionType.DEL))
                .getSingleResult();
    }
}
