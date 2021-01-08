#include<stdio.h>
int max(int , int );

int main(){
	
	int i , j ;
	char a[201];
	scanf("%[^\n]*c", a);
	int flag = 0;
	int length = 0 , max_length = 0;
	int start_index = 0;
	for(i = 0 ; a[i] != '\0' ; i++){
		
		 if(a[i] == ' ')
		   {
		   	   max_length = max(length , max_length);
		   	   length = 0;
		   }
		 else if( (65 <= a[i] && a[i] <= 91 ) || (97 <= a[i]  && a[i] <= 123)){
		 	 length++;
	     }
	}

   
	max_length = max(length , max_length);
		length = 0 ;
	 printf("%d" , max_length);
	 for(i = 0 ; a[i] != '\0' ; i++){
	 	  
	 	    if(a[i] == ' ')
	 	      {
	 	      	  start_index = i - max_length;
	 	      	  if(length == max_length) { 
					 flag = 1 ;
					 break;
					 }
	 	      	  length = 0;  
			   }
			else if( (65 <= a[i] && a[i] <= 91 ) || (97 <= a[i]  && a[i] <= 123)){
		 	 length++;
	     }
	 }
	 
	 if(length == max_length && !flag)start_index = i - max_length;
	int cnt = 0;
	printf("%d " , start_index);
	for(i = start_index  , cnt = 0 ; cnt <= max_length ;cnt++ ,  i++){
		printf("%c",a[i]);
	}
	 
}

int max(int a , int b){
	  if( a > b)return a;
	  return b;
}
