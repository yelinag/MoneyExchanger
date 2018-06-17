package service;

import entity.EnumClienType;
import entity.MarkupEntity;

import java.util.*;

public class MarkupService {

    private static MarkupService singleton;

    private List<MarkupEntity> individualMarkups;
    private List<MarkupEntity> corporateMarkups;

    public MarkupService() {
        individualMarkups = new ArrayList<>();
        individualMarkups.add(new MarkupEntity(8000, 40));
        individualMarkups.add(new MarkupEntity(20000, 35));
        individualMarkups.add(new MarkupEntity(35000, 30));
        individualMarkups.add(new MarkupEntity(Double.MAX_VALUE, 25));

        corporateMarkups = new ArrayList<>();
        corporateMarkups.add(new MarkupEntity(1000000, 15));
        corporateMarkups.add(new MarkupEntity(3000000, 10));
        corporateMarkups.add(new MarkupEntity(Double.MAX_VALUE, 5));
    }

    public static MarkupService getInstance(){
        if(singleton==null)
            singleton = new MarkupService();
        return singleton;
    }

    public int getMarkUp(EnumClienType clientType, double moneyToChange){
        if(EnumClienType.INDIVIDUAL.equals(clientType)) {
            Iterator<MarkupEntity> iterator = individualMarkups.iterator();
            while(iterator.hasNext()){
                MarkupEntity entity = iterator.next();
                if(moneyToChange <= entity.getAmount())
                    return entity.getMarkup();
            }
        }else{
            Iterator<MarkupEntity> iterator = corporateMarkups.iterator();
            while(iterator.hasNext()){
                MarkupEntity entity = iterator.next();
                if(moneyToChange <= entity.getAmount())
                    return entity.getMarkup();
            }
        }
        throw new IllegalArgumentException("Invalid markup setup");
    }

}
