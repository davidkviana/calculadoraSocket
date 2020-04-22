# calculadoraSocket

Esta atividade pode ser feita de muitas formas para prover a comunicação entre um cliente e um servidor 
que precisam respectivamente, solicitar cálculos e prover os serviços de processar os cálculos. 

Mesmo na abordagem utilizando sockets há várias formas de se fazer isso. Foi feito neste exemplo o processamento 
das mensagens para realizar os cálculos que o cliente envia e o servidor interpreta e responde, nele existe a classe
com os métodos implementados que os eecuta de acordo as o tipo de operação contida na mensagem. Neste caso, alguns 
problemas podem ser encontrados como: a dificuldade em processar as mensagens, montar a lógica que chamará os métodos
corretos para executar os cálculos e verificar o protocolo.

Outro problema é caso o sistema precisasse ter várias maneiras de interpretar as operações, por exemplo: soma com 3 atributos, 
fatorial, logaritmo, e etc. Seriam criados códigos diferentes para cada novo tipo de método/operação que o servidor precisasse
realizar? Sim, para o "protocolo" entender o que cliente está pedindo neste caso essa poderia ser uma solução que só faria
crescer o problema.

A outra abordagem seria usar o conceito de serialização/desserialização do objeto, caso existisse a implementação dele tanto 
do lado cliente como do servidor, poderia diminuir o problema da interpretação e do algoritimo de processamento das mensagens. 
Contudo, o cliente também deverá ter a mesma classe do seu lado. E apesar de ser uma opção de implementação para "facilitar", 
ainda assim, seria bem trabalho o uso do socket.

Para executar esta tarefa devem ser criados os projetos no eclipse: calculadora_socket_cli e calculadora_socket_serv;
O servidor deve ser executado primeiro. O cliente só faz pedidos uma vez por execução, recebe a resposta, desconecta e encerra.
Já o Servidor fica o tempo todo executando, aguarda os pedidos, os processa, responde às requisições e encerra a comunicação 
com o cliente. E continua aguardando alguma requisição nova.
