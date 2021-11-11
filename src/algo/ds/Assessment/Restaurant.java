package algo.ds.Assessment;

import java.math.BigDecimal;

public class Restaurant {

  private String name;
  private BigDecimal price;
  private CuisineType cuisineType;
  
  public Restaurant(String name) {
    this.name = name;
  }
  
  public String getName() {
    return this.name;
  }
  
  public BigDecimal getPrice() {
      return price;
  }

  public void setPrice(BigDecimal price) {
      this.price = price;
  }

  public CuisineType getCusineType() {
      return cuisineType;
  }

  public void setCuisineType(CuisineType cuisineType) {
     this.cuisineType = cuisineType;
  }
}


 