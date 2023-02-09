/*
 * Projeto.: Lista Simplesmente Ligada/Encadeada
 * Autor...: Professor Dreco
 * Classe..: Lse
 * Objetivo: Criação e manutenção dos elementos na pilha simplesmente encadeada
 */
package pilha;
import java.util.Scanner;

public class Lde
{
    // Objetivo: atributos de determinação do primeiro e do último elemento da
    //           pilha, para que seja realizada a sua gestão
    //
    public Noh primeiro;
    public Noh ultimo;

    // Objetivo: método para receber e tratar a digitação de um atributo dados
    //           (do tipo Object) quando de uma inserção ou consulta por conteúdo
    //
    public String digitacao (String tipo)
    {
        Scanner s = new Scanner(System.in);
        String dados = " ";

        do
        {
            Msg.limpatela();

            try
            {
                Msg.msg_pl("Digite o ["+tipo+"] para o elemento - não pode ser vazio: ");
                dados = s.nextLine();
            }
            catch(Exception e)
            {
                Msg.msg_pl ("Erro de digitação, não deixe a informação ["+tipo+"] vazia:");
            }
        } while (dados.isEmpty());

        return dados;
    }


    // Objetivo: método para receber e tratar a digitação do atributo codigo
    //           quando de uma inserção ou consulta por conteúdo
    //
    public Integer D_Id ()
    {
        Msg.limpatela();
            
        Scanner s = new Scanner(System.in);
        Integer cod = 0;
        String texto = "Digite o valor para o Id do cliente (inteiro maior que zero): ";
        Integer erro = 0;

        do
        {
            try
            {
                Msg.msg_pl(texto);
                cod = Integer.parseInt(s.nextLine());
            }
            catch(Exception e)
            {
                texto = "Erro de digitação, o ID é obrigatório e inteiro maior que zero: ";
                erro = 1;
            }
            if((cod <= 0) && (erro == 0))
            {
                texto = "Erro de digitação, o ID é obrigatório e inteiro maior que zero: ";
            }
            erro = 0;
            Msg.limpatela();

        } while (cod <= 0);

        return cod;
    }

    // Objetivo: método para receber e tratar a digitação de um atributo dados
    //           Nome
    //
    public String D_Nome ()
    {
        Msg.limpatela();
            
        Scanner s = new Scanner(System.in);
        String nome = " ";
        String texto = "Digite o NOME do cliente (obrigatório): ";

        do
        {
            Msg.limpatela();

            try
            {
                Msg.msg_pl(texto);
                nome = s.nextLine();
            }
            catch(Exception e)
            {
                texto = "Erro de digitação, o NOME é obrigatório: ";
            }

            Msg.limpatela();
            
        } while (nome.isEmpty());

        return nome;
    }

    // Objetivo: método para receber e tratar a digitação do atributo sexo
    //           quando de uma inserção ou consulta por conteúdo
    //
    public Integer D_Sexo ()
    {
        Scanner s = new Scanner(System.in);
        int sexo  = 0;
        String texto = "Digite o valor para o SEXO do cliente (1.Mas 2.Fem): ";
        Integer erro = 0;

        do
        {
            Msg.limpatela();

            try
            {
                Msg.msg_pl(texto);
                sexo = Integer.parseInt(s.nextLine());
            }
            catch(Exception e)
            {
                texto = "Erro de digitação, o SEXO é obrigatório: ";
                erro = 1;
            }
            if((sexo < 1) || (sexo > 2) || (erro == 0))
            {
                texto = "Erro de digitação, o SEXO é obrigatório (1.Mas 2.Fem): ";
            }
            
            erro = 0;
        
            Msg.limpatela();

        } while ((sexo < 1) || (sexo > 2));

        return sexo;
    }

    // Objetivo: método para quantificar e informar a quantidade de
    //           elementos da pilha, ou seja, seu tamanho
    //
    public int tamanho()
    {
        int t = 0;
        Noh aux = null;
        for (aux = this.primeiro, t=1;
                aux.getProximo() != null;
                    aux = aux.getProximo(), t++){}
        
        return t;
    }

    // Objetivo: método para verificar se a pilha está vazia (true)
    //           ou não (false)
    //
    public boolean vazia()
    {
        boolean r = true;

        if (this.primeiro != null)
        {
            r = false;
        }
        
        return r;
    }

