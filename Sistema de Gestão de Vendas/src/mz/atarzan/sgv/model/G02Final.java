package mz.atarzan.sgv.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.io.FileReader;
import java.util.Scanner;
//
import java.io.*;
import java.util.regex.*;
//

/*
        UNIVERSIDADE EDUARDO MONDLANE
           FACULDADE DE ENGENHARIA

  CURSO: LICENCIATURA EM ENGEHARIA INFORMATICA

      DOCENTES: IVONE CIPRIANO; LEILA OMAR
*/
/**
 * @author        GRUPO 2
 * ----------------------------------------
 * @author Malate , Keyton Helder         |
 * @author Mangue, Filipe Emanuel         |
 * @author Mahenga, Teresa Mandando       |
 * @author Matola, Ernesto Samuel         |
 * @author Macuacua, Augusto              |
 * @author Manhica, Hermenegildo Carlos   |
 * @author Neves, Hermen Tomas            |
 * @author Guezimane , Ronaldo Dias       |
 * ----------------------------------------
 */
public class G02Final {
    static int qtd,estoque,qtd_pratos,qtd_prod_vendido = 0,qtd_prato_vendido = 0, acessar_sistema;
    static byte prato, bebida,produto,opcao;
    static double preco,valor_arrecadado_prato,valor_arrecadado_prod;
    static char executar_mais;
    static String numeroi, username, password ;
    static boolean allow = false;
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String[] administrador = new String[]{"Keyton Malate","Filipe Mangue","Teresa Mahenga",
                                                 "Ernesto Matola", "Augusto Macuacua", "Hermenegildo Manhica",
                                                 "Hermen Neves", "Ronaldo Guezimane"};
    static String[] bebidas = new String[]{"1  - CERVEJA 2M.................... "+nomeMoeda()+" "+formatarMoeda(precoProduto(1)),
                                           "2  - CHAMPANHE..................... "+nomeMoeda()+" "+formatarMoeda(precoProduto(2)),
                                           "3  - CERVEJA BUDWEISER............. "+nomeMoeda()+" "+formatarMoeda(precoProduto(3)),
                                           "4  - CASTLE LITE................... "+nomeMoeda()+" "+formatarMoeda(precoProduto(4)),
                                           "5  - VINHO PORTO................... "+nomeMoeda()+" "+formatarMoeda(precoProduto(5)),
                                           "6  - SPIN.......................... "+nomeMoeda()+" "+formatarMoeda(precoProduto(6)),
                                           "7  - AGUA MINERAL.................. "+nomeMoeda()+" "+formatarMoeda(precoProduto(7)),
                                           "8  - COCACOLA LATA................. "+nomeMoeda()+" "+formatarMoeda(precoProduto(8)),
                                           "9  - SPRITE LATA................... "+nomeMoeda()+" "+formatarMoeda(precoProduto(9)),
                                           "10 - TXILAR........................ "+nomeMoeda()+" "+formatarMoeda(precoProduto(10)),
                                           "11 - LAURENTINA PRETA.............. "+nomeMoeda()+" "+formatarMoeda(precoProduto(11)),
                                           "12 - VINHO WHITE(EUA).............. "+nomeMoeda()+" "+formatarMoeda(precoProduto(12)),
                                           "13 - CERVEJA MANICA................ "+nomeMoeda()+" "+formatarMoeda(precoProduto(13))};


