package main.personEnv;

import main.injector.Injector;
import ru.vsu.lab.entities.IDivision;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.factory.ILabFactory;
import ru.vsu.lab.repository.IPersonRepository;
import ru.vsu.lab.repository.IRepository;

import java.lang.reflect.InvocationTargetException;

public class LabFactory implements ILabFactory {
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
    public <T> IRepository<T> createRepository(Class<T> clazz) {
        IRepository<T> repo = new Repository<>();
        try {
           return Injector.inject(repo);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /** @return  Factory method returning a new repository without generics */
    @Override
    public IPersonRepository createPersonRepository() {
        return null;
    }
}