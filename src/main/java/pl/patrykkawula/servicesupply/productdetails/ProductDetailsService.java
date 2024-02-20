package pl.patrykkawula.servicesupply.productdetails;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.brand.Brand;
import pl.patrykkawula.servicesupply.brand.BrandService;
import pl.patrykkawula.servicesupply.exception.ProductDetailsNotFoundException;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsDto;
import pl.patrykkawula.servicesupply.productdetails.dtos.ProductDetailsSaveDto;

import java.util.List;

@Service
class ProductDetailsService {
    private final ProductDetailsRepository productDetailsRepository;
    private final ProductDetailsDtoMapper productDetailsDtoMapper;
    private final BrandService brandService;

    ProductDetailsService(ProductDetailsRepository productDetailsRepository, ProductDetailsDtoMapper productDetailsDtoMapper, BrandService brandService) {
        this.productDetailsRepository = productDetailsRepository;
        this.productDetailsDtoMapper = productDetailsDtoMapper;
        this.brandService = brandService;
    }

    List<ProductDetailsDto> findAllProductsDetails() {
        return productDetailsRepository.findAll()
                .stream()
                .map(productDetailsDtoMapper::mapToProductDetailsDto)
                .toList();
    }
    //FIXME ogólnie te findAll() będą musiały poznikać w więszkosci później. Teraz jak masz 10 rekordów to spoko, ale jak zrobi sie 100 to może byc nieczytelne na froncie. ale to pozniej mozna zrobic
    //będzie robiona paginacja, narazie zostawiam

    void saveProductDetails(ProductDetailsSaveDto productDetailsSaveDto){
        Brand brand = brandService.findByName(productDetailsSaveDto.brand());
        productDetailsRepository.save(productDetailsDtoMapper.map(productDetailsSaveDto, brand));
    }

    ProductDetailsSaveDto findProductDetailsById(Long id) {
       return productDetailsRepository.findById(id).
               map(productDetailsDtoMapper::mapToProductDetailsSaveDto).
               orElseThrow(() -> new ProductDetailsNotFoundException(id));
    }

    void deleteProductDetailsById(Long id) {
        productDetailsRepository.deleteById(id);
    }
}