    static String[] pratos = new String[]{"1  - GUISADO DE FRANGO..................... "+nomeMoeda()+" "+formatarMoeda(precoPrato(1)),
                                          "2  - BIFE DE PERU COM MANTEIGA............. "+nomeMoeda()+" "+formatarMoeda(precoPrato(2)),
                                          "3  - CARAPAU FRITO......................... "+nomeMoeda()+" "+formatarMoeda(precoPrato(3)),
                                          "4  - FRANGOA ZAMBEZIANA....................."+nomeMoeda()+" "+formatarMoeda(precoPrato(4)),
                                          "5  - GUISADO DE FEIJAO..................... "+nomeMoeda()+" "+formatarMoeda(precoPrato(5)),
                                          "6  - LULAS GRELHADAS........................"+nomeMoeda()+" "+formatarMoeda(precoPrato(6)),
                                          "7  - MATAPA COM CARANGUEJO.................."+nomeMoeda()+" "+formatarMoeda(precoPrato(7)),
                                          "8  - PICANHA............................... "+nomeMoeda()+" "+formatarMoeda(precoPrato(8)),
                                          "9  - GUIZADO DE TXEKE...................... "+nomeMoeda()+" "+formatarMoeda(precoPrato(9)),
                                          "10 - LAGOSTA .............................. "+nomeMoeda()+" "+formatarMoeda(precoPrato(10)),
                                          "11 - ARROZ A VAPOR......................... "+nomeMoeda()+" "+formatarMoeda(precoPrato(11)),
                                          "12 - ARROZ BRIAN........................... "+nomeMoeda()+" "+formatarMoeda(precoPrato(12)),
                                          "13 - XIMA.................................. "+nomeMoeda()+" "+formatarMoeda(precoPrato(13))};
    static byte [] beersAvailabe = new byte[]{5,5,5,5,5,5,5,5,5,5,5,5,5};
    static byte [] beersSold = new byte[13];

    public static String getUsername() {
       return username;
    }

    public static byte[] getBeersAvailabe() {
        return beersAvailabe;
    }

    public static void setBeersAvailabe(int pos, int qtd) {
        beersAvailabe[pos] = (byte) (beersAvailabe[pos] - qtd);
    }

    public static void setNewBeersAvailabe(int pos, int qtd) {
        beersAvailabe[pos] = (byte) (beersAvailabe[pos] + qtd);
    }

    public static void main(String[] args) throws IOException {
        iniciar();

    }

    public static void log() throws IOException{
        do{
            System.out.print("key");
            System.out.print("\n\t---------------------------------------\n\t"
                    + "SISTEMA DE GESTÃƒO DE RESTAURANTE\n\t---------------------------------------\n\t"
                    + "1 - Entrar como cliente/visitante\n\t2 - Gestor/Administrador\n\t"
                    + "---------------------------------------\n\n\tDigite opcao: ");
            acessar_sistema = Integer.parseInt(br.readLine());
            if(acessar_sistema == 2){
                do {
                //key
                //key

                    System.out.print("\n\tUSERNAME: ");
                    username = br.readLine();
                    System.out.print("\tPASSWORD: ");
                    password = br.readLine();
                    for (String administrator : administrador) {
                        if ((administrator.equals(username)) && "0000".equals(password)) {
                           allow = true;
                           loggedAsAdmin();
                        }
                    }
                } while (allow != true);
            } else {
                loggedAsVisitor();
            }
        } while (acessar_sistema != 1 || acessar_sistema == 2);
    }

    public  static void iniciar() throws IOException{
        log();
    }
    public static void menuBar(){
        System.out.println("\n\t                    MENU DE BEBIDAS");
        for (String beers : bebidas) {
            System.out.println("\t"+beers);
        }
    }

    public  static void menuMesa(){
        System.out.println("\n\t                    MENU DE PRATOS");
        for (String food : pratos){
            System.out.println("\t"+food);
        }
    }

    public static double precoProduto(int numBebida) {
               if(numBebida == 1){
            return 65;
        } else if (numBebida == 2){
            return 450;
        } else if (numBebida == 3){
            return 75;
        } else if (numBebida == 4){
            return 65;
        } else if (numBebida == 5){
            return 290;
        } else if (numBebida == 6){
            return 65;
        } else if (numBebida == 7){
            return 35;
        } else if (numBebida == 8){
            return 50;
        } else if (numBebida == 9){
            return 50;
        } else if (numBebida == 10){
            return 45;
        } else if (numBebida == 11){
            return 55;
        }else if (numBebida == 12){
            return 1900;
        }else if (numBebida == 13){
            return 50;
        }return 0;
    }

    public static double precoPrato(int numPrato) {
               if(numPrato == 1){
            return 200;
        } else if (numPrato == 2){
            return 300;
        } else if (numPrato == 3){
            return 700;
        } else if (numPrato == 4){
            return 230;
        } else if (numPrato == 5){
            return 240;
        } else if (numPrato == 6){
            return 600;
        } else if (numPrato == 7){
            return 350;
        } else if (numPrato == 8){
            return 800;
        } else if (numPrato == 9){
            return 200;
        } else if (numPrato == 10){
            return 1200;
        } else if (numPrato == 11){
            return 80;
        } else if (numPrato == 12){
            return 90;
        } else if (numPrato == 13){
            return 90;
        }
        return 0;
    }

