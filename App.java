//importacao para fazer as listas
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App{

    //inicia o sistema
    public static void main (String[]args){

     //criacao dos objetos pokemons
      Pokemon poseidon= new PokemonAgua("Poseidon","Agua",2,100,20);
      Pokemon thor= new PokemonEletricidade("Thor","Eletricidade",4,100,20);
      Pokemon raiva= new PokemonFogo("Raiva","Fogo",7,100,20);
      Pokemon tarzan= new PokemonTerra("Tarzan","Terra",2,100,20);
      Pokemon furacao= new PokemonVento("Furacão","Vento",1,100,20);
      
      //objeto treinador, nome e o pokemon que estará incialmente na lista 
      Treinador treinador = new Treinador("Livia",thor);
    // Treinador treinador2 = new Treinador("Marina",poseidon);
      
   // lista com os Pokémon que poderão ser escolhidos como adversários
      ArrayList<Pokemon> pokemonsAdversario = new ArrayList<>();
        pokemonsAdversario.add(poseidon);
        pokemonsAdversario.add(raiva);
        pokemonsAdversario.add(furacao);
        pokemonsAdversario.add(tarzan);
        pokemonsAdversario.add(thor);
        
        //formatacao dos textos, para deixar como estética melhor
        String texto = "POKÉMON";
        int largura = 100;

        System.out.println("-".repeat(largura));
        System.out.println("\033[33m ".repeat((largura - texto.length()) / 2) + texto+"\033[0m");
        System.out.println("-".repeat(largura));

        //ira scannear o que o usuario digitar
        Scanner escolha = new Scanner(System.in);

        //gera um loop para o menu
        while(true){
            System.out.println();
            
            System.out.println("\033[36mMENU\033[0m");
            System.out.print("\n\033[35m1\033[0m - Capturar\n\033[33m2\033[0m - Pokédex\n\033[34m3\033[0m - Batalhar\n\033[31m4\033[0m - Sair\n\nSELECIONE UMA DAS OPÇÕES ACIMA:"); //input para perguntar a escolha
          
           if (!escolha.hasNextInt()) {
            System.out.println("\n\033[33mDigite apenas números!\033[0m");
            System.out.println("-".repeat(largura));
            escolha.next(); // descarta a letra
            continue;
    }
            int menu = escolha.nextInt();
            System.out.println();
            
        // direciona o usuario para a CAPTURA, atraves do metodo capturar()
        if(menu==1){
            System.out.println("-".repeat(100));
            System.out.println("\n\033[35mCAPTURAR\033[0m");
            System.out.println();
            capturar(pokemonsAdversario,treinador.pokemons);
            System.out.println();
            System.out.print("-".repeat(100));
            System.out.println();
            
            
        }
        //direciona o usuario para a POKEDEX, atraves do metodo listarTime()
        else if(menu==2){
            System.out.println("-".repeat(100));
            System.out.println("\n\033[1;34mPOKÉDEX\033[0m");
             System.out.println();

           // lista todos os pokemons na pokedex
            treinador.listarTime();
            
            System.out.println();
            System.out.print("-".repeat(100));
            System.out.println();
            
        }
        //direciona o usuario para a BATALHA, atraves do metodo batalhar()
        else if(menu==3){
            System.out.println("-".repeat(100));
            System.out.println();
            System.out.println("=".repeat(largura));
            System.out.println("\n\033[1;32mINICIANDO BATALHA\033[0m\n");
            System.out.println("=".repeat(largura));
            System.out.println(); 
            
            //crie um objeto batalha usando os parametros necessarios
            Batalha batalha = new Batalha(treinador,pokemonsAdversario,escolha);
            //chama a bataha
            batalha.batalhar();
            System.out.println();
            System.out.print("-".repeat(100));
            System.out.println();
            
            
        }
        //encerra o sistema
        else if(menu==4){
            System.out.println("-".repeat(100));
            System.out.println("\n\033[1;36mFINALIZANDO... ATÉ A PRÓXIMA!\033[0m");
            break;
             
            

        }
        else{
            //caso o usuario digite um numero invalido, exibe a mensagem e 
            // retorna para o menu de novo
            System.out.println("-".repeat(100));
            System.out.println("\n\033[31mOpção inválida\033[0m");
            System.out.println();
            System.out.println("-".repeat(100));
            System.out.println();
          
        }
        
        }
        //fecha o scanner
        escolha.close();
    }

    // metodo que permite tentar capturar algum pokemon
    static void capturar(ArrayList<Pokemon> pokemonsAdversario, ArrayList<Pokemon> pokemons){
        Random random2 = new Random();
        int numerocaptura = random2.nextInt(101);
        if (numerocaptura<50){
            Random random3 = new Random();
            int pokemoncapturado = random3.nextInt(pokemonsAdversario.size());
            Pokemon nomepokemoncapturado = pokemonsAdversario.get(pokemoncapturado);
            
            //verifica se o pokemon esta dentro da lista pokemons(pokedex)
            boolean nalista= false;
            for (Pokemon pokemon:pokemons){
            if (nomepokemoncapturado.getNome().equals(pokemon.getNome())){
                nalista=true;
                break;
            }
            }
            //se estiver na lista ele exibe uma mensagem
            if (nalista){
                System.out.println(nomepokemoncapturado.getNome()+" já está na sua POKÉDEX");
            }
            // se nao estiver na lista e conseguir capturar, adiciona o pokemon na pokedex
            else if (nalista==false){
                pokemons.add(nomepokemoncapturado);
                System.out.println(nomepokemoncapturado.getNome());
                System.out.println("VOCÊ CONSEGUIU CAPTURAR!");
            }
        }

        //caso nao consiga capturar, exibe uma mensagem
        else{
            System.out.println("Não conseguiu capturar");
            
        }

        
    }
    

    
}


