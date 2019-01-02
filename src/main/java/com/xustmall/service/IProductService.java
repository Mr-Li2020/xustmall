package com.xustmall.service;

import com.xustmall.common.ServerResponse;
import com.xustmall.pojo.Product;

public interface IProductService {
    ServerResponse saveOrUpdateProduct(Product product);

    ServerResponse<String> setSaleStatus(Integer productId, Integer status);
}
