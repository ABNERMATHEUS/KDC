# Criptografia Simétrica - Centro de distribuição de chaves (KDC)

<h2>Conceito</h2>
<ul>
<li>O KDC (Key Distribution Center) é uma entidade
        terceira responsável por distribuir chaves;</li>
    <li>Esquema de distribuição amplamente utilizado;
    </li>
    <li>Cada usuário/processo compartilha uma chave
        única com o KDC;</li>
    <li>Baseado no conceito de hierarquia de chaves.</li>
</ul>


<h2>Hierarquia de chaves</h2>

<ul>

  <li>A comunicação entre duas entidades é realizada
        utilizando uma chave temporária, chamada de
        chave de sessão;
        Normalmente a duração/utilização dessa chave
        está relacionada a uma conexão, depois é
        descartada;</li>
    <li>Cada chave de sessão é obtida no KDC através
        de uma conexão criptografada utilizando a
        chave mestre, que é compartilhada entre o
        KDC e o usuário/processo.
    </li>
    <li>Ou seja, cada usuário/processo compartilha
        uma chave única com o KDC;</li>
    <li>Como é realizado esse compartilhamento de
        chaves? Normalmente de maneira física.</li>
</ul>




<h2>Cenário de Distribuição de Chaves</h2>

<ul>

  <li>Premissas:
        <ul>
            <li>
                Bob deseja conversar com Alice utilizando
                criptografia simétrica;</li>
            <li>
                Bob não compartilha uma chave simétrica com
                Alice;</li>
            <li>
                Bob compartilha uma chave simétrica com o KDC
                (k bob);</li>
            <li>
                Alice compartilha uma chave simétrica com o KDC
                (k alice)</li>
        </ul>
    </li>
</ul>

<h2>Passo a passo</h2>
<ol>
    <li> Bob requisita ao KDC uma chave de sessão
        (k sessão) para conversar com Alice, esta
        mensagem contém:
        <ul>
            <li>Identificador de Bob
            </li>

<li>Identificador de Alice
            </li>

         
 <li>Nonce (Identificador único: normalmente um número
                aleatório ou timestamp, tem a finalidade de
                identificar a requisição)
            </li>
        </ul>
</li>

 <li>KDC responde com uma mensagem cifrada
        utilizando (k bob) , ou seja, apenas Bob consegue
        decifrar;<br> A mensagem contém duas informações
        direcionadas para Bob e duas para Alice. <br>
        Informações direcionadas para Bob:
        <ul>
            <li>Chave de sessão (k sessao), que será utilizada para
                comunicar com Alice;</li>
            <li>Requisição inicial (Passo-1), com o Nonce incluso;
                Permite identificar e verificar a integridade da mensagem</li>
        </ul>
    </li>

<li>Informações direcionadas para Alice cifradas
        utilizando a (k alice):
        <ul>
            <li>Chave de sessão (k sessao), que será utilizada para
                comunicar com Alice;</li>
            <li>Identificador de Bob (por exemplo, IP)</li>
        </ul>
    </li>
    <li>Passo 3
        <ul>
            <li>Bob armazena (k sessão). para ser utilizada
                posteriormente e encaminha as informações que
                vieram do KDC para Alice ;</li>
<li>Como a mensagem está cifrada utilizando a
                (k alice), Alice sabe que a mensagem foi originada
                em KDC;</li>
<li>Dessa forma, Alice conhece o identificador de
                Bob e a chave de sessão.</li>
            <li>Nesse momento, Bob e Alice possuem a (k sessão). e
                podem conversar utilizando criptografia
                simétrica;</li>
        </ul>
    </li>

<li>Alice gera um nonce e encaminha para Bob,
        cifrando na (k sessão).</li>
    <li>Passo 5
        <ul>
            <li>Bob responde Alice executando uma função
                sobre o nonce recebido, cifrando na (k sessão).
                * Essa função pode ser uma operação matemática,
                por exemplo: incrementar o nonce.</li>
            <li># Observação: Esses dois últimos passos garantem
                a autenticação!</li>
        </ul>
    </li>
<ol>
