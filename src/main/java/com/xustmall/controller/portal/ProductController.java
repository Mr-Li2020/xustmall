package com.xustmall.controller.portal;

import com.github.pagehelper.PageInfo;
import com.xustmall.common.ServerResponse;
import com.xustmall.service.IProductService;
import com.xustmall.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/product/")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<ProductDetailVo> getDetail(Integer productId){
        return iProductService.getProductDetail(productId);
    }

    /**
     * value = "keyword",required = false  -->在搜索的时候可以不传关键字
     * @param keyword
     * @return
     */
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> getList(@RequestParam(value = "keyword",required = false)String keyword,
                                            @RequestParam(value = "categoryId",required = false)Integer categoryId,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageNum", defaultValue = "10") Integer pageSize,
                                            @RequestParam(value = "orderBy", defaultValue = "") String orderBy
                                            ){
        return iProductService.getProductByKeywordCategory(keyword, categoryId, pageNum, pageSize, orderBy);
    }
}
