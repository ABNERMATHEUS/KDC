package com.company;

public class Main {

    public static void main(String[] args) {

        try {
            Bob_Alice Bob = new Bob_Alice("Bob", "Alice", "bolabolabolabola");
            Bob.CifraKDC();
            System.out.println("Chave de sessao Bob = "+Bob.getChaveSessao());
            Bob_Alice Alice = new Bob_Alice("Alice","Bob","macamacamacamaca");
            Alice.setChaveSessao(Bob.getChaveSessao());
            System.out.println("Chave de sessao Alice = "+Alice.getChaveSessao());
            Bob.AleatorioChave();
            Bob.CifraMensagem(Bob.getChaveOficial(),Bob.getChaveSessao());
            System.out.println("Mensagem cifrada de Bob enviando para Alice = "+Bob.getMensagemCifrada());
            Alice.setMensagemCifrada(Bob.getMensagemCifrada());
            Alice.DecifraMensagem(Alice.getMensagemCifrada(),Alice.getChaveSessao());
            System.out.println("Alice decifrou a mensagem = "+Alice.getMensagemDecifrada());
            Alice.FuncaoAleatorioAlice();
            System.out.println("Alice gerou a função, e a chave de sessao é = "+Alice.getChaveOficial());
            Alice.CifraMensagem(Alice.getChaveOficial(),Alice.getMensagemDecifrada());
            System.out.println("Alice cifrou mensagem = "+Alice.getMensagemCifrada());
            Bob.DecifraMensagem(Alice.getMensagemCifrada(),Bob.getChaveOficial());
            System.out.println("Bob decifra mensagem = "+Bob.getMensagemDecifrada());
            System.out.println("Bob compara");
            Bob.FuncaoAleatorioBob();
            Bob.Comparar(Bob.getChaveOficial());
            System.out.println("Bob começa conversar de maneira confidencial...");
            Bob.CifraMensagem("O Abner merece 100 nesse trabalho.",Bob.getChaveOficial());
            System.out.println("Bob envia mensagem para alice cifrada = "+Bob.getMensagemCifrada());
            Alice.DecifraMensagem(Bob.getMensagemCifrada(),Alice.getChaveOficial());
            System.out.println("Alice decifra mensagem de bob = "+Alice.getMensagemDecifrada());





























        }catch (Exception ex){
            ex.printStackTrace();
        }



    }
}
