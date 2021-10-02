<h1> Documentazione </h1>

<p> Il progetto è stato realizzato da: </p>

<ul>
    <li>Simone Gramegna (717041) mail: s.gramegna5@studenti.uniba.it
    </li>
    <li> Federico Canistro (723320) mail: f.canistro@studenti.uniba.it</li></ul>

<p> Il software realizzato utilizza l'algoritmo Apriori per scoprire pattern frequenti e pattern emergenti elaborando dati estratti da tabelle di database utilizzando il servizio MySQL </p>

<p>
    I dati di input dell'algoritmo sono:
</p>

<ul>
    <li>una collezione D di transazioni</li>
    <li>Ogni transazione è un vettore di coppie attributo-valore (item)</li>
    <li>Un minimo supporto minS</li>
</ul>

<p> Lo scopo è identificare gli insiemi di item (itemset o pattern) che occorrono con una frequenza minima (>= minS) in D </p>

<p> L'algoritmo ha applicazione nella market basket analysis per scoprire ad esempio i prodotti che compaiono spesso in uno stesso scontrino </p>

<p> I passi dall'algoritmo sono i seguenti: <p>
<ol>
    <li>Prende in input la tabella Target e la tabella </li>
</ol>







<h2> Guida di Installazione </h2>

<h3> Requisiti server </h3>

<p> Per utilizzare il server è necessario: </p>

<ul>
    <li>Installare MySql sul proprio computer</li>
    <li>Eseguire lo script sql (mysqlScript.sql) presetne nel percorso "../server/sql"</li>
    <li>Installare JRE 8</li>
    <li>Installare Maven  <a href="https://maven.apache.org/download.cgi"> (Download di Maven)</a> </li>
    <li> <i>Nota: La porta 3306 è preimpostata nel programma per accedere al database </i></li>
</ul>


<h3> Requisiti client ed estensione </h3>

<ul>
    <li>Server in ascolto</li>
    <li>Installare JRE 8</li>
    <li>Installare Maven  <a href="https://maven.apache.org/download.cgi"> (Download di Maven)</a></li>
</ul>

<h2> Guida utente </h2>

<h3> Compilazione e avvio del server </h3>

<ol>
    <li> Eseguire nella cartella /server il comando da terminale <code> mvn clean compile assembly:single </code> </li>
    <li>Il file jar eseguibile si trova nella cartella /target </li>
    <li>Avviare il server eseguendo il comando da terminale <code>java -jar epServer-1.0-jar-with-dependencies.jar</code></li>
    <li>Il server sarà automaticamente in ascolto sulla porta 8080</li>
</ol>
![]()


<h3> Compilazione e avvio del client </h3>

<ol>
    <li>Eseguire nella cartella /client il comando da terminale <code>mvn package</code></li>
    <li>Il file jar eseguibile si trova nella cartella /target </li>
    <li>Avviare il client tramite il comando <code>java -jar epClient-1.0.jar</code> specificando l'host (localhost) e la porta (porta di defuallt del server: 8080) </li></ol>
![]()


<h3> Compilazione e avvio dell'estensione </h3>

<ol>
    <li>Eseguire nella cartella /estensione il comando da terminale <code>mvn package</code></li>
    <li>Il file jar eseguibile si trova nella cartella /target </li>
    <li>Avviare il programma tramite il comando <code>java -jar epGui-1.0.jar</code></li></ol>
![]()

<h3> Guida utilizzo client </h3>

<p> Appena avviato il client, il programma cheide se eseguire una nuova (1) scoperta oppure prendere delle computazioni già presenti in archivio (2)</p>

![]()

<p> Digitando 1 e selezionando una nuova scoperta sulle tabelle, il programma chiede di inserire un valore di minimo supporto (maggiore di zero e minore o uguale a uno), per poi chiedere in input un valore minimo di grow rate (maggiore di zero) </p>

![]()

<p>
    Dopodiché viene richiesto in input il nome della tabella target (playtennisTarget) ed il nome della tabella di background (playtennisBackground)</p>

![]()

<p> In output avrò i prima i Pattern Emergenti e poi i Pattern Frequenti </p>

![]()

<p> Selezionando l'opzione 2 (risultati in archivio), i passi del programma sono gli stessi precredenti ma stavolta i risultati dati in output sono caricati da file presenti nella memoria secondaria</p>

![]()

<p> In entrambi i casi il programma chiede all'utente se vuole continuare per altre computazioni </p>

![]()

<p> Selezionando n (no) , il client termina l'esecuzione e viene chiuso </p>

![]()

<h3>
    Guida utilizzo estensione
</h3>

<p> La finestra principale presenta tre bottoni: uno per avviare una nuova scoperta, uno per prendere dei risultati in archivio e l'ultimo per uscire dal programma. Il client stavolta si connette in automatico alla porta di default del server </p>

![]()

<p> Cliccando sia su <i> Nuova scoperta </i> che su <i> Risultati in archivio </i> la finestra mostra una nuova schermata in cui è possibile inserire i valori di minimo supporto e di grow rate. Se i valori sono errati e non soddisfano l'intervallo richiesto, una serie di alert compaiono a video inoltre i due input sono resettati. 
Tramite due spinner è possibile selezionare le tabelle target e background già presenti
</p>

![]()

<p> Tramite il bottone in basso, i dati inseriti, se sono corretti, sono inviati al server </p>

![]()

<p> Appena la computazione termina, si apre una finestra di dialogo che mostra i pattern frequenti, i pattern emeergenti inoltre i dati inseriti dall'utente e inviati al server </p>

![]()

<p> Tramite il bottone in basso è possibile avviare una nuova computazione, ritornando alla finestra principale </p>

<h3> Esempi di test </h3>

