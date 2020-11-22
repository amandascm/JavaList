package q2;
import java.util.regex.Pattern;

class Texto{
    //construtor
    Texto(String corpoDoTexto){
        this.corpoDoTexto = corpoDoTexto;
    }

    //atributos
    private String corpoDoTexto;

    //metodos
    //confere se char eh digito ou letra
    boolean ehNumOuLetra(char c){
        if((int)(c) >= 48 && (int)(c) <= 57 || (int)(c) >= 65 && (int)(c) <= 90 || (int)(c) >= 97 && (int)(c) <= 122){
            return true;
        }else{
            return false;
        }
    }

    //printa texto
    void printTexto(){
        System.out.println(corpoDoTexto);
    }

    //retorna quantidade de aparicoes de uma palavra no texto
    int frequenciaDaPalavra(String palavra){
        int contadorPalavra = 0;
        boolean ultimoCharEhNumOuLetra, proximoCharEhNumOuLetra;

        if(palavra.length() > 0){
            String regex = "(?i)" + palavra;
            for(int i=0; i<corpoDoTexto.length(); i++){
                if(corpoDoTexto.length() - i >= palavra.length()){
                    //conferindo se eh uma palavra msm (esta isolada por char q nao seja letra ou numero)
                    if(i > 0) ultimoCharEhNumOuLetra = ehNumOuLetra(corpoDoTexto.charAt(i-1));
                    else ultimoCharEhNumOuLetra = false;
                    if(i + palavra.length() <= corpoDoTexto.length() - 1) proximoCharEhNumOuLetra = ehNumOuLetra(corpoDoTexto.charAt(i+palavra.length()));
                    else proximoCharEhNumOuLetra = false;

                    if(corpoDoTexto.substring(i, i+palavra.length()).matches(regex) && !ultimoCharEhNumOuLetra && !proximoCharEhNumOuLetra){
                        contadorPalavra++;
                    }
                }
            }
        }
        return(contadorPalavra);
    }

    //substituir palavras do texto por outra
    void substituiPalavra(String antigaPalavra, String novaPalavra){
        boolean ultimoCharEhNumOuLetra, proximoCharEhNumOuLetra;

        if(antigaPalavra.length() > 0){
            String regex = "(?i)" + antigaPalavra;
            for(int i=0; i<corpoDoTexto.length(); i++){
                if(corpoDoTexto.length() - i >= antigaPalavra.length()){
                    //conferindo se eh uma palavra msm (esta isolada por char q nao seja letra ou numero)
                    if(i > 0) ultimoCharEhNumOuLetra = ehNumOuLetra(corpoDoTexto.charAt(i-1));
                    else ultimoCharEhNumOuLetra = false;
                    if(i + antigaPalavra.length() <= corpoDoTexto.length() - 1) proximoCharEhNumOuLetra = ehNumOuLetra(corpoDoTexto.charAt(i+antigaPalavra.length()));
                    else proximoCharEhNumOuLetra = false;

                    if(corpoDoTexto.substring(i, i+antigaPalavra.length()).matches(regex) && !ultimoCharEhNumOuLetra && !proximoCharEhNumOuLetra){                        
                        corpoDoTexto = corpoDoTexto.substring(0, i) + novaPalavra + corpoDoTexto.substring(i+antigaPalavra.length(), corpoDoTexto.length());
                    }
                }
            }
        }
    }

    //conta numero de palavras do texto
    int contaPalavras(){
        int contadorPalavras = 0;
        boolean ultimoEhCharOuNum = true;
        boolean atualEhCharOuNum = false;

        for(int i = 0; i < corpoDoTexto.length(); i++){
            //confere se eh um numero ou um char
            atualEhCharOuNum = ehNumOuLetra(corpoDoTexto.charAt(i));
            
            //se o ultimo era numero ou char (parte de palavra) e o atual nao eh ou o ultimo do texto eh alfanumerico: incrementa o contador
            if(ultimoEhCharOuNum && !atualEhCharOuNum || atualEhCharOuNum && (i == (corpoDoTexto.length()-1))){
                contadorPalavras++;
            }
            ultimoEhCharOuNum = atualEhCharOuNum;
        }
        return contadorPalavras;
    }
}

public class Q2 {
    public static void main(String[] args) {
        String palavra;

        //instanciando um texto
        Texto texto1 = new Texto("Voltei, Recife!\nFoi a saudade que me trouxe recife recifepelo braco.");

        //printando texto
        System.out.println("--------------texto--------------");
        texto1.printTexto();
        
        //printa quantidade de palavras
        System.out.println("--------------quantidade de palavras--------------");
        System.out.println(texto1.contaPalavras());

        //printa frequencia de uma palavra no texto
        palavra = "Recife";
        System.out.println("--------------frequencia da palavra '" + palavra + "' no texto--------------");
        System.out.println(texto1.frequenciaDaPalavra(palavra));

        //substitui palavra
        palavra = "recife";
        String novaPalavra = "Olinda";
        System.out.println("--------------texto com palavra '" + palavra + "' substituida por '" + novaPalavra + "'-----------");
        texto1.substituiPalavra(palavra, novaPalavra);
        texto1.printTexto();
    }
}
