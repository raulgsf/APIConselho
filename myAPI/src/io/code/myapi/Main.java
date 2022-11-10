package io.code.myapi;

import java.net.HttpURLConnection;
import java.util.Scanner;

import io.code.myapi.dominio.Conselho;

public class Main {
	public static void main(String[] args) throws Exception {
        System.out.print("Aceita um conselho? ");
        String resposta = new Scanner(System.in).nextLine();
        
        if(resposta.compareToIgnoreCase("sim") == 0){
        	System.out.println("Escolha o número do conselho:(1 a 224 ou 0 sendo aleátorio) ");
        	int respostaNmr = new Scanner(System.in).nextInt();
        	if(respostaNmr >= 0 && respostaNmr < 225) {
        		Conselho conselho = ServicoDeConselho.buscaConselhoPorId(respostaNmr);
            	
            	System.out.println("Id : " + conselho.getSlip().getId());
            	System.out.println("Conselho : " + conselho.getSlip().getAdvice());
        	}else {
        		System.out.println("Número Inválido");
        	}
        	
        }else if(resposta.compareToIgnoreCase("nao") == 0){
        	System.out.println("Ok");
        }else {
        	System.out.println("Não entendi!");
        }
	}
}
