package q1;

abstract class Livro{
    //atributos
    protected String titulo;
    protected int edicao;
    protected String autorOuAutora;
}

class LivroLivraria extends Livro{
    //mais atributos
    private int quantidadeEmEstoque;
    private float valor;

    //construtor
    LivroLivraria(String titulo, String autorOuAutora, int edicao, int quantidadeEmEstoque, float valor){
        this.titulo = titulo;
        this.autorOuAutora = autorOuAutora;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
        this.valor = valor;
    }

    //metodos
    public void getTitulo(){
        System.out.println(this.titulo);
    }
}

class LivroBiblioteca extends Livro{
    //mais atributos
    private int quantidadeUnidades;
    private int disponiveis;
    private int emprestados;

    //construtor
    LivroBiblioteca(String titulo, String autorOuAutora, int edicao, int quantidadeUnidades){
        this.titulo = titulo;
        this.autorOuAutora = autorOuAutora;
        this.quantidadeUnidades = quantidadeUnidades;
        this.disponiveis = quantidadeUnidades;
        this.emprestados = 0;
    }

    //metodos
    public void getDisponiveis(){
        System.out.println(this.disponiveis);
    }
}

class Q1{
    public static void main(String[] args) {
        /*
        LivroLivraria livro1 = new LivroLivraria("A Metamorfose", "Kafka", 2, 10, 40.5f);
        livro1.getTitulo();
        LivroBiblioteca livro2 = new LivroBiblioteca("Teses de Abril", "Lenin", 1, 5);
        livro2.getDisponiveis();
        */
    }
}