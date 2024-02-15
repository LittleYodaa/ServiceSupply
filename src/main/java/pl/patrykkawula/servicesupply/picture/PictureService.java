package pl.patrykkawula.servicesupply.picture;

import org.springframework.stereotype.Service;

@Service
public class PictureService {
    private final PictureRepository pictureRepository;

    PictureService(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public Picture findProductImage(String brand) {
        return pictureRepository.findImageByName(brand);
    }

}
