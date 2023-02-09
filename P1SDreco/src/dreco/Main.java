/*
 * Projeto.: Lista Simplesmente Ligada
 * Autor...: Professor Dreco
 * Classe..: Sdreco / 2018-S2
 * Objetivo: Projeto dreco Simplesmente Ligada
 */
package dreco;

import static dreco.Msg.msg_nl;

public class Main
{
    public static void main(String[] args)
    {
        Lse drecoA = new Lse();
        Lse drecoB = new Lse();
        Lse drecoC = new Lse();
        
        drecoA.carga_dreco_1();
        drecoA.consultar_geral();
        
        drecoB.carga_dreco_2();
        drecoB.consultar_geral();
        
        
        int    tamanho = 0;
        int    posicao = 0;
        int    conteudo_int = 0;
        int    qtd = 0;
        String conteudo_str = " ";
        
        int opc = Msg.opcao_principal();

        while (opc != 0)
        {
            switch (opc)
            {
                case 1: // Inserção
                    Msg.limpatela();
                    
                    drecoA.inserir_final();
                    
                    Msg.enter();
                    break;

                case 2: // Remoção
                    Msg.limpatela();

                    if (drecoA.vazia())
                    {
                        Msg.msg_central ("A lista dreco está vazia, remoção não processada!");
                    }
                    else
                    {
                        drecoA.remover_inicio();
                    }
                    Msg.enter();
                    break;

                case 3: // Consulta
                    Msg.limpatela();

                    if (drecoA.vazia())
                    {
                        Msg.msg_central ("A lista dreco está vazia, consulta não processada!");
                        Msg.enter();
                    }
                    else
                    {
                        opc = Msg.opcao_consulta();

                        Msg.limpatela();

                        switch (opc)
                        {
                            case 1: // Consulta Geral
                                drecoA.consultar_geral();
                                break;

                            case 2: // Consulta Posição
                                posicao = Msg.solicita_posicao();

                                if (posicao < 1)
                                {
                                    Msg.msg_central ("Consulta nao realizada!");
                                }
                                else
                                {
                                    drecoA.consultar_posicao(posicao);
                                }
                                Msg.enter();
                                break;

                            case 3: // Consulta Conteúdo INT
                                conteudo_int = Msg.solicita_conteudo_int();

                                if (conteudo_int == 0)
                                {
                                    Msg.msg_central ("Consulta nao realizada!");
                                }
                                else
                                {
                                    drecoA.consultar_conteudo_int(conteudo_int);
                                }
                                Msg.enter();
                                break;

                            case 4: // Consulta Conteúdo STR
                                conteudo_str = Msg.solicita_conteudo_str();

                                if (conteudo_str.isEmpty())
                                {
                                    Msg.msg_central ("Consulta nao realizada!");
                                }
                                else
                                {
                                    drecoA.consultar_conteudo_str(conteudo_str);
                                }
                                Msg.enter();
                                break;
        
                            default:
                                Msg.limpatela();
                                Msg.msg_central ("Opção inválida, retornando...");
                                Msg.enter();
                        }
                    }
                    break;

                case 4: // Inicialização
                    Msg.limpatela();

                    if (drecoA.vazia())
                    {
                        Msg.msg_central ("A lista dreco está vazia, inicialização não processada!");
                    }
                    else
                    {
                        drecoA.inicializar();
                    }
                    Msg.enter();
                    break;

                case 5: // Tamanho da Lista
                    Msg.limpatela();

                    if (drecoA.vazia())
                    {
                        Msg.msg_central(">> A lista está vazia.");
                    }
                    else
                    {
                        tamanho = drecoA.tamanho();

                        if (tamanho == 0)
                        {
                            Msg.msg_central (">> Aguarde a implementação do cálculo de tamanho!");
                        }
                        else
                        {
                            Msg.msg_central (">> O tamanho da deque é: ["+tamanho+"]\n\n");
                        }
                        
                        tamanho = 0;
                    }
                    
                    Msg.enter();
                    break;

                case 6: // Especial 06
                    
                    Msg.limpatela();
                    Msg.msg_central ("Especial 06");
                    Msg.enter();
                    break;

                case 7: // Especial 07
                    
                    Msg.limpatela();
                    Msg.msg_central ("Especial 07");
                    Msg.enter();
                    break;

                case 8: // Especial 08
                    
                    Msg.limpatela();
                    Msg.msg_central ("Especial 08");
                    Msg.enter();
                    break;

                case 9: // Especial 09
                    
                    Msg.limpatela();
                    Msg.msg_central ("Especial 09");
                    Msg.enter();
                    break;
                    
                case 10: // Especial 10
                    
                    Msg.limpatela();
                    Msg.msg_central ("Especial 10");
                    Msg.enter();
                    break;

                case 11: // Especial 11
                    
                    Msg.limpatela();
                    Msg.msg_central ("Especial 11");
                    Msg.enter();
                    break;

                case 12: // Especial 12
                    
                    Msg.limpatela();
                    
                    if (drecoA.vazia())
                    {
                        Msg.msg_central("Lista vazia. Não há pesquisa.");
                    }
                    else
                    {
                        qtd = drecoA.conta_sexo_2();
                        if (qtd == 0)
                        {
                            Msg.msg_central("Não há pessoas com sexo 2 na lista.");
                        }
                        else
                        {
                            Msg.msg_central("Na lista há ["+qtd+"] pessoas com sexo 2.");
                        }
                    }
                    Msg.enter();
                    break;

                case 13: // Especial 13
                    
                    Msg.limpatela();
                    
                    if (drecoA.vazia())
                    {
                        Msg.msg_central("Lista vazia. Não haverá troca.");
                    }
                    else
                    {
                        drecoA.troca_dreco_1();
                    }
                    Msg.enter();
                    break;

                case 14: // Especial 14
                    
                    Msg.limpatela();
                    
                    if (drecoA.vazia())
                    {
                        Msg.msg_central("Lista vazia. Não haverá listagem.");
                    }
                    else
                    {
                        drecoA.listagem_dreco();
                    }
                    
                    Msg.enter();
                    break;

                case 15: // Especial 15
                    
                    Msg.limpatela();
                    drecoA.remove_sexo_1();
                    Msg.enter();
                    break;

                case 16: // TC - União - Cópia
                    
                    Msg.limpatela();
                    Msg.msg_central ("Teoria dos Conjuntos - União - Cópia");
                    
                    drecoC = drecoC.uniao(drecoA, drecoB);
                    
                    drecoC.consultar_geral();
                    
                    Msg.enter();
                    break;

                case 17: // TC - Intersecção - Cópia
                    
                    Msg.limpatela();
                    Msg.msg_central ("Teoria dos Conjuntos - Intersecção - Cópia");
                    
                    drecoC = drecoC.interseccao(drecoA, drecoB);
                    
                    drecoC.consultar_geral();
                    
                    Msg.enter();
                    break;

                case 18: // TC - Diferença - Cópia
                    
                    Msg.limpatela();
                    Msg.msg_central ("Teoria dos Conjuntos - Diferença - Cópia");
                    
                    drecoC = drecoC.diferenca(drecoA, drecoB);
                    
                    drecoC.consultar_geral();
                    
                    Msg.enter();
                    break;

                case 19: // TC - Intercalação - Cópia
                    
                    Msg.limpatela();
                    Msg.msg_central ("Teoria dos Conjuntos - Intercalação - Cópia");
                    Msg.enter();
                    break;

                case 20: // TC - Separação - Cópia
                    
                    Msg.limpatela();
                    Msg.msg_central ("Teoria dos Conjuntos - Separação - Cópia");
                    Msg.enter();
                    break;

                case 21: // TC - Balance-Line - Cópia
                    
                    Msg.limpatela();
                    Msg.msg_central ("Teoria dos Conjuntos - Balance-Line - Cópia");
                    Msg.enter();
                    break;

                case 22: // TC - União - Transferência
                    
                    Msg.limpatela();
                    Msg.msg_central ("Teoria dos Conjuntos - União - Transferência");
                    Msg.enter();
                    break;

                case 23: // TC - Intersecção - Transferência
                    
                    Msg.limpatela();
                    Msg.msg_central ("Teoria dos Conjuntos - Intersecção - Transferência");
                    Msg.enter();
                    break;

                case 24: // TC - Diferença - Transferência
                    
                    Msg.limpatela();
                    Msg.msg_central ("Teoria dos Conjuntos - Diferença - Transferência");
                    Msg.enter();
                    break;

                case 25: // TC - Intercalação - Transferência
                    
                    Msg.limpatela();
                    Msg.msg_central ("Teoria dos Conjuntos - Intercalação - Transferência");
                    Msg.enter();
                    break;

                case 26: // TC - Separação - Transferência
                    
                    Msg.limpatela();
                    Msg.msg_central ("Teoria dos Conjuntos - Separação - Transferência");
                    Msg.enter();
                    break;

                case 27: // TC - Balance-Line - Transferência
                    
                    Msg.limpatela();
                    Msg.msg_central ("Teoria dos Conjuntos - Balance-Line - Transferência");
                    Msg.enter();
                    break;

                case 0:
                    break;

                default:
                    Msg.limpatela();
                    Msg.msg_central ("Opção inválida, retornando...");
                    Msg.enter();
            }
            
            opc = Msg.opcao_principal();
        }
        Msg.limpatela();

        if (drecoA.vazia())
        {
           Msg.msg_central ("O programa encerrou com a dreco vazia!");
        }
        else
        {
           Msg.msg_central ("Antes de encerrar, será apresentada a dreco na situação atual.");

           drecoA.consultar_geral();
        }
    }
}
