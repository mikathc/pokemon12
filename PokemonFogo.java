//extends permite a subclasse PokemonEletricidade herdar as caracteristicas da classe Pokemon

public class PokemonFogo extends Pokemon {

    //construtor da classe
    public PokemonFogo(String nome,String tipo, int nivel, int hp, int ataquebase ){

         //super cita quais atributos da superclasse Pokemon, a subclasse herdou
        super(nome,tipo,nivel,hp,ataquebase);
    }

     //o override permite herdar o metodo atacar da classe Pokemon(superclasse) 
    // e permite mudar o comportamento desse metodo
    @Override
    public void atacar(){
        System.out.println("\033[31m"+getNome() + "\033[0m lançou uma rajada de fogo");
    }
    void pokemonTipo(){
        System.out.println("\nVocê escolheu um Pokemon de \033[31mFogo!\033[0m");
        System.out.println("Não olhe para o sol!");
    }
   
}
