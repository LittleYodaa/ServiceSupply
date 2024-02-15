package pl.patrykkawula.servicesupply.picture;

import org.springframework.stereotype.Repository;
import pl.patrykkawula.servicesupply.exception.PictureNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PictureRepository {
    private final Map<String, Picture> pictures = new HashMap<>();

    PictureRepository() {
        //FIXME to by chyba można automatycznie żeby wczytało wszystkie pliki z danego katalogu
        //FIXME można coś takiego zrobić ale robi się problem w przechowywaniu w mapie, a to jest wygodne
        //FIXME myślałem, żeby jakoś wyodrębniać z nazwy pliku nazwe dostawcy ale nie ma gwarancji, że ktoś tak samo by zapisywał pliki po nazwach
        //FIXME ostatecznie zostawiłem jak jest tylko obsłużyłem błąd
        Picture wintersteiger = new Picture("WINTERSTEIGER", "wintersteiger.png");
        Picture berner = new Picture("BERNER", "berner.png");
        Picture fourSerwis = new Picture("4SERWIS", "4serwis.png");
        Picture btwin = new Picture("BTWIN", "btwin.png");
        Picture externalDistribution = new Picture("DYSTRYBUCJA ZEWNĘTRZNA", "external_distribution.png");
        pictures.put(wintersteiger.name(), wintersteiger);
        pictures.put(berner.name(), berner);
        pictures.put(fourSerwis.name(), fourSerwis);
        pictures.put(btwin.name(), btwin);
        pictures.put(externalDistribution.name(), externalDistribution);
    }

    public Picture findImageByName(String name) {
        Picture picture = pictures.get(name);
        if (picture != null)
            return picture;
        else {
            throw new PictureNotFoundException(name);
        }
    }
}
