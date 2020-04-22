import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculadoraServerSocket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket welcomeSocket;
		DataOutputStream socketOutput;     	
	    DataInputStream socketInput;
	    BufferedReader socketEntrada;
	    Calculadora calc = new Calculadora();
		try {
			welcomeSocket = new ServerSocket(9090);
		  int i=0; //numero de clientes

	      System.out.println ("Servidor no ar");
	      while(true) { 

	           Socket connectionSocket = welcomeSocket.accept(); 
	           i++;
	           System.out.println ("Nova conexao");
	           
	           String result= "";
	           //Interpretando dados do servidor
	           socketEntrada = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
               String operacao= socketEntrada.readLine();
               String oper1=socketEntrada.readLine();
               String oper2=socketEntrada.readLine();
               System.out.println ("Operação recebida: operacao ["+operacao+"], oper1 ["+oper1+"], oper2 ["+oper2+"]");
               
               //1-somar 2-subtrair 3-dividir 4-multiplicar
               switch (operacao) {
			case "1":
				System.out.println("Soma");
				//Chamando a calculadora
	            result= ""+calc.soma(Double.parseDouble(oper1),Double.parseDouble(oper2));
				break;
			case "2":
				System.out.println("Sub");
				//Chamando a calculadora
	            result= ""+calc.subtrai(Double.parseDouble(oper1),Double.parseDouble(oper2));				
				break;
			case "3":
				System.out.println("Div");
				//Chamando a calculadora
	            result= ""+calc.divide(Double.parseDouble(oper1),Double.parseDouble(oper2));				
				break;
			case "4":
				System.out.println("Mult");
				//Chamando a calculadora
	            result= ""+calc.multiplica(Double.parseDouble(oper1),Double.parseDouble(oper2));				
				break;
			default:
				System.out.println("Default");
				//Enviando dados para o servidor
	               socketOutput= new DataOutputStream(connectionSocket.getOutputStream());     	
		           socketOutput.writeBytes("Operação ["+operacao+"] não definida\n");
		           System.out.println ("Operação ["+operacao+"] não definida\n");
		           socketOutput.flush();
		           socketOutput.close();
		           continue;
			
			}
            
              
               //Enviando dados para o servidor
               socketOutput= new DataOutputStream(connectionSocket.getOutputStream());     	
	           socketOutput.writeBytes(result+ '\n');
	           System.out.println (result);	           
	           socketOutput.flush();
	           socketOutput.close();

	                    
	      }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	}

}
