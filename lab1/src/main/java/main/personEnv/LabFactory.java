package main.personEnv;

import main.injector.Injector;
import org.apache.log4j.Logger;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.factory.ILabFactory;
import ru.vsu.lab.repository.IPersonRepository;
import ru.vsu.lab.repository.IRepository;

import java.lang.reflect.InvocationTargetException;

/**
 * Класс генератор.
 */
public class LabFactory implements ILabFactory {
    private static final Logger log = Logger.getLogger(LabFactory.class);

    /** @return Factory method returning a new person  */
    @Override
    public IPerson createPerson() {
        return new Person();
    }

    /** @return Factory method returning a new Division*/
    @Override
    public IDivision createDivision() {
        return new Division();
    }

    /** @return Factory method returning a new repository */
    @Override
    public <T> IRepository<T> createRepository(final Class<T> clazz) {
        IRepository<T> repo = new Repository<>();
        try {
           return Injector.inject(repo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("createRepository(final Class<T> clazz)");
        return null;
    }

    /** @return  Factory method returning a new repository without generics */
    @Override
    public IPersonRepository createPersonRepository() {
        log.info("createPersonRepository()");
        return null;
    }
}
