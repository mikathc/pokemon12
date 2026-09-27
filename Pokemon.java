public class Pokemon{
    //atributos que os pokemons terao
    private String nome;
    protected String tipo;
    private double nivel;
    private double hp;
    private double ataquebase;
    
    // criei os metodos getter e setter para todos os atributos da classe Pokemon
    
    //metodo get pega o atributo e exibe a informacao
    public String getNome(){
        return nome;
    }
    //o metodo set permite alterar a informacao do atributo
    public void setNome(String nome){
        if(nome.isEmpty()){
            nome = "Sem nome";
        }
        this.nome = nome;
    }
    public String mostrarTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public double getNivel(){
        return nivel;
    }
    public void setNivel(double nivel){
        if (nivel<1){
            nivel=1;
        }
        this.nivel = nivel;
    }
    public double getHp(){
        return hp;
    }
    public void setHp(double hp){
        this.hp = hp;
    }

    public double getAtaquebase(){
        return ataquebase;
    }
    public void setAtaquebase(int ataquebase){
        this.ataquebase = ataquebase;
    }

    //construtor da classe Pokemon que ira permitir criar os objetos
    public Pokemon(String nome, String tipo, int nivel, int hp, int ataquebase){
        setNome(nome);
        setTipo(tipo);
        setNivel(nivel);
        setHp(hp);
        setAtaquebase(ataquebase);
        
    }
    //metodo que as subclasses de pokemon irao herdar
    public void atacar(){
    }
}