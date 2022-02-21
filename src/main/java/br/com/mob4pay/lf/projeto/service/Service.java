package br.com.mob4pay.lf.projeto.service;

import br.com.mob4pay.lf.projeto.base.Model;
import br.com.mob4pay.lf.projeto.base.ModelDto;
import br.com.mob4pay.lf.projeto.exceptions.ObjectNotFoundException;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

public abstract class Service<D extends Model<R>, R extends ModelDto<D>>
{
    protected abstract MongoRepository<D, String> getRepository();

    protected Collection<R> getAll()
    {
        Collection<R> allRest = new HashSet<>();
        Iterable<D> findAll = getRepository().findAll();
        findAll.forEach(d -> allRest.add(d.modelToDto()));

        return allRest;
    }

    protected R getById(String id)
    {
        Optional<D> entity = getRepository().findById(id);

        D object = entity.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));

        return object.modelToDto();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    protected R create(R object)
    {
        D entity = object.dtoToModel();
        entity = getRepository().save(entity);

        return entity.modelToDto();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    protected R update(R object)
    {
        D entity = object.dtoToModel();
        entity = (D) getRepository().save(entity);

        return entity.modelToDto();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    protected String delete(String id)
    {
        Optional<D> findById = getRepository().findById(id);
        D d = findById.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        getRepository().delete(d);
        return id;
    }
}
