package yz.bean;

public class Apple 
{
   private Apple(){}
   
   private static Apple instance=new Apple();
   
   //对外提供操作接口
   public static Apple getInstance(){
	   if(instance==null){
		   instance=new Apple();
	   }
	   return instance;
   }
}
