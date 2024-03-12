package pl.patrykkawula.servicesupply.cartproduct;

import org.springframework.stereotype.Service;
import pl.patrykkawula.servicesupply.cartproduct.dtos.CartProductViewDto;

@Service
class CartProductDtoMapper {
    CartProductViewDto mapToCartProductViewDto(CartProduct cartProduct) {
        return CartProductViewDto.builder()
                .id(cartProduct.getId())
                .productDetailsName(String.format(cartProduct.getProductDetails().getBrandName() + " " + cartProduct.getProductDetails().getName()))
                .productQuantity(cartProduct.getProductQuantity())
                .build();
    }
}
