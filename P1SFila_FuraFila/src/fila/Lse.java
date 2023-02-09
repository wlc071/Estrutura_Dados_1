/*
 * Projeto.: Lista Simplesmente Ligada/Encadeada
 * Autor...: Professor Dreco
 * Classe..: Lse
 * Objetivo: Criação e manutenção dos elementos na fila simplesmente encadeada
 */
package fila;
import java.util.Scanner;

public class Lse
{
    // Objetivo: atributos de determinação do primeiro e do último elemento da
    //           fila, para que seja realizada a sua gestão
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
    //           elementos da fila, ou seja, seu tamanho
    //
    public int tamanho()
    {
        int tamanho = 0;     
        Noh aux = null;
            
        for (aux = this.primeiro, tamanho = 1;
                aux != null;
                    aux = aux.getProximo(), tamanho++){}
        tamanho--;
        
        return tamanho;
    }

    // Objetivo: método para verificar se a fila está vazia (true)
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

    // Objetivo: método para inserir um novo elemento no final da fila
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
                this.ultimo = novo;
            }
        }
    } 

    // Objetivo: método para remover um elemento da primeira posição
    //           da fila
    //
    public void remover_inicio()
    {
        Msg.limpatela();
        Msg.msg_central ("PROCESSO DE REMOÇÃO NO INÍCIO");
        
        Noh liberar = this.primeiro;
        
        this.primeiro = this.primeiro.getProximo();
        
        liberar.mostra_noh(1);
        
        if (this.primeiro == null)
        {
            this.ultimo = null;
        }
        else
        {
            liberar.setProximo(null);
        }
        
        System.gc();
    }

    // Objetivo: método para remover todos os elementos que estão
    //           presentes na fila, inicializando-a. Tornando-a vazia.
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
            this.ultimo = null;
        }       
        System.gc();
        
        
    }

    // Objetivo: método para consultar todos os elementos que estão
    //           presentes na fila
    //
    
    public void consultar_geral()
    {
        Msg.limpatela();
        
        Msg.msg_central ("PROCESSO DE CONSULTA GERAL");
        
        Noh aux = null;
        int pos = 0;
        
        for (aux = this.primeiro, pos = 1;
                aux != null;
                    aux = aux.getProximo(), pos++)
        {
            aux.mostra_noh(pos);
        }
        
        Msg.enter();
    }

    // Objetivo: método para consultar se uma determinada posição está
    //           presente na fila e, se sim, qual elemento a ocupa
    //
    public void consultar_posicao(int posicao)
    {
        Msg.limpatela();
        Msg.msg_central ("PROCESSO DE CONSULTA POR POSIÇÃO");
        
        Noh aux = null;
        int i = 0;
        
        for (aux = this.primeiro, i = 1; 
                (i != posicao) && (aux != null);
                    aux = aux.getProximo(), i++){}
        if (aux == null)
            Msg.msg_nl("- Não encontrado.");
        else
            aux.mostra_noh(i);
     
    }

    // Objetivo: método para consultar se um determinado elemento com conteúdo INT está
    //           presente na fila e, se sim, qual posição ele ocupa
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
    //           presente na fila e, se sim, qual posição ele ocupa
    //
    public void consultar_conteudo_str(String conteudo)
    {
        Msg.limpatela();
        Msg.msg_central ("PROCESSO DE CONSULTA POR CONTEÚDO - STR");
        
        Noh aux = null;
        int i = 0, a = 0;
        String verif = "", nome = (conteudo.toLowerCase());
        
        for (aux = this.primeiro, i = 1; 
                (aux != null);
                    aux = aux.getProximo(), i++){
            verif = (aux.getNome().toLowerCase());
            if (verif.equals(nome)){
                aux.mostra_noh(i);
                a = 1;
            }
        }
        
        if (a == 0)
            Msg.msg_nl("- Conteudo nao encontrado.");
        
    }
    
    public void furando_fila(int posicao)
    {
        Msg.limpatela();
        Msg.msg_central("PROCESSO DE FURA FILA");
        
        Noh novo = new Noh();
        Noh aux1 = null;
        Noh aux2 = null;
        int pos1 = 0;
        
        if (posicao > tamanho()){
            Msg.msg_nl("- Posição inválida, maior que o número de elementos.");
            
        }
        else if (novo == null)
        {
            Msg.msg_central("Memória não disponível.");
        } 
        else
        {
            novo.setId(this.D_Id());
            novo.setNome(this.D_Nome());
            novo.setSexo(this.D_Sexo());

            if (posicao == 1){
                aux1 = this.primeiro;
                this.primeiro = novo;
                novo.setProximo(aux1);
                
            } else{
                aux1 = this.primeiro;
                aux2 = aux1.getProximo();
                pos1++; 
                
                while(pos1 != (posicao-1)){
                    aux1 = aux2;
                    aux2 = aux1.getProximo();
                    pos1++;     
                }
                
                aux1.setProximo(novo);
                novo.setProximo(aux2);
                
            }
      
        }
        posicao = 0;
    }
    // Objetivo: método construtor da fila e que determina que ela
    //           está, inicialmente, vazia
    //
    public Lse()
    {
        this.primeiro = this.ultimo = null;
    }
}