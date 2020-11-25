package q6;
import java.util.Scanner;

interface Expression{
    public String avaliar(String expr);
    public String imprimirArvore(String expr);
}

class ExprAritmetica implements Expression{
    private String toString(float subexpr){
        return Float.toString(subexpr);
    }

    protected float getAvaliacao(String expr){
        //soma
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '+'){
                return (getAvaliacao(expr.substring(0, i)) + getAvaliacao(expr.substring(i+1, expr.length())));
            }
        }
        //subtracao
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '-'){
                return (getAvaliacao(expr.substring(0, i)) - getAvaliacao(expr.substring(i+1, expr.length())));
            }
        }
        //multiplicacao
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '*'){
                return (getAvaliacao(expr.substring(0, i)) * getAvaliacao(expr.substring(i+1, expr.length())));
            }
        }
        //divisao
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '/'){
                return (getAvaliacao(expr.substring(0, i)) / getAvaliacao(expr.substring(i+1, expr.length())));
            }
        }
        return Float.parseFloat(expr);
    }

    public String avaliar(String expr){
        String avaliacao = toString(getAvaliacao(expr));
        System.out.println("ao chamar avaliar: " + avaliacao);
        return avaliacao;
    }

    protected String makeArvore(String expr){
        String arvore;
        //soma
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '+'){
                return arvore = '(' + makeArvore(expr.substring(0, i)) + ')' + '+' + '(' + makeArvore(expr.substring(i+1, expr.length())) + ')';
            }
        }
        //subtracao
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '-'){
                return arvore = '(' + makeArvore(expr.substring(0, i)) + ')' + '-' + '(' + makeArvore(expr.substring(i+1, expr.length())) + ')';
            }
        }
        //multiplicacao
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '*'){
                return arvore = '(' + makeArvore(expr.substring(0, i)) + ')' + '*' + '(' + makeArvore(expr.substring(i+1, expr.length())) + ')';
            }
        }
        //divisao
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '/'){
                return arvore = '(' + makeArvore(expr.substring(0, i)) + ')' + '/' + '(' + makeArvore(expr.substring(i+1, expr.length())) + ')';
            }
        }
        return arvore = expr;
    }

    public String imprimirArvore(String expr){
        String arvore = makeArvore(expr);
        System.out.println("ao chamar imprimirAvore: " + '(' + arvore + ')');
        return arvore;
    }
}

class ExprLogica implements Expression{
    private String toString(boolean subexpr){
        if(subexpr) return "True";
        else return "False";
    }

    private float getAritmetica(String subexpr){
        ExprAritmetica aritmetica = new ExprAritmetica();
        return aritmetica.getAvaliacao(subexpr);
    }

    private String getArvoreAritmetica(String subexpr){
        ExprAritmetica aritmetica = new ExprAritmetica();
        return aritmetica.makeArvore(subexpr);
    }

    protected boolean getAvaliacao(String expr){
        //diferente
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '!' && expr.charAt(i+1) == '='){
                return getAritmetica(expr.substring(0, i)) != getAritmetica(expr.substring(i+2, expr.length()));
            }
        }
        //igual
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '=' && expr.charAt(i+1) == '='){
                return getAritmetica(expr.substring(0, i)) == getAritmetica(expr.substring(i+2, expr.length()));
            }
        }
        //maior ou igual
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '>' && expr.charAt(i+1) == '='){
                return getAritmetica(expr.substring(0, i)) >= getAritmetica(expr.substring(i+2, expr.length()));
            }
        }
        //menor ou igual
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '<' && expr.charAt(i+1) == '='){
                return getAritmetica(expr.substring(0, i)) <= getAritmetica(expr.substring(i+2, expr.length()));
            }
        }
        //maior que
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '>'){
                return getAritmetica(expr.substring(0, i)) > getAritmetica(expr.substring(i+1, expr.length()));
            }
        }
        //menor que
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '<'){
                return getAritmetica(expr.substring(0, i)) < getAritmetica(expr.substring(i+1, expr.length()));
            }
        }
        return false;
    }

    public String avaliar(String expr){
        String avaliacao = toString(getAvaliacao(expr));
        System.out.println("ao chamar avaliar: " + avaliacao);
        return avaliacao;
    }

    protected String makeArvore(String expr){
        String arvore;
        //diferente
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '!' && expr.charAt(i+1) == '='){
                return arvore = "((" + getArvoreAritmetica(expr.substring(0, i)) + ')' + "!=" + '(' + getArvoreAritmetica(expr.substring(i+2, expr.length())) + "))";
            }
        }
        //igual
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '=' && expr.charAt(i+1) == '='){
                return arvore = "((" + getArvoreAritmetica(expr.substring(0, i)) + ')' + "==" + '(' + getArvoreAritmetica(expr.substring(i+2, expr.length())) + "))";
            }
        }
        //maior ou igual
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '>' && expr.charAt(i+1) == '='){
                return arvore = "((" + getArvoreAritmetica(expr.substring(0, i)) + ')' + ">=" + '(' + getArvoreAritmetica(expr.substring(i+2, expr.length())) + "))";
            }
        }
        //menor ou igual
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '<' && expr.charAt(i+1) == '='){
                return arvore = "((" + getArvoreAritmetica(expr.substring(0, i)) + ')' + "<=" + '(' + getArvoreAritmetica(expr.substring(i+2, expr.length())) + "))";
            }
        }
        //maior que
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '>'){
                return arvore = "((" + getArvoreAritmetica(expr.substring(0, i)) + ')' + ">" + '(' + getArvoreAritmetica(expr.substring(i+1, expr.length())) + "))";
            }
        }
        //menor que
        for(int i=expr.length()-1; i>=0; i--){
            if(expr.charAt(i) == '<'){
                return arvore = "((" + getArvoreAritmetica(expr.substring(0, i)) + ')' + "<" + '(' + getArvoreAritmetica(expr.substring(i+1, expr.length())) + "))";
            }
        }
        return arvore = expr;
    }

    public String imprimirArvore(String expr){
        String arvore = makeArvore(expr);
        System.out.println("ao chamar imprimirAvore: " + arvore);
        return arvore;
    }
}

class Main{
    static boolean descobreTipoDeExpr(String expr){
        for(int i=0; i<expr.length(); i++){
            if(expr.charAt(i) == '<' || expr.charAt(i) == '>' || expr.charAt(i) == '!' || expr.charAt(i) == '='){
                return true; //logica
            }
        }
        return false; //aritmetica
    }
    
    public static void main(String[] args) {
        System.out.println("Insira uma expressao:");
        Scanner scanner = new Scanner(System.in);
        String expr = scanner.nextLine();

        //se eh expr logica
        if(descobreTipoDeExpr(expr)){
            ExprLogica logic = new ExprLogica();
            logic.avaliar(expr);
            System.out.println("passou");
            logic.imprimirArvore(expr);
        }
        //se eh aritmetica
        else{
            ExprAritmetica arit = new ExprAritmetica();
            arit.avaliar(expr);
            arit.imprimirArvore(expr);
        }
    }
}