
package ProjetoEstoque;

/**
 * @author Alan
 * Projeto Estoque de Supermercado
 * Prof Aldo
 * Sistemas de informação
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class PrincipalLoja {

    //ArrayList para cada classe de setores do Supermercado
    public static ArrayList<Limpeza> listaLimpeza;
    public static ArrayList<Alimento> listaalimentos;
    public static ArrayList<HingienePessoal> HingienePessoal;
    public static ArrayList<Bebidas> Bebidas;
    public static ArrayList<Hortifruti> Hortifruti;
    public static ArrayList<Utilidades> Utilidades;
    
    public static void main(String[] args) {

        //Fazer login com nome de usuario
        Scanner ler = new Scanner(System.in);
        System.out.println("Entre com nome de usuario");

        String nomeUser = ler.nextLine();
        System.out.println("Seja bem vindo: " + nomeUser);

        listaLimpeza = new ArrayList<Limpeza>();
        listaalimentos = new ArrayList<Alimento>();
        HingienePessoal = new ArrayList<HingienePessoal>();
        Bebidas = new ArrayList<Bebidas>();
        Hortifruti = new ArrayList<Hortifruti>();
        Utilidades = new ArrayList<Utilidades>();

        int menu = 0; //contador menu opções
        int cat = 0; // contador menu setores do Supermercado 
        
        Menu m = new Menu();

        m.Menu();
        menu = ler.nextInt();
        ler.nextLine();
        
        while (menu != 6) { // Se digitar a opção 6 sistema fecha
            if (menu == 0) {
                m.Menu();
                menu = ler.nextInt();
                ler.nextLine();
            }

            if (menu == 1) {//Cadastrar Produtos  
               m.MenuCategoria();
               cat = ler.nextInt();
            
               if (cat==1){
                   inserirAlimento();           
                    menu = 0;
               }
               
                if (cat==2){                    
                    inserirLimpeza();
                    menu = 0;
                }
                if (cat==3){                    
                    inserirHingienePessoal();
                    menu = 0;
                }
                if (cat==4){
                    inserirBebidas();
                    menu = 0;
                }
                if (cat==5){
                    inserirHortifruti();
                    menu = 0;
                }
                if (cat==6){
                    inserirUtilidades();
                    menu = 0;
                }
            }
            
            if (menu == 2) {// Listar todos os produtos separados por setores
                
                m.MenuCategoria();
                cat = ler.nextInt();               
                if (cat==1){
                   listarAlimento();
                    menu = 0;}
            
                if (cat==2){
                    listarLimpeza();
                    menu = 0;
            }
                if (cat==3){                    
                    listarHingienePessoal();
                    menu = 0;
                }
                if (cat==4){
                    listarBebidas();
                    menu = 0;
                }
                if (cat==5){
                    listarHortifruti();
                    menu = 0;
                }
                if (cat==6){
                    listarUtilidades();
                    menu = 0;
                }
            }
    
            if (menu == 3) {// Alterar os produtos cadastrados separados por setores
                m.MenuCategoria();
                cat = ler.nextInt();               
                if (cat==1){
                alterarAlimento();
                menu = 0;
                }
                if (cat==2){
                    alterarLimpeza();
                    menu = 0;
            }
                if (cat==3){                    
                    alterarHingienePessoal();
                    menu = 0;
                }
                if (cat==4){
                    alterarBebidas();
                    menu = 0;
                }
                if (cat==5){
                    alterarHortifruti();
                    menu = 0;
                }
                if (cat==6){
                    alterarUtilidades();
                    menu = 0;
                }
            }
            if (menu == 4) { // Excluir os produtos cadastrados separados por setores
                m.MenuCategoria();
                cat = ler.nextInt();              
                if (cat==1){
                excluirAlimento();
                menu = 0;
                }
                if (cat==2){
                    excluirLimpeza();
                    menu = 0;
            }
                if (cat==3){                    
                    excluirHingienePessoal();
                    menu = 0;
                }
                if (cat==4){
                    excluirBebidas();
                    menu = 0;
                }
                if (cat==5){
                    excluirHortifruti();
                    menu = 0;
                }
                if (cat==6){
                    excluirUtilidades();
                    menu = 0;
                }
            }
            if (menu == 5) { // Buscar um unico produto informando o codigo
                m.MenuCategoria();
                cat = ler.nextInt();               
                if (cat==1){
                buscarAlimento();
                menu = 0;
                }
                if (cat==2){
                    buscarLimpeza();
                    menu = 0;
                }
                if (cat==3){                    
                    buscarHingienePessoal();
                    menu = 0;
                }
                if (cat==4){
                    buscarBebidas();
                    menu = 0;
                }
                if (cat==5){
                    buscarHortifruti();
                    menu = 0;
                }
                if (cat==6){
                    buscarUtilidades();
                    menu = 0;
                }
            }
        }
        System.out.println("Saindo...!");

    }

    public static void listarLimpeza() { //Usando set e get para listar os produtos
        if (listaLimpeza.size() == 0) {
            System.out.println("Lista vazia");
        } else {
            for (int i = 0; i < listaLimpeza.size(); i++) {
                //atributos para visualizar a data e hora que foi cadastrado os produtos
                String sData = "dd/MM/yyyy";
                String sHora = "h:mm:ss - a";
                String sData1, sHora1;
                Date agora = new java.util.Date();
                SimpleDateFormat sdfFormata = new SimpleDateFormat(sData);
                sData1 = sdfFormata.format(agora);
                sdfFormata = new SimpleDateFormat(sHora);
                sHora1 = sdfFormata.format(agora);
                Limpeza p = listaLimpeza.get(i);

                System.out.println("Codigo:" + i + "-" + "Setor:" + p.getSetor()+ "-" + "Nome:" + p.getNome() + "-"
                        + ("Quantidade:" + p.getQuantidade() + "-" + "preço:" + "R$" + p.getPreco() + "Data de cadastro: " + sData1 + "-" + "Hora de cadastro: " + sHora1));
            }
        }
    }


    public static void excluirLimpeza() {
        Limpeza p = new Limpeza();

        Scanner ler = new Scanner(System.in);
        System.out.println("Codigo do produto para remover:");
        int codigo = ler.nextInt();
        listaLimpeza.remove(codigo);//ArrayList setor de limpeza

    }

    public static void alterarLimpeza() {
        String Novonome;
        int NovaQuant;
        float NovoPreço;
        String NovoSetor;

        Limpeza p = new Limpeza();
        Scanner ler = new Scanner(System.in);

        System.out.println("Codigo do produto para alterar:");
        int codigo = ler.nextInt();
        ler = new Scanner(System.in);
        System.out.println("Nome do produto novo");
        Novonome = ler.nextLine();
        System.out.println("Quantidade de produtos novos");
        NovaQuant = ler.nextInt();
        System.out.println("Preço do produto novo");
        NovoPreço = ler.nextFloat();
        ler = new Scanner(System.in);
        System.out.println("Setor do produto novo");
        NovoSetor = ler.nextLine();
        
        //ArrayList setor de limpeza
        listaLimpeza.get(codigo).setNome(Novonome);
        listaLimpeza.get(codigo).setPreco(NovoPreço);
        listaLimpeza.get(codigo).setQuantidade(NovaQuant);
        listaLimpeza.get(codigo).setSetor(NovoSetor);
    }

    public static void buscarLimpeza() {
        if (listaLimpeza.size() == 0) {
            System.out.println("Lista vazia");
        } else {
            int i = 0;
            Scanner ler = new Scanner(System.in);
            System.out.println("Insira o codigo para buscar:");
            i = ler.nextInt();

            String sData = "dd/MM/yyyy";
            String sHora = "h:mm:ss - a";
            String sData1, sHora1;
            Date agora = new java.util.Date();
            SimpleDateFormat sdfFormata = new SimpleDateFormat(sData);
            sData1 = sdfFormata.format(agora);
            sdfFormata = new SimpleDateFormat(sHora);
            sHora1 = sdfFormata.format(agora);

            Limpeza p = listaLimpeza.get(i);//ArrayList setor de limpeza
            System.out.println("Codigo:" + i + "-" + "Setor:" + p.getSetor()+ "-"+ "Nome:" + p.getNome() + "-"
                    + ("Quantidade:" + p.getQuantidade() + "-" + "preço:" + "R$" + p.getPreco() + "Data de cadastro: " + sData1 + "-" + "Hora de cadastro: " + sHora1));
        }
    }

    public static void inserirLimpeza() {
        String nome;       
        int codigo = 0;
        int quant;
        float preco;
        String setor;
        

        Scanner ler = new Scanner(System.in);
        System.out.println("Nome do produto");
        nome = ler.nextLine();
        ler = new Scanner(System.in);
        System.out.println("Quantidade de produtos");
        quant = ler.nextInt();
        System.out.println("Preço do produto");
        preco = ler.nextFloat();
        ler = new Scanner(System.in);
        System.out.println("Setor do produto");
        setor = ler.nextLine();
        
       
        Limpeza p = new Limpeza();
        p.setNome(nome);
        p.setCodigo(codigo);
        p.setPreco(preco);
        p.setQuantidade(quant);
        p.setSetor(setor);        

        listaLimpeza.add(p);////Adiciona o produto no ArrayList setor de limpeza

    }
    //_________________________________________________________________________
    
    public static void inserirAlimento() {
        
        String nome;
        String setor;
        int codigo = 0;
        int quant;
        float preco;
                
        Scanner ler = new Scanner(System.in);
        System.out.println("Nome do produto");
        nome = ler.nextLine();
        ler = new Scanner(System.in);       
        System.out.println("Quantidade de produtos");
        quant = ler.nextInt();
        System.out.println("Preço do produto");
        preco = ler.nextFloat();
        ler = new Scanner(System.in);
        System.out.println("Setor do produto");
        setor = ler.nextLine();
        
        ////Adiciona o produto no ArrayList setor de Alimento
        Alimento a = new Alimento();
        a.setnome(nome);
        a.setCodigo(codigo);
        a.setPreco(preco);
        a.setQuantidade(quant);
        a.setSetor(setor);
        listaalimentos.add(a);       
}
     public static void listarAlimento() { //Usando set e get para listar os produtos
        if (listaalimentos.size() == 0) {
            System.out.println("Lista vazia");
        } else {
            for (int i = 0; i < listaalimentos.size(); i++) {
                //atributos para visualizar a data e hora que foi cadastrado os produtos
                String sData = "dd/MM/yyyy";
                String sHora = "h:mm:ss - a";
                String sData1, sHora1;
                Date agora = new java.util.Date();
                SimpleDateFormat sdfFormata = new SimpleDateFormat(sData);
                sData1 = sdfFormata.format(agora);
                sdfFormata = new SimpleDateFormat(sHora);
                sHora1 = sdfFormata.format(agora);
                Alimento a = listaalimentos.get(i);
                System.out.println("Codigo:" + i + "-"+"Setor:" + a.getSetor()+ "-" + "Nome:" + a.getnome() + "-"
                        + ("Quantidade:" + a.getQuantidade() + "-" + "preço:" + "R$" + a.getPreco() + "Data de cadastro: " + sData1 + "-" + "Hora de cadastro: " + sHora1));
            }
        }
    }
         public static void buscarAlimento() {
        if (listaalimentos.size() == 0) {
            System.out.println("Lista vazia");
        } else {
            int i = 0;
            Scanner ler = new Scanner(System.in);
            System.out.println("Insira o codigo para buscar:");
            i = ler.nextInt();

            String sData = "dd/MM/yyyy";
            String sHora = "h:mm:ss - a";
            String sData1, sHora1;
            Date agora = new java.util.Date();
            SimpleDateFormat sdfFormata = new SimpleDateFormat(sData);
            sData1 = sdfFormata.format(agora);
            sdfFormata = new SimpleDateFormat(sHora);
            sHora1 = sdfFormata.format(agora);

            Alimento a = listaalimentos.get(i);
            System.out.println("Codigo:" + i +"Setor:" + a.getSetor()+ "-" + "Nome:" + a.getnome() + "-"
                    + ("Quantidade:" + a.getQuantidade() + "-" + "preço:" + "R$" + a.getPreco() + "Data de cadastro: " + sData1 + "-" + "Hora de cadastro: " + sHora1));
        }
    }
         
        public static void alterarAlimento() {
        String Novonome;
        int NovaQuant;
        float NovoPreço;
        String NovoSetor;

        Limpeza p = new Limpeza();
        Scanner ler = new Scanner(System.in);

        System.out.println("Codigo do produto para alterar:");
        int codigo = ler.nextInt();
        ler = new Scanner(System.in);
        System.out.println("Nome do produto novo");
        Novonome = ler.nextLine();
        System.out.println("Quantidade de produtos novos");
        NovaQuant = ler.nextInt();
        System.out.println("Preço do produto novo");
        NovoPreço = ler.nextFloat();
        ler = new Scanner(System.in);
        System.out.println("Setor do produto novo");
        NovoSetor = ler.nextLine();
        listaalimentos.get(codigo).setnome(Novonome);
        listaalimentos.get(codigo).setPreco(NovoPreço);
        listaalimentos.get(codigo).setQuantidade(NovaQuant);
        listaalimentos.get(codigo).setSetor(NovoSetor);
    }
       public static void excluirAlimento() {
        Alimento a = new Alimento();

        Scanner ler = new Scanner(System.in);
        System.out.println("Codigo do produto para remover:");
        int codigo = ler.nextInt();
        listaalimentos.remove(codigo);

    }
    //________________________________________________________________________
       
       public static void inserirHingienePessoal() {
        
        String nome;
        String setor;
        int codigo = 0;
        int quant;
        float preco;
                
        Scanner ler = new Scanner(System.in);
        System.out.println("Nome do produto");
        nome = ler.nextLine();
        ler = new Scanner(System.in);       
        System.out.println("Quantidade de produtos");
        quant = ler.nextInt();
        System.out.println("Preço do produto");
        preco = ler.nextFloat();
        ler = new Scanner(System.in);
        System.out.println("Setor do produto");
        setor = ler.nextLine();
        
        HingienePessoal h = new HingienePessoal();
        h.setnome(nome);
        h.setCodigo(codigo);
        h.setPreco(preco);
        h.setQuantidade(quant);
        h.setSetor(setor);
        HingienePessoal.add(h); 
       }
       
       public static void listarHingienePessoal() { //Usando set e get para listar os produtos
        if (HingienePessoal.size() == 0) {
            System.out.println("Lista vazia");
        } else {
            for (int i = 0; i < HingienePessoal.size(); i++) {
                //atributos para visualizar a data e hora que foi cadastrado os produtos
                String sData = "dd/MM/yyyy";
                String sHora = "h:mm:ss - a";
                String sData1, sHora1;
                Date agora = new java.util.Date();
                SimpleDateFormat sdfFormata = new SimpleDateFormat(sData);
                sData1 = sdfFormata.format(agora);
                sdfFormata = new SimpleDateFormat(sHora);
                sHora1 = sdfFormata.format(agora);
                HingienePessoal h = HingienePessoal.get(i);
                System.out.println("Codigo:" + i + "-"+"Setor:" + h.getSetor()+ "-" + "Nome:" + h.getnome() + "-"
                        + ("Quantidade:" + h.getQuantidade() + "-" + "preço:" + "R$" + h.getPreco() + "Data de cadastro: " + sData1 + "-" + "Hora de cadastro: " + sHora1));
            }
        }
    }
       public static void buscarHingienePessoal() {
        if (HingienePessoal.size() == 0) {
            System.out.println("Lista vazia");
        } else {
            int i = 0;
            Scanner ler = new Scanner(System.in);
            System.out.println("Insira o codigo para buscar:");
            i = ler.nextInt();

            String sData = "dd/MM/yyyy";
            String sHora = "h:mm:ss - a";
            String sData1, sHora1;
            Date agora = new java.util.Date();
            SimpleDateFormat sdfFormata = new SimpleDateFormat(sData);
            sData1 = sdfFormata.format(agora);
            sdfFormata = new SimpleDateFormat(sHora);
            sHora1 = sdfFormata.format(agora);

            HingienePessoal h = HingienePessoal.get(i);
            System.out.println("Codigo:" + i +"-"+"Setor:" + h.getSetor()+ "-" + "Nome:" + h.getnome() + "-"
                    + ("Quantidade:" + h.getQuantidade() + "-" + "preço:" + "R$" + h.getPreco() + "Data de cadastro: " + sData1 + "-" + "Hora de cadastro: " + sHora1));
        }
    }
       
     public static void alterarHingienePessoal() {
        String Novonome;
        int NovaQuant;
        float NovoPreço;
        String NovoSetor;

        HingienePessoal h = new HingienePessoal();
        Scanner ler = new Scanner(System.in);

        System.out.println("Codigo do produto para alterar:");
        int codigo = ler.nextInt();
        ler = new Scanner(System.in);
        System.out.println("Nome do produto novo");
        Novonome = ler.nextLine();
        System.out.println("Quantidade de produtos novos");
        NovaQuant = ler.nextInt();
        System.out.println("Preço do produto novo");
        NovoPreço = ler.nextFloat();
        ler = new Scanner(System.in);
        System.out.println("Setor do produto novo");
        NovoSetor = ler.nextLine();
        HingienePessoal.get(codigo).setnome(Novonome);
        HingienePessoal.get(codigo).setPreco(NovoPreço);
        HingienePessoal.get(codigo).setQuantidade(NovaQuant);
        HingienePessoal.get(codigo).setSetor(NovoSetor);
    }
     
     public static void excluirHingienePessoal() {
        HingienePessoal h = new HingienePessoal();

        Scanner ler = new Scanner(System.in);
        System.out.println("Codigo do produto para remover:");
        int codigo = ler.nextInt();
        HingienePessoal.remove(codigo);
    }
 //___________________________________________________________________________ 

    public static void inserirBebidas() {
        
        String nome;
        String setor;
        int codigo = 0;
        int quant;
        float preco;
                
        Scanner ler = new Scanner(System.in);
        System.out.println("Nome do produto");
        nome = ler.nextLine();
        ler = new Scanner(System.in);       
        System.out.println("Quantidade de produtos");
        quant = ler.nextInt();
        System.out.println("Preço do produto");
        preco = ler.nextFloat();
        ler = new Scanner(System.in);
        System.out.println("Setor do produto");
        setor = ler.nextLine();
        
        Bebidas b = new Bebidas();
        b.setnome(nome);
        b.setCodigo(codigo);
        b.setPreco(preco);
        b.setQuantidade(quant);
        b.setSetor(setor);
        Bebidas.add(b); 
       }

    public static void listarBebidas() { //Usando set e get para listar os produtos
        if (Bebidas.size() == 0) {
            System.out.println("Lista vazia");
        } else {
            for (int i = 0; i < Bebidas.size(); i++) {
                //atributos para visualizar a data e hora que foi cadastrado os produtos
                String sData = "dd/MM/yyyy";
                String sHora = "h:mm:ss - a";
                String sData1, sHora1;
                Date agora = new java.util.Date();
                SimpleDateFormat sdfFormata = new SimpleDateFormat(sData);
                sData1 = sdfFormata.format(agora);
                sdfFormata = new SimpleDateFormat(sHora);
                sHora1 = sdfFormata.format(agora);
                Bebidas b = Bebidas.get(i);
                System.out.println("Codigo:" + i + "-"+"Setor:" + b.getSetor()+ "-" + "Nome:" + b.getnome() + "-"
                        + ("Quantidade:" + b.getQuantidade() + "-" + "preço:" + "R$" + b.getPreco() + "Data de cadastro: " + sData1 + "-" + "Hora de cadastro: " + sHora1));
            }
        }
    }
    public static void buscarBebidas() {
        if (Bebidas.size() == 0) {
            System.out.println("Lista vazia");
        } else {
            int i = 0;
            Scanner ler = new Scanner(System.in);
            System.out.println("Insira o codigo para buscar:");
            i = ler.nextInt();

            String sData = "dd/MM/yyyy";
            String sHora = "h:mm:ss - a";
            String sData1, sHora1;
            Date agora = new java.util.Date();
            SimpleDateFormat sdfFormata = new SimpleDateFormat(sData);
            sData1 = sdfFormata.format(agora);
            sdfFormata = new SimpleDateFormat(sHora);
            sHora1 = sdfFormata.format(agora);

            Bebidas b = Bebidas.get(i);
            System.out.println("Codigo:" + i +"-"+"Setor:" + b.getSetor()+ "-" + "Nome:" + b.getnome() + "-"
                    + ("Quantidade:" + b.getQuantidade() + "-" + "preço:" + "R$" + b.getPreco() + "Data de cadastro: " + sData1 + "-" + "Hora de cadastro: " + sHora1));
        }
    }
    
    public static void alterarBebidas() {
        String Novonome;
        int NovaQuant;
        float NovoPreço;
        String NovoSetor;

        Bebidas b = new Bebidas();
        Scanner ler = new Scanner(System.in);

        System.out.println("Codigo do produto para alterar:");
        int codigo = ler.nextInt();
        ler = new Scanner(System.in);
        System.out.println("Nome do produto novo");
        Novonome = ler.nextLine();
        System.out.println("Quantidade de produtos novos");
        NovaQuant = ler.nextInt();
        System.out.println("Preço do produto novo");
        NovoPreço = ler.nextFloat();
        ler = new Scanner(System.in);
        System.out.println("Setor do produto novo");
        NovoSetor = ler.nextLine();
        Bebidas.get(codigo).setnome(Novonome);
        Bebidas.get(codigo).setPreco(NovoPreço);
        Bebidas.get(codigo).setQuantidade(NovaQuant);
        Bebidas.get(codigo).setSetor(NovoSetor);
    }
    
    public static void excluirBebidas() {
        Bebidas b = new Bebidas();

        Scanner ler = new Scanner(System.in);
        System.out.println("Codigo do produto para remover:");
        int codigo = ler.nextInt();
        Bebidas.remove(codigo);
    }
//____________________________________________________________________________//
    
    public static void inserirHortifruti() {
        
        String nome;
        String setor;
        int codigo = 0;
        int quant;
        float preco;
        float kg;
                
        Scanner ler = new Scanner(System.in);
        System.out.println("Nome do produto");
        nome = ler.nextLine();
        ler = new Scanner(System.in);       
        System.out.println("Quantidade de produtos");
        quant = ler.nextInt();
        System.out.println("Kg do produto");
        kg = ler.nextFloat();
        System.out.println("Preço do produto");
        preco = ler.nextFloat();
        ler = new Scanner(System.in);
        System.out.println("Setor do produto");
        setor = ler.nextLine();
        
        Hortifruti f = new Hortifruti();
        f.setnome(nome);
        f.setCodigo(codigo);
        f.setPreco(preco);
        f.setQuantidade(quant);
        f.setSetor(setor);
        f.setKg(kg);
        Hortifruti.add(f); 
       }
    
    public static void listarHortifruti() { //Usando set e get para listar os produtos
        if (Hortifruti.size() == 0) {
            System.out.println("Lista vazia");
        } else {
            for (int i = 0; i < Hortifruti.size(); i++) {
                //atributos para visualizar a data e hora que foi cadastrado os produtos
                String sData = "dd/MM/yyyy";
                String sHora = "h:mm:ss - a";
                String sData1, sHora1;
                Date agora = new java.util.Date();
                SimpleDateFormat sdfFormata = new SimpleDateFormat(sData);
                sData1 = sdfFormata.format(agora);
                sdfFormata = new SimpleDateFormat(sHora);
                sHora1 = sdfFormata.format(agora);
                Hortifruti f = Hortifruti.get(i);
                System.out.println("Codigo:" + i + "-"+"Setor:" + f.getSetor()+ "-" + "Nome:" + f.getnome() + "-"
                        + ("Quantidade:" + f.getQuantidade()+ "-" + "Kg:"+ f.getKg() + "-" + "preço:" + "R$" + f.getPreco() + "Data de cadastro: " + sData1 + "-" + "Hora de cadastro: " + sHora1));
            }
        }
    }
    public static void buscarHortifruti() {
        if (Hortifruti.size() == 0) {
            System.out.println("Lista vazia");
        } else {
            int i = 0;
            Scanner ler = new Scanner(System.in);
            System.out.println("Insira o codigo para buscar:");
            i = ler.nextInt();

            String sData = "dd/MM/yyyy";
            String sHora = "h:mm:ss - a";
            String sData1, sHora1;
            Date agora = new java.util.Date();
            SimpleDateFormat sdfFormata = new SimpleDateFormat(sData);
            sData1 = sdfFormata.format(agora);
            sdfFormata = new SimpleDateFormat(sHora);
            sHora1 = sdfFormata.format(agora);

            Hortifruti f = Hortifruti.get(i);
            System.out.println("Codigo:" + i +"-"+"Setor:" + f.getSetor()+ "-" + "Nome:" + f.getnome() + "-"
                    + ("Quantidade:" + f.getQuantidade() + "-" + "Kg:"+ f.getKg() + "-" + "preço:" + "R$" + f.getPreco() + "Data de cadastro: " + sData1 + "-" + "Hora de cadastro: " + sHora1));
        }
    }
    public static void alterarHortifruti() {
        String Novonome;
        int NovaQuant;
        float NovoPreço;
        String NovoSetor;
        float NovoKg;

        Hortifruti b = new Hortifruti();
        Scanner ler = new Scanner(System.in);

        System.out.println("Codigo do produto para alterar:");
        int codigo = ler.nextInt();
        ler = new Scanner(System.in);
        System.out.println("Nome do produto novo");
        Novonome = ler.nextLine();
        System.out.println("Quantidade de produtos novos");
        NovaQuant = ler.nextInt();
        System.out.println("Quantidade de Kg novos");
        NovoKg = ler.nextFloat();
        System.out.println("Preço do produto novo");
        NovoPreço = ler.nextFloat();
        ler = new Scanner(System.in);
        System.out.println("Setor do produto novo");
        NovoSetor = ler.nextLine();
        Hortifruti.get(codigo).setnome(Novonome);
        Hortifruti.get(codigo).setPreco(NovoPreço);
        Hortifruti.get(codigo).setQuantidade(NovaQuant);
        Hortifruti.get(codigo).setSetor(NovoSetor);
        Hortifruti.get(codigo).setKg(NovoKg);
    }
    
    public static void excluirHortifruti() {
        Hortifruti f = new Hortifruti();

        Scanner ler = new Scanner(System.in);
        System.out.println("Codigo do produto para remover:");
        int codigo = ler.nextInt();
        Hortifruti.remove(codigo);
    }
//____________________________________________________________________________//
    
    public static void inserirUtilidades() {
        
        String nome;
        String setor;
        int codigo = 0;
        int quant;
        float preco;
                
        Scanner ler = new Scanner(System.in);
        System.out.println("Nome do produto");
        nome = ler.nextLine();
        ler = new Scanner(System.in);       
        System.out.println("Quantidade de produtos");
        quant = ler.nextInt();
        System.out.println("Preço do produto");
        preco = ler.nextFloat();
        ler = new Scanner(System.in);
        System.out.println("Setor do produto");
        setor = ler.nextLine();
        
        Utilidades u = new Utilidades();
        u.setnome(nome);
        u.setCodigo(codigo);
        u.setPreco(preco);
        u.setQuantidade(quant);
        u.setSetor(setor);
        Utilidades.add(u); 
       }

    public static void listarUtilidades() { //Usando set e get para listar os produtos
        if (Utilidades.size() == 0) {
            System.out.println("Lista vazia");
        } else {
            for (int i = 0; i < Utilidades.size(); i++) {
                //atributos para visualizar a data e hora que foi cadastrado os produtos
                String sData = "dd/MM/yyyy";
                String sHora = "h:mm:ss - a";
                String sData1, sHora1;
                Date agora = new java.util.Date();
                SimpleDateFormat sdfFormata = new SimpleDateFormat(sData);
                sData1 = sdfFormata.format(agora);
                sdfFormata = new SimpleDateFormat(sHora);
                sHora1 = sdfFormata.format(agora);
                Utilidades u = Utilidades.get(i);
                System.out.println("Codigo:" + i + "-"+"Setor:" + u.getSetor()+ "-" + "Nome:" + u.getnome() + "-"
                        + ("Quantidade:" + u.getQuantidade() + "-" + "preço:" + "R$" + u.getPreco() + "Data de cadastro: " + sData1 + "-" + "Hora de cadastro: " + sHora1));
            }
        }
    }
    
    public static void buscarUtilidades() {
        if (Utilidades.size() == 0) {
            System.out.println("Lista vazia");
        } else {
            int i = 0;
            Scanner ler = new Scanner(System.in);
            System.out.println("Insira o codigo para buscar:");
            i = ler.nextInt();

            String sData = "dd/MM/yyyy";
            String sHora = "h:mm:ss - a";
            String sData1, sHora1;
            Date agora = new java.util.Date();
            SimpleDateFormat sdfFormata = new SimpleDateFormat(sData);
            sData1 = sdfFormata.format(agora);
            sdfFormata = new SimpleDateFormat(sHora);
            sHora1 = sdfFormata.format(agora);

            Utilidades u = Utilidades.get(i);
            System.out.println("Codigo:" + i +"-"+"Setor:" + u.getSetor()+ "-" + "Nome:" + u.getnome() + "-"
                    + ("Quantidade:" + u.getQuantidade() + "-" + "preço:" + "R$" + u.getPreco() + "Data de cadastro: " + sData1 + "-" + "Hora de cadastro: " + sHora1));
        }
    }
    
    public static void alterarUtilidades() {
        String Novonome;
        int NovaQuant;
        float NovoPreço;
        String NovoSetor;

        Utilidades u = new Utilidades();
        Scanner ler = new Scanner(System.in);

        System.out.println("Codigo do produto para alterar:");
        int codigo = ler.nextInt();
        ler = new Scanner(System.in);
        System.out.println("Nome do produto novo");
        Novonome = ler.nextLine();
        System.out.println("Quantidade de produtos novos");
        NovaQuant = ler.nextInt();
        System.out.println("Preço do produto novo");
        NovoPreço = ler.nextFloat();
        ler = new Scanner(System.in);
        System.out.println("Setor do produto novo");
        NovoSetor = ler.nextLine();
        Utilidades.get(codigo).setnome(Novonome);
        Utilidades.get(codigo).setPreco(NovoPreço);
        Utilidades.get(codigo).setQuantidade(NovaQuant);
        Utilidades.get(codigo).setSetor(NovoSetor);
    }
    
    public static void excluirUtilidades() {
        Bebidas b = new Bebidas();

        Scanner ler = new Scanner(System.in);
        System.out.println("Codigo do produto para remover:");
        int codigo = ler.nextInt();
        Utilidades.remove(codigo);
    }
}

