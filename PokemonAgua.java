//extends permite a subclasse PokemonAgua herdar as caracteristicas da classe Pokemon

public class PokemonAgua extends Pokemon {
    
    //construtor da classe
    public PokemonAgua(String nome,String tipo, int nivel, int hp, int ataquebase ){

        //super cita quais atributos da superclasse Pokemon, a subclasse herdou
        super(nome,tipo,nivel,hp,ataquebase);
    }
    //o override permite herdar o metodo atacar da classe Pokemon(superclasse) 
    // e permite mudar o comportamento desse metodo
    @Override
    public void atacar(){
        System.out.println("\033[34m"+getNome() + "\033[0m lançou uma rajada de água!");
    }

    void pokemonTipo(){
        System.out.println("\nVocê escolheu um Pokemon de \033[34mÁgua!\033[0m");
        System.out.println("No Drink water!");

    }

}