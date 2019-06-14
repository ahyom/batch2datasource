package br.com.soave.batch.domain.mapper;

import br.com.soave.batch.domain.model.Products;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Products> {
    @Override
    public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
        Products products = new Products();
        products.setProductId(rs.getInt("ID_PRODUCT"));
        products.setProductName(rs.getString("NAME_PRODUCT"));
        products.setCostPriceProduct(rs.getDouble("COST_PRICE_PRODUCT"));
        products.setSalePriceProduct(rs.getDouble("SALE_PRICE_PRODUCT"));
        products.setBarCodeProduct(rs.getString("BARCODE_PRODUCT"));
        return products;
    }
}
