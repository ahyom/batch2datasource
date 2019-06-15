package br.com.soave.batch.domain.query;

public class MySQLQuery {

    public static final String readProductsFromMySQL(){
        StringBuilder query = new StringBuilder();
        query.append("   SELECT ID_PRODUCT,          ");
        query.append("          NAME_PRODUCT,        ");
        query.append("          COST_PRICE_PRODUCT,  ");
        query.append("          SALE_PRICE_PRODUCT,  ");
        query.append("          BARCODE_PRODUCT      ");
        query.append("   FROM BATCHDB.PRODUCTS");
        return query.toString();
    }
}
