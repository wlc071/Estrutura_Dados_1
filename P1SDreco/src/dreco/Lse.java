/*
 * Projeto.: Lista Simplesmente Ligada/Encadeada
 * Autor...: Professor Dreco
 * Classe..: Lse
 * Objetivo: Criação e manutenção dos elementos na fila simplesmente encadeada
 */
package dreco;
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
        int t = 0;
        //
        
        if (!this.vazia())
        {
            if (this.primeiro == this.ultimo)
            {
                t = 1;
            }
            else
            {
                Noh aux = null;
                
                for (aux = this.primeiro, t=1;
                        aux != null;
                            aux = aux.getProximo(), t++);
            }
        }

        return t;
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
        Msg.msg_central ("Atenção! Aguarde a implementação da inicialização!");
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
        Msg.msg_central ("Atenção! Aguarde a implementação da consulta por posição!");
    }

    // Objetivo: método para consultar se um determinado elemento com conteúdo INT está
    //           presente na fila e, se sim, qual posição ele ocupa
    //
    public void consultar_conteudo_int(int conteudo)
    {
        Msg.limpatela();
        Msg.msg_central ("PROCESSO DE CONSULTA POR CONTEÚDO - INT");
        Msg.msg_central ("Atenção! Aguarde a implementação da consulta por conteúdo INT!");
    }

    // Objetivo: método para consultar se um determinado elemento com conteúdo STR está
    //           presente na fila e, se sim, qual posição ele ocupa
    //
    public void consultar_conteudo_str(String conteudo)
    {
        Msg.limpatela();
        Msg.msg_central ("PROCESSO DE CONSULTA POR CONTEÚDO - STR");
        Msg.msg_central ("Atenção! Aguarde a implementação da consulta por conteúdo STR!");
    }
    
    public int conta_sexo_2()
    {
        Msg.limpatela();
        Msg.msg_central("Contagem de sexo = 2");
        
        int qtsexo2 = 0;
        
        Noh aux = null;
        
        for (aux = this.primeiro;
                aux != null;
                    aux = aux.getProximo())
        {
            if (aux.getSexo() == 2) 
            {
                qtsexo2++;
            }
        }
        
        return qtsexo2;
    }
    
    public void troca_dreco_1()
    {
        Msg.limpatela();
        Msg.msg_central("Troca de lugar do último elemento com o primeiro.");
        
        if (this.primeiro == this.ultimo)
        {
            Msg.msg_central("Na lista existe apenas um elemento. Não haverá troca.");
        }
        else
        {
            if (this.primeiro.getProximo() == this.ultimo)
            {
                Noh aux = this.primeiro;
                this.primeiro = this.ultimo;
                this.ultimo = aux;
                this.primeiro.setProximo(this.ultimo);
            }
            else
            {
                Noh aux_prim = this.primeiro;
                Noh aux_prim_prox = this.primeiro.getProximo();
                Noh aux_ult = this.ultimo;
                Noh aux_penultimo = null;

                for (aux_penultimo = this.primeiro;
                        aux_penultimo.getProximo() != this.ultimo;
                            aux_penultimo = aux_penultimo.getProximo());

                this.primeiro = aux_ult;
                this.primeiro.setProximo(aux_prim_prox);
                this.ultimo = aux_prim;
                aux_penultimo.setProximo(this.ultimo);
                this.ultimo.setProximo(null);
            }
        }
    }
    
    public void listagem_dreco()
    {
        Msg.limpatela();
        Msg.msg_central("Listagem reversa da lista.");
        
        if (this.primeiro == this.ultimo)
        {
            this.primeiro.mostra_noh(1);
        }
        else
        {
            int qtelementos = this.tamanho();
            int percorre = 0;
            int contador = 0;
            
            Noh aux = null;
            
            for (percorre = 1; percorre <  qtelementos; percorre ++)
            {
                for (aux = this.primeiro, contador = 1;
                        aux.getProximo() != null && (qtelementos - contador != percorre);
                            aux = aux.getProximo(), contador++);
                
                aux.mostra_noh2 (contador, percorre);
            }        
        }    
    }
    
    public void remove_sexo_1()
    {
        Msg.limpatela();
        Msg.msg_central("Remover sexo = 1.");
        
        Noh liberar = null;
        Noh aux = null;
        
        if (this.primeiro.getSexo() == 1)
        {
            do
            {
                liberar = this.primeiro;
                this.primeiro = this.primeiro.getProximo();
                liberar.setProximo(null);
            }
            while ((this.primeiro != null) && (this.primeiro.getSexo() != 2));
                
            if (this.primeiro == null)
            {
                this.ultimo = null;
            }
        }
        
        if ((this.primeiro != null) && (this.primeiro != this.ultimo))
        {
            aux = this.primeiro;
            
            do
            {
                if (aux.getProximo().getSexo() == 1)
                {
                    liberar = aux.getProximo();
                    aux.setProximo(aux.getProximo().getProximo());
                    liberar.setProximo(null);
                }
                else
                {
                    aux = aux.getProximo();
                }
            } while (aux.getProximo() != null);
            
            if (aux.getProximo() == null)
            {
                this.ultimo = aux;
            }
        }
    }
    
    public Lse uniao (Lse lista1, Lse lista2)
    {
        Lse resultado = new Lse();
        
        boolean rollback = false;
        
        Noh aux = null;
        Noh novo = null;
        
        aux = lista1.primeiro;
        
        do
        {
            novo = new Noh(aux.getId(), aux.getNome(), aux.getSexo(), null);
            
            if (novo != null)
            {
                if (resultado.primeiro == null)
                {
                    resultado.primeiro = resultado.ultimo = novo;
                }
                else
                {
                    resultado.ultimo.setProximo(novo);
                    resultado.ultimo = novo;
                }
                
                aux = aux.getProximo();
            }
            else
            {
                aux = null;
                rollback = true;
            }
        } 
        while (aux != null);
        
        if (rollback)
        {
            resultado.inicializar();
        }
        else
        {
            aux = lista2.primeiro;

            do
            {
                novo = new Noh(aux.getId(), aux.getNome(), aux.getSexo(), null);

                if (novo != null)
                {
                    if (resultado.primeiro == null)
                    {
                        resultado.primeiro = resultado.ultimo = novo;
                    }
                    else
                    {
                        resultado.ultimo.setProximo(novo);
                        resultado.ultimo = novo;
                    }

                    aux = aux.getProximo();
                }
                else
                {
                    aux = null;
                    rollback = true;
                }
            } 
            while (aux != null);
        
            if (rollback)
            {
                resultado.inicializar();
            }
        }
        
        return resultado;
    }
        
    
    public Lse interseccao (Lse lista1, Lse lista2)
    {
        Lse resultado = new Lse();
        
        Noh aux1 = null;
        Noh aux2 = null;
        Noh novo = null;
        int p1 = 0;
        boolean rollback = false;
           
        for (aux1 = lista1.primeiro, p1 = 1;
                aux1 != null;
                    aux1 = aux1.getProximo(), p1++)
        {
            for(aux2 = lista2.primeiro; aux2 != null && aux1 != aux2; aux2 = aux2.getProximo())
            {
                if (aux1.getId() == aux2.getId()){
                    
                    novo = new Noh(aux1.getId(), aux1.getNome(), aux1.getSexo(), null);
                    
                    if (novo != null)
                    {
                        if (resultado.primeiro == null)
                        {
                            resultado.primeiro = resultado.ultimo = novo;
                        }
                        else
                        {
                            resultado.ultimo.setProximo(novo);
                            resultado.ultimo = novo;
                        }
                    }
                    else
                    {
                        rollback = true;
                    }
                }
            }
        }
        if (rollback)
        {
            resultado.inicializar();
        }

        return resultado;
    }
    
    public Lse diferenca(Lse lista1, Lse lista2){
        Lse resultado = new Lse();
        
        Noh aux1 = null;
        Noh aux2 = null;
        Noh novo = null;
        int p1 = 0;
        boolean rollback = false;
        
        for (aux1 = lista1.primeiro, p1 = 1;
                aux1 != null;
                    aux1 = aux1.getProximo(), p1++)
        {
            for(aux2 = lista2.primeiro; aux2 != null && (aux1.getId() != aux2.getId()); aux2 = aux2.getProximo())
            {}
            if (aux2 == null){
                novo = new Noh(aux1.getId(), aux1.getNome(), aux1.getSexo(), null);
                    
                if (novo != null)
                {

                    if (resultado.primeiro == null)
                    {
                        resultado.primeiro = resultado.ultimo = novo;
                    }

                    else
                    {
                        resultado.ultimo.setProximo(novo);
                        resultado.ultimo = novo;
                    }

                }

                else
                {
                    rollback = true;
                }
            }
        }
       if (rollback){
            resultado.inicializar();
        }
        
        return resultado;
    }
    

    public void carga_dreco_1()
    {
        Noh novo01 = new Noh(1,"Andre", 1, null);
        this.primeiro = this.ultimo = novo01;
        
        Noh novo02 = new Noh(2,"Maria", 2, null);
        this.ultimo.setProximo(novo02);
        this.ultimo = novo02;
        
        Noh novo03 = new Noh(4,"Pedro", 1, null);
        this.ultimo.setProximo(novo03);
        this.ultimo = novo03;
        
        Noh novo04 = new Noh(77,"Joao", 1, null);
        this.ultimo.setProximo(novo04);
        this.ultimo = novo04;
        
        Noh novo05 = new Noh(98,"Carla", 2, null);
        this.ultimo.setProximo(novo05);
        this.ultimo = novo05;
        
        Noh novo06 = new Noh(101,"Jussara", 2, null);
        this.ultimo.setProximo(novo06);
        this.ultimo = novo06;
        
        Noh novo07 = new Noh(131,"Silvia", 2, null);
        this.ultimo.setProximo(novo07);
        this.ultimo = novo07;
        
        Noh novo08 = new Noh(208,"Pedroca", 1, null);
        this.ultimo.setProximo(novo08);
        this.ultimo = novo08;
        
        Noh novo09 = new Noh(232,"Jacinta", 2, null);
        this.ultimo.setProximo(novo09);
        this.ultimo = novo09;
        
        Noh novo10 = new Noh(329,"Dreco", 1, null);
        this.ultimo.setProximo(novo10);
        this.ultimo = novo10;
        
        Noh novo11 = new Noh(389,"Darci", 1, null);
        this.ultimo.setProximo(novo11);
        this.ultimo = novo11;
    }

    public void carga_dreco_2()
    {
        Noh novo01 = new Noh(1,"Andre", 1, null);
        this.primeiro = this.ultimo = novo01;
        
        Noh novo02 = new Noh(3,"Érica", 2, null);
        this.ultimo.setProximo(novo02);
        this.ultimo = novo02;
        
        Noh novo03 = new Noh(4,"Pedro", 1, null);
        this.ultimo.setProximo(novo03);
        this.ultimo = novo03;
        
        Noh novo04 = new Noh(60,"Januário", 1, null);
        this.ultimo.setProximo(novo04);
        this.ultimo = novo04;
        
        Noh novo05 = new Noh(61,"Paula", 2, null);
        this.ultimo.setProximo(novo05);
        this.ultimo = novo05;
        
        Noh novo06 = new Noh(102,"Carina", 2, null);
        this.ultimo.setProximo(novo06);
        this.ultimo = novo06;
               
        Noh novo07 = new Noh(232,"Jacinta", 2, null);
        this.ultimo.setProximo(novo07);
        this.ultimo = novo07;
        
        Noh novo08 = new Noh(331,"Dreco Xpto", 1, null);
        this.ultimo.setProximo(novo08);
        this.ultimo = novo08;
        
        Noh novo09 = new Noh(399,"Juliana Silva", 2, null);
        this.ultimo.setProximo(novo09);
        this.ultimo = novo09;
        
        Noh novo10 = new Noh(401,"Juliana Correa", 2, null);
        this.ultimo.setProximo(novo10);
        this.ultimo = novo10;
        
        Noh novo11 = new Noh(408,"Soraia", 2, null);
        this.ultimo.setProximo(novo11);
        this.ultimo = novo11;
        
        Noh novo12 = new Noh(477,"Mariana", 2, null);
        this.ultimo.setProximo(novo12);
        this.ultimo = novo12;
        
        Noh novo13 = new Noh(503,"Poliana", 2, null);
        this.ultimo.setProximo(novo13);
        this.ultimo = novo13;
    }

    // Objetivo: método construtor da fila e que determina que ela
    //           está, inicialmente, vazia
    //
    public Lse()
    {
        this.primeiro = this.ultimo = null;
    }
}