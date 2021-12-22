package algo.ds.Interview;

/*
We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order, and no URL was visited more than once per person.

Write a function that takes two users' browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

Sample input:

user0 = ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
user1 = ["/start", "/pink", "/register", "/orange", "/red", "a"]
user2 = ["a", "/one", "/two"]
user3 = ["/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen"]
user4 = ["/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red", "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow"]
user5 = ["a"]
user6 = ["/pink","/orange","/six","/plum","/seven","/tan","/red", "/amber"]

Sample output:

findContiguousHistory(user0, user1) => ["/pink", "/register", "/orange"]
findContiguousHistory(user0, user2) => [] (empty)
findContiguousHistory(user0, user0) => ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
findContiguousHistory(user2, user1) => ["a"] 
findContiguousHistory(user5, user2) => ["a"]
findContiguousHistory(user3, user4) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user4, user3) => ["/plum", "/blue", "/tan", "/red"]
findContiguousHistory(user3, user6) => ["/tan", "/red", "/amber"]

n: length of the first user's browsing history
m: length of the second user's browsing history

o(n*m)

*/
import java.io.*;
import java.util.*;

public class Test1 {
  public static void main(String[] argv) {

    String[] user0 = { "/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two" };
    String[] user1 = { "/start", "/pink", "/register", "/orange", "/red", "a" };

    String[] user2 = { "a", "/one", "/two" };


    String[] user3 = { "/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink",
        "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen" };

    String[] user4 = { "/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red",
        "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow" };


    String[] user5 = { "a" };
    String[] user6 = { "/pink", "/orange", "/six", "/plum", "/seven", "/tan", "/red", "/amber" };

    /*findContiguousHistory(user0, user1); // => ["/pink", "/register", "/orange"]
    findContiguousHistory(user0, user2); // => [] (empty)
    findContiguousHistory(user0, user0); // => ["/start", "/green", "/blue", "/pink", "/register", "/orange",
                                         // "/one/two"]
    findContiguousHistory(user2, user1); // => ["a"]
    findContiguousHistory(user5, user2); // => ["a"]
    findContiguousHistory(user3, user4); // => ["/plum", "/blue", "/tan", "/red"]*/
    findContiguousHistory(user4, user3); // => ["/plum", "/blue", "/tan", "/red"]
    findContiguousHistory(user3, user6); // => ["/tan", "/red", "/amber"]

    System.out.println("=================================================");
   /*
    findWithTwoPointer(user0, user1); // => ["/pink", "/register", "/orange"]
    findWithTwoPointer(user0, user2); // => [] (empty)
    findWithTwoPointer(user0, user0); // => ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
    findWithTwoPointer(user2, user1); // => ["a"]
    findWithTwoPointer(user5, user2); // => ["a"]
    findWithTwoPointer(user3, user4); // => ["/plum", "/blue", "/tan", "/red"]
    findWithTwoPointer(user4, user3); // => ["/plum", "/blue", "/tan", "/red"]
    findWithTwoPointer(user3, user6); // => ["/tan", "/red", "/amber"]
    */
    System.out.println("=================================================");

    findContiguousHistoryUsingLinkedList(user0, user1); // => ["/pink", "/register", "/orange"]
    findContiguousHistoryUsingLinkedList(user0, user2); // => [] (empty)
    findContiguousHistoryUsingLinkedList(user0, user0); // => ["/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"]
    findContiguousHistoryUsingLinkedList(user2, user1); // => ["a"]
    findContiguousHistoryUsingLinkedList(user5, user2); // => ["a"]
    findContiguousHistoryUsingLinkedList(user3, user4); // => ["/plum", "/blue", "/tan", "/red"]
    findContiguousHistoryUsingLinkedList(user4, user3); // => ["/plum", "/blue", "/tan", "/red"]
    findContiguousHistoryUsingLinkedList(user3, user6); // => ["/tan", "/red", "/amber"]

  }

  static class Node {
    String value;
    Node next;

    public Node(String value, Node next) {
      this.value = value;
      this.next = next;
    }
  }

  private static Node fillLinkedList(String[] usr) {
    Node head = null;
    Node prev = null;
    for (String str : usr) {
      Node node = new Node(str, null);
      if (head == null) {
        head = node;
      }
      if(prev != null) {
        prev.next = node;
      }
      prev = node;
    }
    return head;
  }

  private static List<String> findContiguousHistoryUsingLinkedList(String[] usr1, String[] usr2) {

    /*
    String[] user1= { "/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red",
    "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow" }; 
        
    String[] user2 = { "/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink",
    "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen" };
    */

    Node head1 = fillLinkedList(usr1);
    Node head2 = fillLinkedList(usr2);
    Map<String, Node> map = new HashMap<>();
    while(head2 != null) {
        map.put(head2.value, head2);
        head2 = head2.next;
    } 
    
  Node prevUserNode = null;

  List<String> temp = new ArrayList<>();
  List<String> result = new ArrayList<>(); 
   while(head1 != null) {
           Node node = prevUserNode == null ? map.get(head1.value) : prevUserNode.next;
           boolean shouldCont = node != null && node.value == head1.value;
           if(shouldCont) {
                temp.add(node.value);
                prevUserNode = node;
                head1 = head1.next;
           } 
           if(prevUserNode == null) {
            head1 = head1.next;
           }
           if(!shouldCont) {
                if(temp.size() > result.size()) {
                  result = temp;
                }
                prevUserNode = null;
                temp = new ArrayList<>();
           }  
   }

   if(temp.size() > result.size()) {
    result = temp;
  }
  System.out.println(result);
  return result;
  }

  public static List<String> findWithTwoPointer(String[] usr1, String[] usr2) {
    int i = 0;
    int j = 0;
    List<String> list = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();
    while (i < usr1.length && j < usr2.length) {
      if (usr1[i] == usr2[j]) {
        list.add(usr1[i]);
        i++;
        j++;
      } else {
        i++;
        if (!list.isEmpty()) {
          list = new ArrayList<>();
        }
      }
      result.add(list);
    }

    int max = 0;
    List<String> maxList = new ArrayList<>();
    for (i = 0; i < result.size(); i++) {
      if (result.get(i).size() > max) {
        max = result.get(i).size();
        maxList = result.get(i);
      }

    }
    System.out.println(maxList);

    return maxList;
  }

  // O(n*m) | O(n*m)
  public static List<String> findContiguousHistory(String[] usr1, String[] usr2) {


       /*
    String[] user1= { "/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red",
    "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow" }; 
        
    String[] user2 = { "/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink",
    "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen" };
    */

    List<List<String>> result = new ArrayList<>();
    int start = 0;
    List<String> list = new ArrayList<>();
    for (int i = 0; i < usr1.length; i++) {
      for (int j = start; j < usr2.length; j++) {
        if (usr1[i] == usr2[j]) {
          list.add(usr1[i]);
          start = j;
          start++;
          break;
        } else if (!list.isEmpty()) {
          list = new ArrayList<>();
        }
      }
      result.add(list);
    }

    int max = 0;
    List<String> maxList = new ArrayList<>();
    for (int i = 0; i < result.size(); i++) {
      if (result.get(i).size() > max) {
        max = result.get(i).size();
        maxList = result.get(i);
      }

    }
    System.out.println(maxList);

    return maxList;

  }
}
