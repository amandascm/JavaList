package q1;

abstract class Livro{
    //atributos
    protected String titulo;
    protected int edicao;
    protected String autorOuAutora;
}

class LivroLivraria extends Livro{
    //mais atributos
    protected int quantidadeEmEstoque;
    protected float valor;

    //construtor
    LivroLivraria(String titulo, String autorOuAutora, int edicao, int quantidadeEmEstoque, float valor){
        this.titulo = titulo;
        this.autorOuAutora = autorOuAutora;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.valor = valor;
    }

    //metodos
    public void printTitulo(){
        System.out.println(this.titulo);
    }
}

class LivroBiblioteca extends Livro{
    //mais atributos
    protected int quantidadeUnidades;
    protected int disponiveis;
    protected int emprestados;

    //construtor
    LivroBiblioteca(String titulo, String autorOuAutora, int edicao, int quantidadeUnidades){
        this.titulo = titulo;
        this.autorOuAutora = autorOuAutora;
        this.quantidadeUnidades = quantidadeUnidades;
        this.disponiveis = quantidadeUnidades;
        this.emprestados = 0;
    }

    //metodos
    public void printDisponiveis(){
        System.out.println(this.disponiveis);
    }
}

class Main{
    public static void main(String[] args) {
        
        LivroLivraria livro1 = new LivroLivraria("A Metamorfose", "Kafka", 2, 10, 40.5f);
        livro1.printTitulo();
        System.out.println(livro1.valor);
        LivroBiblioteca livro2 = new LivroBiblioteca("Teses de Abril", "Lenin", 1, 5);
        livro2.printDisponiveis();
        
    }
}