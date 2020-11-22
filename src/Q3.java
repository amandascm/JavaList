package q3;

enum IdentidadeDeGenero{
    cis,
    trans,
    generoFluido,
    naoBinario
}

class Pessoa{
    //atributos
    protected String nome;
    protected int idade;
    protected String grauEscolaridade;
    protected IdentidadeDeGenero idGenero;
    protected String orientSexual;
    protected String sexo;

    //construtores
    Pessoa(){};
    Pessoa(String nome, int idade, String grauEscolaridade, IdentidadeDeGenero idGenero, String orientSexual, String sexo){
        this.nome = nome;
        this.idade = idade;
        this.grauEscolaridade = grauEscolaridade;
        this.idGenero = idGenero;
        this.orientSexual = orientSexual;
        this.sexo = sexo;
    }

    //metodos

    //setter ​somente para idade, nome, grau de escolaridade
    void setIdade(int idade){
        this.idade = idade;
    }
    void setNome(String nome){
        this.nome = nome;
    }
    void setGrau(String grauEscolaridade){
        this.grauEscolaridade = grauEscolaridade;
    }

    //getter para todos os atributos
    int getIdade(){
        return idade;
    }
    String getNome(){
        return nome;
    }
    String getGrauEscolaridade(){
        return grauEscolaridade;
    }
    IdentidadeDeGenero getIdGenero(){
        return idGenero;
    }
    String getOrientSexual(){
        return orientSexual;
    }
    String getSexo(){
        return sexo;
    }

    //comportamentos pessoa
    void dormir(){
        System.out.println("zzzzzz");
    }
    void cagar(){
        System.out.println("pluft");
    }
    void comer(){
        System.out.println("nhac");
    }
    void estudar(){
        System.out.println("-estudando-");
    }
    void sobreviver(){
        System.out.println("-sobrevivendo-");
    }
    void trabalhar(){
        System.out.println("-trabalhando-");
    }
}

class Main{
    public static void main(String[] args) {
        //instanciando pessoas com dois tipos de construtores
        Pessoa fulano = new Pessoa();
        Pessoa cicrano = new Pessoa("Cicrano", 32, "segundo grau completo", IdentidadeDeGenero.trans, "bi", "F");
        
        //setando grau de escolaridade e de cicrano
        cicrano.setGrau("primeiro grau completo");

        //printando idade de cicrano
        System.out.println(cicrano.getIdade());

        //invocando metodos de fulano
        fulano.dormir();
        fulano.sobreviver();

        //invocando metodos de cicrano
        cicrano.comer();
        cicrano.estudar();        
    }
}
