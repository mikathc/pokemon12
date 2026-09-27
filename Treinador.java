
//para criar as listas eu precisei importá-las
import java.util.ArrayList;
public class Treinador  {

    //atributo da classe
    String nome;

    //a lista com os pokemons para gerar a Pokedex do usuario
    ArrayList<Pokemon> pokemons= new ArrayList<>();

    //construtor da classe
    //criei uma variavel (pokemonincial), pois a lista precisa ter pelo menos 1 pokemon inicialmente
    public Treinador(String nome, Pokemon pokemonincial){
        this.nome=nome;
        pokemons.add(pokemonincial);
       

    }
    //metodo que ira exibir todos os pokemons que tem dentro da lista e suas informacoes
    void listarTime(){

        System.out.println("Treinador(a): "+nome);
        int contador = 1;
        for (Pokemon pokemon:pokemons){
            System.out.println("\n"+contador+" - "+pokemon.getNome()+"- Tipo: "+
            pokemon.mostrarTipo()+" - Nível: "+pokemon.getNivel()
            +" HP: "+pokemon.getHp()+" - Ataque base: "
            +pokemon.getAtaquebase());

            contador++;
        }
   
    }
    //percorre a lista e permite que cada pokemon execute seu proprio atacar()
    public void atacar(){
        for(Pokemon pokemon:pokemons){
            pokemon.atacar();
        }
    }
}
