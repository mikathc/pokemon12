//extends permite a subclasse PokemonEletricidade herdar as caracteristicas da classe Pokemon

public class PokemonVento extends Pokemon{
    //construtor da classe
    public PokemonVento (String nome,String tipo, int nivel, int hp, int ataquebase ){

         //super cita quais atributos da superclasse Pokemon, a subclasse herdou
        super(nome,tipo,nivel,hp,ataquebase);
    }
     //o override permite herdar o metodo atacar da classe Pokemon(superclasse) 
    // e permite mudar o comportamento desse metodo
    @Override
    public void atacar(){
        System.out.println("\033[35m"+getNome() + "\033[0m lançou uma rajada de vento!");
    }
    void pokemonTipo(){
        System.out.println("\nVocê escolheu um Pokémon de \033[35mVento!\033[0m");
        System.out.println("Don't fly! Is danger");
    }
}
