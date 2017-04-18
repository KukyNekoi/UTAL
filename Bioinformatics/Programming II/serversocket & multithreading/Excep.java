 class Exception1 extends Exception
 { 	//este tipo de excepcion guarda dos numeros enteros
 	int a;
 	int b;
 	Exception1(int vara, int varb)
 	{
 		a=vara;
 		b=varb;
 	}
 }
 
 class Exception2 extends Exception
 {
 	//este tipo de excepcion no guarda ningun tipo de informacion
 	Exception2()
 	{
 		
 	}
 }
 
 
 class ejemplo1
{
   public static void main( String args[] )
   {
   	do{
   
      try 
      { 
         metodo1(); //Metodo que puede lanzar una excepcion
         metodo2();//Metodo que puede lanzar una excepcion
      } 
      catch ( Exception1 ex1 ) // Capturar una excepcion que puede producirse en el bloque try
      {
        System.out.println( "Se produjo una excepcion Exception1, ya que el primer numero ingresado era menor que el segundo" );
        System.out.println( "La variable a de esta excepcio vale: " + ex1.a );
        System.out.println( "La variable a de esta excepcio vale: " + ex1.b);
      } 
      catch ( Exception2 ex1 ) // Capturar una excepcion que puede producirse en el bloque try
      {
        System.out.println( "Se produjo una excepcion Exception2, se igreso denominador 0" );        
      }	
   	}while(true);
   } 

   // Metodo de clase (si fuera de instancia, sin el static, habria que crear una instancia para que lo llamara)
   // este metodo lanza una excepcion para que sea manejada por el main, quien es quien llama a este m�todo.
   static void metodo1() throws Exception1
   {
   	//Este metodo pide dos numeros enteros al usuario.
   	//Si el primer numero es menor que el segundo, se lanza una excepcion de tipo ex1. 
   	//A esta excepcion se le entregan los numeros ingresados por el usuario (recuerde que la excepcion almacena 2 num enteros)
   	int num1;
   	int num2;
   	System.out.println("Ingrese un numero");
   	num1=Leer.datoInt();
   	System.out.println("Ingrese otro numero");
   	num2=Leer.datoInt();
   	
   	if (num1<num2)
   	{
   		throw new Exception1(num1,num2);	
    }
    else
    {
    	System.out.println("Todo bien");
    }
    	
   	
    } 
    
    static void metodo2() throws Exception2
    {
   	int num1;
   	int num2;
   	System.out.println("Ingrese el numerador");
   	num1=Leer.datoInt();
   	System.out.println("Ingrese el denominador");
   	num2=Leer.datoInt();
   	
   	if (num2==0)
   	{
   		throw new Exception2();	
    }
    else
    {
    	System.out.println(num1 + "/" + num2);
    }
    	
    }	
    }
