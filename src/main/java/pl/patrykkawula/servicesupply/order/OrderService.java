package pl.patrykkawula.servicesupply.order;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.cartproduct.CartProduct;
import pl.patrykkawula.servicesupply.cartproduct.CartProductDtoMapper;
import pl.patrykkawula.servicesupply.cartproduct.CartProductRepository;
import pl.patrykkawula.servicesupply.cartproduct.CartProductService;
import pl.patrykkawula.servicesupply.cartproduct.dtos.CartProductViewDto;

import java.util.List;

@Service
class OrderService {
    private final OrderRepository orderRepository;
    private final CartProductService cartProductService;
    private final CartProductDtoMapper cartProductDtoMapper;
    private final CartProductRepository cartProductRepository;

    OrderService(OrderRepository orderRepository, CartProductService cartProductService, CartProductDtoMapper cartProductDtoMapper, CartProductRepository cartProductRepository) {
        this.orderRepository = orderRepository;
        this.cartProductService = cartProductService;
        this.cartProductDtoMapper = cartProductDtoMapper;
        this.cartProductRepository = cartProductRepository;
    }


//    void createNewOrder() {
//        List<CartProduct> cartProducts = cartProductRepository.findAll();
//
//        cartProductRepository.deleteAll();
//    }
}
