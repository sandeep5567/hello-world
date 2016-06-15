import java.util.*;
class Coll
{
public static void main(String a[])
{
ArrayList <Integer>al=new ArrayList<Integer>();
al.add(1);
al.add(2);
al.add(3);
//a1.add("c");
System.out.println(al);
List <String>l1=new ArrayList<String>();
l1.add("sandy");
l1.add("sandeep");
l1.add("reddy");
System.out.println(l1);
List <String>l2=new ArrayList<String>();
l2.add("sandy.");
l2.add("sandeep.");
l2.add("reddy.");
l1.addAll(l2);
System.out.println(l1);
System.out.println("l2 is");
for (String obj:l2)
{
System.out.println(obj+" ");
}
System.out.println("l1 is");
for (String obj:l1)
{

System.out.println(obj+" ");
}
System.out.println("al is");
for (Integer i:al)
{
System.out.println("l1 is");
}
Iterator itr=l2.iterator();
while(itr.hasNext())
{
Object obj=itr.next();
System.out.println(obj);
}
}
}