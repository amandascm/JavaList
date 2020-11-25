package q5;

abstract class Pessoa{
    //atributos
    protected String nome;
    protected String cpf;
    //metodos
    abstract void setNome(String nome);
    abstract void setCpf(String cpf);
    protected String getNome(){
        return nome;
    }
    protected String getCpf(){
        return cpf;
    }
}

class Professor extends Pessoa{
    //construtor
    Professor(String nome, String cpf, String area, String formacao){
        this.nome = nome;
        this.cpf = cpf;
        this.area = area;
        this.formacao = formacao;
    }
    //atributos
    protected String area;
    protected String formacao;
    //metodos
    protected void setNome(String nome){
        this.nome = nome;
    }
    protected void setCpf(String cpf){
        this.cpf = cpf;
    }
    protected void setArea(String area){
        this.area = area;
    }
    protected void setFormacao(String formacao){
        this.formacao = formacao;
    }
    protected String getArea(){
        return this.area;
    }
    protected String getFormacao(){
        return this.formacao;
    }
}

class Aluno extends Pessoa{
    //construtor
    Aluno(String nome, String cpf, String matricula, String curso){
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.curso = curso;
    }
    //atributos
    protected String matricula;
    protected String curso;
    //metodos
    protected void setNome(String nome){
        this.nome = nome;
    }
    protected void setCpf(String cpf){
        this.cpf = cpf;
    }
    protected void setMatricula(String matricula){
        this.matricula = matricula;
    }
    protected void setCurso(String curso){
        this.curso = curso;
    }
    protected String getMatricula(){
        return this.matricula;
    }
    protected String getCurso(){
        return this.curso;
    }
}

class ColecaoVetor implements Colecao{
    //atributos
    protected Pessoa[] dados;
    protected int vagas;
    //construtor
    ColecaoVetor(){
        dados = new Pessoa[5];
        vagas = 5;
    }
    //metodos
    public void inserir(Pessoa p){
        dados[dados.length - vagas] = p;
        vagas--;
        System.out.println("Nome da pessoa inserida: " + p.getNome());
        System.out.println("Quantidade de vagas de insercao na colecao: " + tamanhoColecaoNaoNull());
    }
    public int tamanhoColecaoNaoNull(){
        return vagas;
    }
}

interface Colecao{
    public void inserir(Pessoa p);
    public int tamanhoColecaoNaoNull();
}

class Main{
    public static void main(String[] args) {
        //instancia da classe ColecaoVetor
        ColecaoVetor colecaoPessoas = new ColecaoVetor();
        //inserindo aluno Juliano
        colecaoPessoas.inserir(new Aluno("Julia", "099", "1224", "design"));
        //inserindo aluna Maria
        colecaoPessoas.inserir(new Aluno("Maria", "580", "1239", "arquitetura"));
        //inserindo professora Katia
        colecaoPessoas.inserir(new Professor("Katia", "900", "exatas", "ciencia da computacao"));
    }
}
