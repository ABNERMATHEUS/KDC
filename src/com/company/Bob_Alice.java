package com.company;
import java.util.*;


public class Bob_Alice
{
    Random random = new Random();
    private String chavePublica;
    private String chaveSessao;
    private String id;
    private byte [] mensagemCifrada;



    public String getChaveOficial() {
        return chaveOficial;
    }

    private String chaveOficial;

    public String getMensagemDecifrada() {
        return mensagemDecifrada;
    }

    private String mensagemDecifrada;

    public void setMensagemCifrada(byte[] mensagem) {
        this.mensagemCifrada = mensagem;
    }



    public Bob_Alice(String id,String idContato,  String chavePublica) {
        this.id = id;
        this.idContato= idContato;
        this.chavePublica = chavePublica;

    }
    public byte[] getMensagemCifrada() {
        return mensagemCifrada;
    }



    public void setChaveSessao(String chaveSessao) {
        this.chaveSessao = chaveSessao;
    }

    private String idContato;
    KDC enviar = new KDC();

    public void PegarChave() {
        this.chaveSessao = enviar.getChaveSessao();
    }

    public String getChaveSessao() {
        return chaveSessao;
    }



    public void CifraKDC()
    {
        try{

            byte[]cifraId = AES.cifra(id, chavePublica);
            byte[]cifraContato = AES.cifra(idContato, chavePublica);
            enviar.Verificando(id,cifraId, cifraContato);   //ENVIANDO CHAVE PARA O KDC
            chaveSessao = enviar.getChaveSessao();


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }


    public void CifraMensagem(String texto,String chaveSessao) {
        try {
            byte[] cifraMensagem = AES.cifra(texto, chaveSessao);
            this.mensagemCifrada = cifraMensagem;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


        public void DecifraMensagem( byte[] texto, String chaveSessao){
            try {
                String decifraMensagem = AES.decifra(texto, chaveSessao);
                this.mensagemDecifrada = decifraMensagem;

            }catch (Exception ex){
                ex.printStackTrace();
            }



        }

        public void AleatorioChave ()
        {
            UUID uuid = UUID.randomUUID();
            String strUuid = uuid.toString();
            chaveOficial = strUuid.substring(0,16);

        }
        public void Comparar(String chave){
           if(this.chaveOficial.equals(this.mensagemDecifrada)){
               System.out.println("É usuário mesmo");
           }
           else{
               System.out.println("Não é usuário");

           }

        }



        public void FuncaoAleatorioAlice() {


            String nonce = this.mensagemDecifrada.substring(0,10);
            this.chaveOficial = nonce+"958477";


        }

        public void FuncaoAleatorioBob(){

            String nonce = this.chaveOficial.substring(0,10);
            this.chaveOficial = nonce+"958477";


        }



}
