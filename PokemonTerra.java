//extends permite a subclasse PokemonEletricidade herdar as caracteristicas da classe Pokemon

public class PokemonTerra extends Pokemon{

    //construtor da classe
    public PokemonTerra(String nome,String tipo, int nivel, int hp, int ataquebase ){
         //super cita quais atributos da superclasse Pokemon, a subclasse herdou
        super(nome,tipo,nivel,hp,ataquebase);
    }
     //o override permite herdar o metodo atacar da classe Pokemon(superclasse) 
    // e permite mudar o comportamento desse metodo
    @Override
    public void atacar(){
        System.out.println("\033[36m"+getNome() + "\033[0m lançou uma rajada de agua");
    }

    void pokemonTipo(){
        System.out.println("\nVocê escolheu um Pokémon de \033[36mTerra!\033[0m");
        System.out.println("Não coma terra! Obs: só criança pode! Você é um marmanjo!");
    }
  
}
