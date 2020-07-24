package com.company;
import java.util.*;

public class KDC {

    Random random = new Random();
    private String chaveBob = "bolabolabolabola" ;
    private String chaveAlice = "macamacamacamaca" ;

    private String idBob="Bob";
    private String idAlice="Alice";
    private String chaveSessao;

    public String getChaveSessao() {
        return chaveSessao;
    }

    public void setChaveSessao(String chaveSessao) {
        this.chaveSessao = chaveSessao;
    }



    public void Verificando(String Id1, byte [] idCrip, byte [] contato) //RESPONSÁVEL VEREFICAR E CHAMAR O  GERAR A CHAVE DE SESSAO
    {


        if (Id1.equals(idBob)) {
            try {
                String idDescrip = AES.decifra(idCrip, chaveBob);
                if (idDescrip.equals(idBob)) {
                    String name = AES.decifra(contato, chaveBob);

                    if (name.equals(idAlice)) {

                       GerarChaveSessao();





                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }



            else if (Id1.equals(idAlice)) {
                try {
                    String idDescrip = AES.decifra(idCrip, chaveAlice);
                    if (idDescrip.equals(idAlice))
                    {
                        String name = AES.decifra(contato, chaveAlice);

                        if (name.equals(idBob)) {

                            GerarChaveSessao();



                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }


    }


    public void GerarChaveSessao()   //GERAR CHAVE DE SESSAO
    {
        UUID uuid = UUID.randomUUID();
        String strUuid = uuid.toString();
        this.chaveSessao = strUuid.substring(0,16);

    }

    public String EnviarChaveSessao_Alice(){
        return chaveSessao;



    }


}
