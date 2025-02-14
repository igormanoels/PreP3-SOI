package view;

import java.io.IOException;
import java.util.Scanner;
import controller.Leitura;

/*
 * Tarefa para ser entregue
 * 1110482312054 - IGOR MANOEL DE SANTANA 
 * Pr� P3 - Pegar o conte�do do site: https://date.nager.at/api/v2/publicholidays/2020/US 
 * (Usar modo RAW ou Dados Brutos), esse site traz um arquivo com diferentes feriados americanos. 
 * Gravar em um arquivo chamado hol.json na pasta C:\TEMP (\tmp se for Linux) e fazer uma aplica��o Java que, 
 * na classe principal, no m�todo Main, pe�a ao usu�rio um name, chame uma classe de controle que leia o arquivo, e, 
 * apresente a data do feriado. (Caso n�o exista, lan�ar uma exce��o)
 */

public class Principal {
    public static void main(String[] args) throws IOException 
    {
    	menu();
    }
    
    public static void menu() throws IOException 
    {
    	boolean buscando = true;
    	int quant = 1;
        Scanner ler = new Scanner(System.in);
        System.out.println("Seja bem-vindo � minha aplica��o para avalia��o da Pr�-P3\n");

    	
    	while (buscando)
    	{	    		
            String caminho = VerificaSO() + "/hol.json";
            //teste System.out.println("Caminho do arquivo: " + caminho);
            
            if (quant != 1) 
            {
            	System.out.print("Deseja continuar na aplica��o? "
            			+ "\nResponda Sim ou N�o: ");
            	String continua = ler.nextLine().toLowerCase();
            	if (continua.contains("n�o")) 
            	{
                	buscando = false;
				}
			}
            
            if (buscando == true)
            {
                System.out.print("Informe o " + quant +"� feriado que voc� deseja conhecer a data: ");
                String feriado = ler.nextLine();

                
                Leitura leitura = new Leitura();
                leitura.VerificarData(caminho, feriado);
                quant += 1;
            }
            else
            {
            	System.out.println("Obrigado por testar meu algoritmo!");
            }
            
    	}
        
        ler.close();
    }

    public static String VerificaSO() 
    {
        String caminho = "";
        String nomeSO = System.getProperty("os.name").toLowerCase();
    
        if (nomeSO.contains("windows")) 
        {
            caminho = "C:\\TEMP";
        } 
        else if (nomeSO.contains("linux")) 
        {
            caminho = "/tmp";
        }
        return caminho;
    }
}