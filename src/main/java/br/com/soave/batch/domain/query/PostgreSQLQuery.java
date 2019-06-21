package br.com.soave.batch.domain.query;

public class PostgreSQLQuery {

    public static final String writeProductsPostgreSQL(){
        StringBuilder query = new StringBuilder();
        query.append("   INSERT INTO                  ");
        query.append("   BATCHDB.PUBLIC.PRODUCTS      ");
        query.append("           (ID_PRODUCT,         ");
        query.append("            NAME_PRODUCT,       ");
        query.append("            COST_PRICE_PRODUCT, ");
        query.append("            SALE_PRICE_PRODUCT, ");
        query.append("            BARCODE_PRODUCT)    ");
        query.append("   VALUES                       ");
        query.append("           (:productId,         ");
        query.append("            :productName,       ");
        query.append("            :costPriceProduct,  ");
        query.append("            :salePriceProduct,  ");
        query.append("            :barCodeProduct)    ");
        return query.toString();
    }
}