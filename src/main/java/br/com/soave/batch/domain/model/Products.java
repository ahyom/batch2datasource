package br.com.soave.batch.domain.model;

public class Products {

    private Integer productId;
    private String productName;
    private Double costPriceProduct;
    private Double salePriceProduct;
    private String barCodeProduct;

    public Products(Integer productId, String productName, Double costPriceProduct, Double salePriceProduct, String barCodeProduct) {
        this.productId = productId;
        this.productName = productName;
        this.costPriceProduct = costPriceProduct;
        this.salePriceProduct = salePriceProduct;
        this.barCodeProduct = barCodeProduct;
    }

    public Products() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getCostPriceProduct() {
        return costPriceProduct;
    }

    public void setCostPriceProduct(Double costPriceProduct) {
        this.costPriceProduct = costPriceProduct;
    }

    public Double getSalePriceProduct() {
        return salePriceProduct;
    }

    public void setSalePriceProduct(Double salePriceProduct) {
        this.salePriceProduct = salePriceProduct;
    }

    public String getBarCodeProduct() {
        return barCodeProduct;
    }

    public void setBarCodeProduct(String barCodeProduct) {
        this.barCodeProduct = barCodeProduct;
    }
}
