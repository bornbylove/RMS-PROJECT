package com.org.RestaurantManagementSystem.pagination;

import com.org.RestaurantManagementSystem.dao.ProductDaoImplementation;
import com.org.RestaurantManagementSystem.model.OrderInfo;
import com.org.RestaurantManagementSystem.model.ProductInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("PagingAndSortingProducts")
public class PaginationResult<E> {
    private ProductDaoImplementation productDaoImplementation;
    @GetMapping("/page")
    public Page<ProductInfo> orderInfoPage(@PathVariable Integer pageNumber,
                                           @PathVariable Integer pageSize,
                                           @PathVariable String sortProperty){

        return productDaoImplementation.getListOfProducts(pageNumber, pageSize, sortProperty);
    }

}