    // Objetivo: método para inserir um novo elemento no final da pilha
    //
    //
    public void inserir_final()
    {
        Msg.limpatela();
        Msg.msg_central ("PROCESSO DE INSERÇÃO NO FINAL");
        
        Noh novo = new Noh();
        
        if (novo == null)
        {
            Msg.msg_central ("Memória não disponível.");
        }
        else
        {
            novo.setId(this.D_Id());
            novo.setNome(this.D_Nome());
            novo.setSexo(this.D_Sexo());
            
            if (this.vazia())
            {
                this.primeiro = this.ultimo = novo;
            }
            else
            {
                this.ultimo.setProximo(novo);
                novo.setAnterior(this.ultimo);
                novo.setProximo(null);
                this.ultimo = novo;
            }
        }
    } 

    // Objetivo: método para remover um elemento da última posição da pilha
    //           
    //
    public void remover_final()
    {
        Msg.limpatela();
        Msg.msg_central ("PROCESSO DE REMOÇÃO NO FINAL");
        
        this.ultimo.mostra_noh(this.tamanho());
        
        Noh aux = this.ultimo.getAnterior();
        
        
        if (this.primeiro == this.ultimo)
            this.primeiro = this.ultimo = null;
        else{
            this.ultimo.setAnterior(null);
            this.ultimo = aux;
            this.ultimo.setProximo(null);
        }
        System.gc();

    }
        
    

    // Objetivo: método para remover todos os elementos que estão
    //           presentes na pilha, inicializando-a. Tornando-a vazia.
    //
    public void inicializar()
    {
        Msg.limpatela();
        Msg.msg_central ("PROCESSO DE INICIALIZAÇÃO");
        
        Noh aux;
        
        if (this.primeiro == this.ultimo)
            this.primeiro = this.ultimo = null;
        else{
            while(this.primeiro != null){
                aux = this.primeiro.getProximo();
                this.primeiro = null;
                this.primeiro = aux;
            }
        }       
        System.gc();
        
    }

    // Objetivo: método para consultar todos os elementos que estão
    //           presentes na pilha
    //
    
    public void consultar_geral()
    {
        Msg.limpatela();
        
        Msg.msg_central ("PROCESSO DE CONSULTA GERAL");
        
        Noh aux;
        int pos;
        
        for (aux = this.primeiro, pos = 1;
                aux != null;
                    aux = aux.getProximo(), pos++)
        {
            aux.mostra_noh(pos);
        }
    
        Msg.enter();
    }

    // Objetivo: método para consultar se uma determinada posição está
    //           presente na pilha e, se sim, qual elemento a ocupa
    //
    public void consultar_posicao(int posicao)
    {
        Msg.limpatela();
        Msg.msg_central ("PROCESSO DE CONSULTA POR POSIÇÃO");
        Noh aux;
        int i;
        
        for (aux = this.primeiro, i = 1; 
                (i != posicao) && (aux != null);
                    aux = aux.getProximo(), i++){}
        if (aux == null)
            Msg.msg_nl("- Não encontrado.");
        else
            aux.mostra_noh(i);
    }

    // Objetivo: método para consultar se um determinado elemento com conteúdo INT está
    //           presente na pilha e, se sim, qual posição ele ocupa
    //
    public void consultar_conteudo_int(int conteudo)
    {
        Msg.limpatela();
        Msg.msg_central ("PROCESSO DE CONSULTA POR CONTEÚDO - INT");
        Noh aux = null;
        int i = 0, id = 0;
        
        for (aux = this.primeiro, id =this.primeiro.getId(), i = 1; 
                (aux != null) && (aux.getId() != conteudo);
                    aux = aux.getProximo(), i++){}
        if (aux == null)
            Msg.msg_nl("- Não encontrado.");
        else
            aux.mostra_noh(i);
    }

    // Objetivo: método para consultar se um determinado elemento com conteúdo STR está
    //           presente na pilha e, se sim, qual posição ele ocupa
    //
    public void consultar_conteudo_str(String conteudo)
    {
        Msg.limpatela();
        Msg.msg_central ("PROCESSO DE CONSULTA POR CONTEÚDO - STR");
        Noh aux = null;
        int i = 0, a = 0;
        String nome = (conteudo.trim().toLowerCase());
        
        for (aux = this.primeiro, i = 1; 
                (aux != null);
                    aux = aux.getProximo(), i++){
            if (aux.getNome().trim().toLowerCase().equals(nome)){
                aux.mostra_noh(i);
                a = 1;
            }
        }
        
        if (a == 0)
            Msg.msg_nl("- Conteudo nao encontrado.");
    }

    // Objetivo: método construtor da pilha e que determina que ela
    //           está, inicialmente, vazia
    //
    public Lde()
    {
        this.primeiro = this.ultimo = null;
    }
}