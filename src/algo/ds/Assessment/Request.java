package algo.ds.Assessment;

import java.math.BigDecimal;
import java.util.List;

public class Request {
  
    private String name;
    private BigDecimal budget;
    private List<CuisineType> cuisinoTypes;
    
    public BigDecimal getBudget() {
          return budget;
    }
  
    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
  
    public List<CuisineType> getCuisinoTypes() {
         return cuisinoTypes;
    }
  
    public void setCuisinoTypes(List<CuisineType> cuisinoTypes) {
      this.cuisinoTypes = cuisinoTypes;
    }
  
    public Request(String name) {
      this.name = name;
    }
    
    public String getName() {
      return this.name;
    }
  }
  