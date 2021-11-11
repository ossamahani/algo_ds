/*
 * Click `Run` to execute the snippet below!
 */
package algo.ds.Assessment;
import java.util.*;
import java.math.BigDecimal;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Solution {
  public static void main(String[] args) {
    
    // Create Mock Data
    Restaurant rest1 = new Restaurant("Satisfactory Pita");
    rest1.setCuisineType(CuisineType.Mediterranean);
    rest1.setPrice(BigDecimal.valueOf(30.00));


    Restaurant rest2 = new Restaurant("Three Guys");
    rest2.setCuisineType(CuisineType.BurgersFries);
    rest2.setPrice(BigDecimal.valueOf(15.00));


    Restaurant rest3 = new Restaurant("China Panda");
    rest3.setCuisineType(CuisineType.Chinese);
    rest3.setPrice(BigDecimal.valueOf(20.00));
    
    
    Restaurant rest4 = new Restaurant("Al Bacha");
    rest4.setCuisineType(CuisineType.Mediterranean);
    rest4.setPrice(BigDecimal.valueOf(18.00));
    
  
    List<Restaurant> restList = new ArrayList<>();
    restList.add(rest1);
    restList.add(rest2);
    restList.add(rest3);
    restList.add(rest4);

    Request request1 = new Request("Keith Ward");
    request1.setBudget(BigDecimal.valueOf(20));
    request1.setCuisinoTypes(List.of(CuisineType.Chinese));
    
    
    Request request2 = new Request("Tony Jackson");
    request2.setBudget(BigDecimal.valueOf(18));
    request2.setCuisinoTypes(List.of(CuisineType.Mediterranean, CuisineType.Chinese));
    
    
    Request request3 = new Request("Stephanie Lytton");
    request3.setBudget(BigDecimal.valueOf(22));
    request3.setCuisinoTypes(List.of(CuisineType.Mediterranean,CuisineType.BurgersFries,CuisineType.Chinese));
    
    
    Request request4 = new Request("Brad Pitt");
    request4.setBudget(BigDecimal.valueOf(25));
    request4.setCuisinoTypes(List.of(CuisineType.Mediterranean));

    Request request5 = new Request("John Smith");
    request5.setBudget(BigDecimal.valueOf(13));
    request5.setCuisinoTypes(List.of(CuisineType.Chinese));

    
    List<Request> requestList = new ArrayList<>();
    requestList.add(request1);
    requestList.add(request2);
    requestList.add(request3);
    requestList.add(request4);
    requestList.add(request5);

    
    
    //Find min Budget in Request List
    Optional<Request> minBuget = requestList.stream().min(Comparator.comparing(Request::getBudget));
    BigDecimal minimumBudget = minBuget.get().getBudget();
    System.out.println(minimumBudget);
    
    //Find common CuisineType, by get max occurrances of CusineTypes in all requests.
    Map<CuisineType, Integer> map = new HashMap<>();
    
    for(Request request : requestList) {
      for(CuisineType cuisineType : request.getCuisinoTypes()) {
        map.put(cuisineType, map.getOrDefault(cuisineType,0)+1);
      }
    }
    
    CuisineType commonCuisineType = null;
    int max = Integer.MIN_VALUE;
    
    for(CuisineType cuisineType : map.keySet()) {
        int val =  map.get(cuisineType);
        if(val > max) {
          max = val;
          commonCuisineType = cuisineType;
        }
    }
    System.out.println(commonCuisineType.toString());
    //Now search in resturant List by Common CusinieType and Minimum Budget
    Restaurant bestRest = getBestRest(restList, commonCuisineType, minimumBudget);
    System.out.println(bestRest.getName());
    
  }

  private static Restaurant getBestRest(List<Restaurant> restList,  CuisineType commonCuisineType, BigDecimal minimumBudget) {
      for(Restaurant rest : restList) {
        if(rest.getCusineType().equals(commonCuisineType) && rest.getPrice().compareTo(minimumBudget) <= 0) {
          return rest;
        }
      }
      return getBestRest(restList, commonCuisineType, minimumBudget.add(BigDecimal.ONE));
   }
}
