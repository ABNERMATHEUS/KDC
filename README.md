# Criptografia Simétrica  - Centro de distribuição de chaves (KDC)

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
</ul></li>
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

<li> KDC responde com uma mensagem cifrada
utilizando (k bob) , ou seja, apenas Bob consegue
decifrar;<br> A mensagem contém duas informações
direcionadas para Bob e duas para Alice. <br>
Informações direcionadas para Bob:
</li>

<ol>
