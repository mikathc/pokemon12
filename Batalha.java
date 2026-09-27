//importacao classes importantes
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Batalha {
  //atributos
    Pokemon alvo;
    Pokemon escolhido;
    Treinador treinador;
    ArrayList<Pokemon> pokemonsAdversario;
    Scanner escolha;
   
   
    //construtor
    public Batalha(Treinador treinador, ArrayList<Pokemon> pokemonsAdversario, Scanner escolha){
      this.treinador = treinador;
      this.pokemonsAdversario= pokemonsAdversario;
      this.escolha = escolha;
    }
    //metodo da batalha
    void batalhar(){
     //gera um loop para permitir o usuario escolher qual pokemon ele quer usar na batalha
     while(true){
      int largura = 100;
      System.out.println("\n\033[1;34mSUA POKÉDEX\033[0m\n");
      treinador.listarTime();
      System.out.println();
      System.out.print("Escolha o Pokémon para batalhar:");
       if (!escolha.hasNextInt()) {
        System.out.println("\n\033[33mDigite apenas números!\033[0m");
        System.out.println("-".repeat(largura));
        escolha.next(); // descarta a letra
        continue;
    }
      int n = escolha.nextInt();

     //caso numero digitado pelo usuario esteja errado retorna uma
     // mensagem e volta para o inicio do loop
      
      if (n<1||n>treinador.pokemons.size()){
        System.out.println("Opção inválida!");
        continue;
      
      }//define o escolhido, (n-1) serve para indiciar o indice certo, por exemplo:
      //o usuario digitou 1, ele se torna o 0 da lista
       else{
         escolhido = treinador.pokemons.get(n-1);
         if (escolhido instanceof PokemonAgua){
          PokemonAgua agua = (PokemonAgua) escolhido;
          agua.pokemonTipo();
         } else if(escolhido instanceof PokemonFogo){
          PokemonFogo fogo = (PokemonFogo) escolhido;
          fogo.pokemonTipo();
         }else if(escolhido instanceof PokemonEletricidade){
          PokemonEletricidade fogo = (PokemonEletricidade) escolhido;
          fogo.pokemonTipo();
         }else if(escolhido instanceof PokemonTerra){
          PokemonTerra fogo = (PokemonTerra) escolhido;
          fogo.pokemonTipo();
         }else if(escolhido instanceof PokemonVento){
          PokemonVento vento = (PokemonVento) escolhido;
          vento.pokemonTipo();
         }
         break;
      }
      
     }
      System.out.println("\nO Pokemon escolhido: \033[32m"+escolhido.getNome()+"\033[0m - HP: "+escolhido.getHp());
      
      //gera um numero para definir o pokemon adversario
      Random random = new Random();
      //caso o escolhido já igual ao alvo, irá voltar para o menu
      while(true){
        int indicesorteado = random.nextInt(pokemonsAdversario.size());
        Pokemon pokemonsorteado = pokemonsAdversario.get(indicesorteado);
        alvo = pokemonsorteado;
        if(!alvo.getNome().equals(escolhido.getNome())){
          break;
      }System.out.println("\nSorteando o Alvo novamente!");
      }
      
      System.out.println("\033[0mPokemon alvo: \033[31m" +alvo.getNome()+"\033[0m - HP: "+alvo.getHp());


      // double nivelantigoEscolhido= escolhido.getNivel();
      // double nivelantigoAlvo= alvo.getNivel();

     // depois de selecionar os pokemons, comeca a batalha
      while (escolhido.getHp()>0 && alvo.getHp()>0){

      // se o pokemons escolhido e  alvo forem iguais, o programa barra e volta para o menu
      if (escolhido.getNome().equals(alvo.getNome())){
        System.out.println();
        System.out.println("\033[43mNão é possível batalhar contra o mesmo Pokemon que o seu!\033[0m");
        System.out.println();
        System.out.println("\033[31mTente novamente!\033[0m");
        break;

      }
      // caso ao contrario ira batalhar
      else{
        System.out.println();
      if (escolhido.getHp()>0){
       escolhido.atacar();
       int critico = ataquecritico();
       double dano;
       if (critico==2){
         dano=calculardano(escolhido,alvo);
         
       }else{
         dano=calculardano(escolhido,alvo,critico);
       }
      
       System.out.println("\033[32mDano:\033[0m "+ dano);
       receberdano(alvo,dano);
       
      } if (alvo.getHp()>0){
       alvo.atacar();
       int critico = ataquecritico();
       double dano;
       if (critico==2){
         dano=calculardano(alvo,escolhido,critico);
       }else{
         dano=calculardano(alvo,escolhido);
       }
       System.out.println("\033[31mDano:\033[0m "+dano);
       receberdano(escolhido,dano);
       System.out.println();
       if(escolhido.getHp()>0 && alvo.getHp()>0){
        System.out.println("\033[34mPRÓXIMA RODADA\033[0m"); 
       }
      }
      }
      
      }
  
      System.out.println();
     
      System.out.println();
      //define o placar final e formata para deixar melhor a escrita
      if (escolhido.getHp()>0 && alvo.getHp()<=0){
        System.out.println("\033[46mPLACAR FINAL\033[0m");
        System.out.println();
        System.out.println("\033[32mVENCEDOR:\033[0m "+ escolhido.getNome()+"\n\033[31mDERROTADO:\033[0m "+alvo.getNome());
        escolhido.setNivel(escolhido.getNivel()+2);
        alvo.setNivel(alvo.getNivel()-1);

      }
      else if (escolhido.getHp()<=0 && alvo.getHp()>0){
        System.out.println("\033[46mPLACAR FINAL\033[0m");
        System.out.println();
        System.out.println("\033[32mVENCEDOR:\033[0m "+ alvo.getNome()+"\n\033[31mDERROTADO:\033[0m "+escolhido.getNome());
        alvo.setNivel(alvo.getNivel()+2);
        escolhido.setNivel(escolhido.getNivel()-1);
      }
      //ao final da batalha atualiza o HP dos pokemons para nao entrar em loop infinito
      escolhido.setHp(100);
      alvo.setHp(100);
      // restaurarnivel(escolhido,nivelAntigoEscolhido);
      // restaurarnivel(alvo,nivelAntigoAlvo);
      
      
    }
    //metodo para verificar qual pokemon é mais forte na batalha e gerar uma vantagem
    //no seu dano
   double verificarefetividade(Pokemon escolhido, Pokemon alvo){
    // String tipoescolhido = escolhido.mostrarTipo();
    // String tipoalvo= alvo.mostrarTipo();

   if (escolhido instanceof PokemonAgua && alvo instanceof PokemonFogo) {
    return 2.0;
}
    else if (escolhido.mostrarTipo().equals("Fogo") && alvo.mostrarTipo().equals("Agua")){
        return 0.5;
    }
    else if (escolhido.mostrarTipo().equals("Eletricidade")&& alvo.mostrarTipo().equals("Agua")){
        return 2.0;
    }
    else if (escolhido.mostrarTipo().equals("Agua") && alvo.mostrarTipo().equals("Eletricidade")){
        return 0.5;
    }
    else if (escolhido.mostrarTipo().equals("Terra") && alvo.mostrarTipo().equals("Eletricidade")){
        return 2.0;
    }
    else if (escolhido.mostrarTipo().equals("Eletricidade") && alvo.mostrarTipo().equals("Terra")){
        return 0.5;
    }
     else if (escolhido.mostrarTipo().equals("Vento") && alvo.mostrarTipo().equals("Terra")){
        return 2.0;
    }
    else if (escolhido.mostrarTipo().equals("Terra") && alvo.mostrarTipo().equals("Vento")){
        return 0.5;
    }
    else{
      return 1.0;
    }
   }
   //metodo para calcular o dano que o pokemon ira gerar
   double calculardano(Pokemon escolhido, Pokemon alvo){
    double dano = escolhido.getAtaquebase()*verificarefetividade(escolhido,alvo);
      return dano;
  
   }
   double calculardano(Pokemon escolhido, Pokemon alvo, int critico){
    double dano = escolhido.getAtaquebase()*verificarefetividade(escolhido,alvo)*critico;
      return dano;
  
   }

   //metodo para calcular quanto recebe e atualizar o dano
   void receberdano(Pokemon alvo, double dano){
     double novohp= alvo.getHp() - dano;
     //garante que o HP nao retorne um  numero negativo
     if (novohp<0){
       novohp=0;
     }
     //atualiza o novo HP
     alvo.setHp(novohp);
     System.out.println(alvo.getNome()+" - HP: "+alvo.getHp());
      
   }
   //metodo que gera um numero aleatorio para definir se o 
   // pokemon tera uma vantagem no dano ou nao
   int ataquecritico(){
      Random random1 = new Random();
      int critico = random1.nextInt(101);

      if (critico<10){
        System.out.println("\033[35mATAQUE CRÍTICO\033[0m");
        return 2;
    } 
      return 1;
    }



    
   }
   