    //start gravar num bebida e Qtd
    private static void operacaoBar() throws IOException{
        do{
            menuBar();
            do{
                System.out.print("\n\tEscolha a bebida: ");
                produto = Byte.parseByte(br.readLine());
                System.out.print(produto);
                gavarNumeroPrato(produto);
                System.out.print(" \tDigite a quantidade: ");
                qtd = Integer.parseInt(br.readLine());
                gravarQtdPrato(qtd);
                System.out.print(qtd);
                for(int i = 0; i < beersAvailabe.length;i++){
                   if((produto == i+1)){
                       if (beersAvailabe[produto] < qtd) {
                           System.out.println("\tQuantidade indisponivel!");
                       } else {
                           setBeersAvailabe(produto-1,qtd);
                       }
                   }
                }
            } while (produto <= 0 || produto >= 14);
                qtd_prod_vendido += qtd;
                valorArrecProd(produto,qtd);
                System.out.print("\tEscolher outra bebida s/n: ");
                executar_mais = br.readLine().toLowerCase().charAt(0);
                System.out.print(executar_mais);
        } while (executar_mais == 's');
    }
    private static String buscarDescricao(int numero){
        String texto = null;
        for (int i = 0; i < 13; i++) {
            if(numero == i+1){
                texto = bebidas[i];
            }
        }
        return texto;
    }

    private static void gavarNumeroPrato(int numero){
        File arquivo = new File("C:\\My files\\Bar.txt");
        try {
            if (!arquivo.exists()) {
                //cria um arquivo (vazio)
                arquivo.createNewFile();
            }
            //caso seja um diretÃ³rio, Ã© possÃ­vel listar seus arquivos e diretÃ³rios
            File[] arquivos = arquivo.listFiles();
            //escreve no arquivo
            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write("|___________|_________|________________________________|");
            bw.newLine();
            bw.write("| Bebida: "+numero);
            //bw.newLine();
            bw.close();
            fw.close();
       } catch (IOException ex) {
            ex.printStackTrace();
       }
    }

    private static double calcularCusto(String linha){
        double vc =  (double)(gravarQtdPrato(Integer.parseInt(linha)) * precoProduto(Integer.parseInt(linha)));
        return vc;
    }

    private static int gravarQtdPrato(int numero){
        int valor = 0;
        File arquivo = new File("C:\\My files\\Bar.txt");
        try {
            if (!arquivo.exists()) {
                //cria um arquivo (vazio)
                arquivo.createNewFile();
            }
            //caso seja um diretÃ³rio, Ã© possÃ­vel listar seus arquivos e diretÃ³rios
            File[] arquivos = arquivo.listFiles();
            //escreve no arquivo

            FileWriter fw = new FileWriter(arquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(" |  Qtd: "+numero+" | "+horasDataTxt()+"  |");
           // bw.write("|____________________|");
            //bw.newLine();
            bw.close();
            fw.close();
       } catch (IOException ex) {
            ex.printStackTrace();
       }
        return valor;
    }

    private static void lerNumeroPrato(int numero){
        File arquivo = new File("C:\\My files\\Bar.txt");
        try {
//           1


            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            //enquanto houver mais linhas
            while (br.ready()) {
                //lÃª a proxima linha
                String linha = br.readLine();
                //faz algo com a lin
                //System.out.println(linha

                //System.out.println(linha);
                System.out.println(buscarDescricao(Integer.parseInt(linha)));
                System.out.println("Custo: "+calcularCusto(linha));
            }
            br.close();
            fr.close();
       } catch (IOException ex) {
            ex.printStackTrace();
       }
    }


    private static int lerQtdPrato(int numero){
        int valor = 0;
        File arquivo = new File("C:\\My files\\Bar.txt");
        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            //enquanto houver mais linhas
            while (br.ready()) {
                //lÃª a proxima linha
                String linha = br.readLine();
                //faz algo com a linha
                //System.out.println(linha);
                valor = Integer.parseInt(linha);
            }
            br.close();
            fr.close();
       } catch (IOException ex) {
            ex.printStackTrace();
       }
        return valor;
    }
    //fim gravar num bebida e Qtd


