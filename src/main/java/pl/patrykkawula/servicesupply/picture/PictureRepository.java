package pl.patrykkawula.servicesupply.picture;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PictureRepository {
    private final Map<String, Picture> pictures = new HashMap<>();
    PictureRepository() {
        Picture wintersteiger = new Picture("WINTERSTEIGER", "wintersteiger.png");
        Picture berner = new Picture("BERNER", "berner.png");
        Picture fourSerwis = new Picture("4SERWIS", "4serwis.png");
        Picture btwin = new Picture("BTWIN", "btwin.png");
        Picture externalDistribution = new Picture("DYSTRYBUCJA ZEWNĘTRZNA", "external_distribution.png");
        pictures.put(wintersteiger.getName(), wintersteiger);
        pictures.put(berner.getName(), berner);
        pictures.put(fourSerwis.getName(), fourSerwis);
        pictures.put(btwin.getName(), btwin);
        pictures.put(externalDistribution.getName(), externalDistribution);
    }

    public Picture findImageByName(String name) {
        return pictures.get(name);
    }


}
