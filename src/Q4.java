package q4;

class Senha{
    //construtor
    Senha(String alfanumerica, int numerica){
        this.alfanumerica = alfanumerica;
        this.numerica = numerica;
    }

    //atributos
    protected String alfanumerica;
    protected int numerica;

    //metodos
    protected void setAlfanumerica(String alfanumerica){
        this.alfanumerica = alfanumerica;
    }
    protected void setNumerica(int numerica){
        this.numerica = numerica;
    }
    protected String getAlfanumerica(){
        return alfanumerica;
    }
    protected int getNumerica(){
        return numerica;
    }
}

class Conta{
    //construtor
    Conta(int id, int agencia, Senha senha){
        this.id = id;
        this.agencia = agencia;
        this.senha = senha;
    }

    //atributos
    protected int id;
    protected int agencia;
    protected Senha senha;

    //metodos
    protected void setId(int id){
        this.id = id;
    }
    protected void setAgencia(int agencia){
        this.agencia = agencia;
    }
    protected void setSenha(Senha senha){
        this.senha = senha;
    }
    protected void setSenhaAlfanumerica(String alfanumerica){
        this.senha.setAlfanumerica(alfanumerica);
    }
    protected void setSenhaNumerica(int numerica){
        this.senha.setNumerica(numerica);
    }
    protected int getId(){
        return id;
    }
    protected int getAgencia(){
        return agencia;
    }
    protected Senha getSenha(){
        return senha;
    }
}

class Main{
    public static void main(String[] args) {
        //instanciacao da conta
        Conta conta1 = new Conta(23, 2, new Senha("A2C32", 1999));
        //mostra senha alfanumerica da conta
        System.out.println("Senha alfanumerica da conta: " + conta1.getSenha().getAlfanumerica());
        //mostra id da conta
        System.out.println("ID da conta: " + conta1.getId());
        //modifica senha de letras
        conta1.setSenhaAlfanumerica("E40B60");
        //mostra senha alfanumerica modificada
        System.out.println("Nova senha alfanumerica da conta: " + conta1.getSenha().getAlfanumerica());
    }
}