    //............................................................


    //start gravar num prato e Qtd
    private static void operacaoMesa() throws IOException{
        do{
            menuMesa();
            do{
                System.out.print("\n\tEscolha o prato: ");
                prato = Byte.parseByte(br.readLine());
                gavarNumeroPratoi(prato);
                System.out.print(prato);
                System.out.print("\tQuantos pratos deseja: ");
                qtd_pratos = Integer.parseInt(br.readLine());
                gravarQtdPratoi(qtd_pratos);
                System.out.print(qtd_pratos);
            } while (prato <= 0 || prato >= 14);
                qtd_prato_vendido += qtd;
                valorArrecPrat(prato,qtd_pratos);
                System.out.print("\tEscolher outro prato s/n: ");
                executar_mais = br.readLine().toLowerCase().charAt(0);
                System.out.print(executar_mais);
        } while (executar_mais == 's');
    }

      private static String buscarDescricaoi(int numero){
        String texto = null;
        for (int i = 0; i < 14; i++) {
            if(numero == i+1){
                texto = pratos[i];
            }
        }
        return texto;
    }

    private static void gavarNumeroPratoi(int numero){
        File arquivoi = new File("C:\\My files\\Mesa.txt");
        try {
            if (!arquivoi.exists()) {
                //cria um arquivo (vazio)
                arquivoi.createNewFile();
            }
            //caso seja um diretÃ³rio, Ã© possÃ­vel listar seus arquivos e diretÃ³rios
            File[] arquivos = arquivoi.listFiles();
            //escreve no arquivo
            FileWriter fw = new FileWriter(arquivoi, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write("|____________|__________|_______________________________|");
            bw.newLine();
            bw.write("| Prato:"+numero) ;
            //bw.write(LocalTime.now().getHour()+":"+LocalTime.now().getMinute());
            //bw.newLine();
            bw.close();
            fw.close();
       } catch (IOException ex) {
            ex.printStackTrace();
       }
    }

    private static double calcularCustoi(String linha){
        double vc =  (double)(gravarQtdPratoi(Integer.parseInt(linha)) * precoProduto(Integer.parseInt(linha)));
        return vc;
    }

    private static int gravarQtdPratoi(int numero){
        int valor = 0;
        File arquivoi = new File("C:\\My files\\Mesa.txt");
        try {
            if (!arquivoi.exists()) {
                //cria um arquivo (vazio)
                arquivoi.createNewFile();
            }
            //caso seja um diretÃ³rio, Ã© possÃ­vel listar seus arquivos e diretÃ³rios
            File[] arquivos = arquivoi.listFiles();
            //escreve no arquivo
            FileWriter fw = new FileWriter(arquivoi, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("    |  Qtd: "+numero+"  | "+horasDataTxt()+" |");
            //bw.newLine();
            bw.close();
            fw.close();
       } catch (IOException ex) {
            ex.printStackTrace();
       }
        return valor;
    }

    private static void lerNumeroPratoi(int numero){
        File arquivoi = new File("C:\\My files\\Mesa.txt");
        try {
//           1


            FileReader fr = new FileReader(arquivoi);
            BufferedReader br = new BufferedReader(fr);
            //enquanto houver mais linhas
            while (br.ready()) {
                //lÃª a proxima linha
                String linha = br.readLine();
                //faz algo com a lin
                //System.out.println(linha

                //System.out.println(linha);
                System.out.println(buscarDescricaoi(Integer.parseInt(linha)));
                System.out.println("Custo: "+calcularCusto(linha));
            }
            br.close();
            fr.close();
       } catch (IOException ex) {
            ex.printStackTrace();
       }
    }


    private static int lerQtdPratoi(int numero){
        int valor = 0;
        File arquivoi = new File("C:\\My files\\Mesa.txt");
        try {
            FileReader fr = new FileReader(arquivoi);
            BufferedReader br = new BufferedReader(fr);
            //enquanto houver mais linhas
            while (br.ready()) {
                //lÃª a proxima linha
                String linha = br.readLine();
                //faz algo com a linha
                //System.out.println(linha);
                valor = Integer.parseInt(linha);
            }
            br.close();
            fr.close();
       } catch (IOException ex) {
            ex.printStackTrace();
       }
        return valor;
    }
    //fim gravar num prato e Qtd



    private static void relatorioVendas(){
        System.out.println("\n\t                    RELATÃ“RIO DE VENDAS\n"+
                           "\t---------------------------------------------------\n"+
                           "\tTotal de pratos Vendidos: "+qtd_prato_vendido+ "\n" +
                           "\tTotal de bebidas Vendidos: "+qtd_prod_vendido+ "\n" +
                           "\tValor arrecadado em pratos: "+nomeMoeda()+" "+formatarMoeda(valor_arrecadado_prato)+ "\n" +
                           "\tValor arrecadado em bebidas: "+nomeMoeda()+" "+formatarMoeda(valor_arrecadado_prod)+ "\n" +
                           "\tTOTAL ARRECADADO: "+nomeMoeda()+" "+formatarMoeda(valorTotal(valor_arrecadado_prato,valor_arrecadado_prod))+ "\n" +
                           "\t---------------------------------------------------\n");
    }

    private static void verStock(){
        System.out.println("\n\t\t                 ESTAGIO ACTUAL DO ESTOQUE\n" +
                           "\t----------------------------------------------------------------\n" +
                           "\t         DESCRICAO                  :  QUANTIDADE ACTUAL\n" +
                           "\t----------------------------------------------------------------\n" +
                           "\t1  - CERVEJA 2M.....................: " + beersAvailabe[0]+units()+"\n" +
                           "\t2  - CHAMPANHE......................: " + beersAvailabe[1]+units()+"\n" +
                           "\t3  - CERVEJA BUDWEISER..............: " + beersAvailabe[2]+units()+"\n" +
                           "\t4  - CASTLE LITE....................: " + beersAvailabe[3]+units()+"\n" +
                           "\t5  - VINHO PORTO....................: " + beersAvailabe[4]+units()+"\n" +
                           "\t6  - SPIN...........................: " + beersAvailabe[5]+units()+"\n" +
                           "\t7  - AGUA MINERAL...................: " + beersAvailabe[6]+units()+"\n" +
                           "\t8  - COCACOLA LATA..................: " + beersAvailabe[7]+units()+"\n" +
                           "\t9  - SPRITE LATA....................: " + beersAvailabe[8]+units()+"\n" +
                           "\t10 - TXILAR.........................: " + beersAvailabe[9]+units()+"\n" +
                           "\t11 - LAURENTINA PRETA...............: " + beersAvailabe[10]+units()+"\n" +
                           "\t12 - VINHO WHITE(EUA)...............: " + beersAvailabe[11]+units()+"\n" +
                           "\t13 - CERVEJA MANICA.................: " + beersAvailabe[12]+units()+"\n" +
                           "\t----------------------------------------------------------------");
    }

    private static double valorTotal(double valor_arrecadado_prato,double valor_arrecadado_prod){
        return valor_arrecadado_prato + valor_arrecadado_prod;
    }

    public static String units(){
        return " UNIDADES";
    }

    private static double valorArrecProd(byte prato, double qtd_pratos){
        valor_arrecadado_prod += (precoProduto(prato) * qtd_pratos);
        return valor_arrecadado_prod;
    }

    private static double valorArrecPrat(byte prato, double qtd_pratos){
        valor_arrecadado_prato += (precoPrato(prato) * qtd_pratos);
        return valor_arrecadado_prato;
    }

    private static String formatarMoeda(double valor) {
        DecimalFormat dc = new DecimalFormat("#,###.00");
        return dc.format(valor);
    }
     public  static String horasDataTxt(){
        return "HORAS:"+LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+" - "
                +"DATA:"+formatter.format(LocalDate.now());
     }
    public  static String horasData(){
    //gavarData(LocalTime.now().getHour()+":"+LocalTime.now().getMinute());
        return "HORAS: "+LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+""
                + "          DATA: "+formatter.format(LocalDate.now());
         //gavarData(LocalTime.now().getHour()+":"+LocalTime.now().getMinute());
    }

    private static String nomeMoeda(){
        return "MZN";
    }

    private static void BaseDadosMesa() {
            File dir = new File("C:\\My files");
            File arq = new File(dir, "Mesa.txt");

            try {
                FileReader fileReader = new FileReader(arq);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String linha = "";
                while ( ( linha = bufferedReader.readLine() ) != null) {
                System.out.println(linha);
            }

                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

     private static void BaseDadosBar() {
            File dir = new File("C:\\My files");
            File arq = new File(dir, "Bar.txt");

            try {
                FileReader fileReader = new FileReader(arq);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String linha = "";
                while ( ( linha = bufferedReader.readLine() ) != null) {
                System.out.println(linha);
            }

                fileReader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    private static void loggedAsAdmin() throws IOException {
        do{
    System.out.print("\n\t---------------------------------------"
                    + " \n\t"+horasData()+"\n\tOLA, BEM VINDO AO MOZAMBICAN’S DISHES!\n\t"
                    + "---------------------------------------\n\tAcessado por: VISITANTE/CLIENTE\n\t"
                    + "\n\tONDE DESEJA IR ? \n\t1 - BAR\n\t2 - MESA"
                    + "\n\t---------------------------------------\n"
                    + "\tInforme uma opcao: ");
            opcao = Byte.parseByte(br.readLine());
            //System.out.print(opcao);
            switch(opcao){
                case 1:
                    operacaoBar();
                    System.out.println("\n\tValor a pagar: " +nomeMoeda()+" "+formatarMoeda(valor_arrecadado_prod));
                    break;
                case 2:
                    operacaoMesa();
                    System.out.println("\n\tValor a pagar: "+nomeMoeda()+" "+formatarMoeda(valor_arrecadado_prato));
                    break;
            }
        } while (opcao != 1 && opcao != 2);
        do {
            System.out.print("\n\t1 - VER RELATORIO DE VENDAS\n\t2 - VER ESTOQUE ACTUAL\n\t3 - VERIFICAR O FICHEIRO DA BASE DE DADOS\n\t4 - VERIFICAR O FICHEIRO DA BASE DE DADOS\n\n\tDigite a opcao: ");
            opcao = Byte.parseByte(br.readLine());
            System.out.print(opcao);
            if(opcao == 1){
               relatorioVendas();
            } else if (opcao == 2){
               verStock();
            } else if (opcao == 3){
            BaseDadosMesa();
            } else if (opcao == 4){
            BaseDadosBar();
            }
            else {
               System.out.println("OPCAO INESISTENTE!");
            }
            System.out.print("\tContinuar s/n: ");
            executar_mais = br.readLine().toLowerCase().charAt(0);
            System.out.print(executar_mais);
            lerNumeroPrato(qtd);
            lerQtdPrato(qtd);
            calcularCusto(username);
        } while (executar_mais == 's');System.out.println("\n\tTERMINADO, OBRIGADO PELA PREFERENCIA.\n");
    }

    private static void loggedAsVisitor() throws IOException {
        do{
            System.out.print("\n\t---------------------------------------"
                    + " \n\t"+horasData()+"\n\tOLA, BEM VINDO AO MOZAMBICANâ€™S DISHES!\n\t"
                    + "---------------------------------------\n\tAcessado por: VISITANTE/CLIENTE\n\t"
                    + "\n\tONDE DESEJA IR ? \n\t1 - BAR\n\t2 - MESA"
                    + "\n\t---------------------------------------\n"
                    + "\tInforme uma opcao: ");
            opcao = Byte.parseByte(br.readLine());
            System.out.print(opcao);
            switch(opcao){
                case 1:
                    operacaoBar();
                    System.out.println("\n\tValor a pagar: " +nomeMoeda()+"  "+formatarMoeda(valor_arrecadado_prod));
                    break;
                case 2:
                    operacaoMesa();
                    System.out.println("\n\tValor a pagar: "+nomeMoeda()+" "+formatarMoeda(valor_arrecadado_prato));
                    break;
            }
        } while (opcao != 1 && opcao != 2);
        System.out.println("\n\tTERMINADO, OBRIGADO PELA PREFERENCIA.\n");
    }

    //
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */