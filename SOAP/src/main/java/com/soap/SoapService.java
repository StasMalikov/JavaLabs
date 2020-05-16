package com.soap;

import com.entity.Human;
import com.entity.Repository;
import services.all.*;

import java.util.ArrayList;
import java.util.List;

public class SoapService implements com.soap.SoapServiceSkeletonInterface {

    public GetHumansByAgeResponseDocument getHumansByAge(GetHumansByAgeDocument getHumansByAge) {
        int age = getHumansByAge.getGetHumansByAge().getAge();

        List<services.all.Human> humans = new ArrayList<>();
        Repository repository = new Repository();
        services.all.Repository list = services.all.Repository.Factory.newInstance();
        List<Human> humansList = repository.searchByAge(age);

        for(Human human : humansList)
        {
            services.all.Human humanInst = services.all.Human.Factory.newInstance();
            humanInst.setHumanId(human.getId());
            humanInst.setAge(human.getAge());
            humanInst.setName(human.getName());
            humans.add(humanInst);
        }

        list.setHumanArray((services.all.Human[])humans.toArray());
        GetHumansByAgeResponseDocument humansResponseDocument = GetHumansByAgeResponseDocument.Factory.newInstance();
        GetHumansByAgeResponseDocument.GetHumansByAgeResponse humansResponse = GetHumansByAgeResponseDocument.GetHumansByAgeResponse.Factory.newInstance();
        humansResponse.setReturn(list);
        humansResponseDocument.setGetHumansByAgeResponse(humansResponse);
        return humansResponseDocument;
    }

    public GetHumanResponseDocument getHuman(GetHumanDocument getHuman) {
        int id = getHuman.getGetHuman().getHumanId();

        Repository repository = new Repository();

        services.all.Human human1 = services.all.Human.Factory.newInstance();
        Human human2 = repository.searchById(id);

        if(human2 == null)
            return null;

        human1.setAge(human2.getAge());
        human1.setName(human2.getName());

        GetHumanResponseDocument humanResponseDocument = GetHumanResponseDocument.Factory.newInstance();
        GetHumanResponseDocument.GetHumanResponse humanResponse = GetHumanResponseDocument.GetHumanResponse.Factory.newInstance();
        humanResponse.setReturn(human1);
        humanResponseDocument.setGetHumanResponse(humanResponse);

        return humanResponseDocument;
    }
}
