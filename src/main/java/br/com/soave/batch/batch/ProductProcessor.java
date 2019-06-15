package br.com.soave.batch.batch;

import br.com.soave.batch.domain.model.Products;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(ProductProcessor.class);

    @Override
    public Products process(Products item) throws Exception {
        log.info("Recalculating product " + item.getProductId());
        log.info("Old SalePrice: $" + item.getSalePriceProduct());
        final Double newSalePriceProduct = item.getCostPriceProduct() + (item.getCostPriceProduct() * 0.85);
        log.info("New SalePrice: $" + newSalePriceProduct);
        final Products transformedProduct = new Products(item.getProductId(),
                                                         item.getProductName().toUpperCase(),
                                                         item.getCostPriceProduct(),
                                                         newSalePriceProduct,
                                                         item.getBarCodeProduct());
        return transformedProduct;
    }
}
