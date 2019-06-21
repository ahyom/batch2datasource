package br.com.soave.batch.batch;

import br.com.soave.batch.domain.model.Products;
import org.springframework.batch.item.ItemProcessor;


public class ProductProcessor implements ItemProcessor<Products, Products> {

    /**
     * The process objective is convert products name to upper case
     * and recalculate sales price for all products, based on
     * fixed percent of profit.
     *
     * @author Arthur Soave
     * @since 06/2019
     */

    @Override
    public Products process(Products item) throws Exception {
        final Double newSalePriceProduct = item.getCostPriceProduct() + (item.getCostPriceProduct() * 0.85);
        final Products transformedProduct = new Products(item.getProductId(),
                                                         item.getProductName().toUpperCase(),
                                                         item.getCostPriceProduct(),
                                                         newSalePriceProduct,
                                                         item.getBarCodeProduct());
        return transformedProduct;
    }
}
